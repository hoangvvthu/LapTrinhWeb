package murach.cart;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import murach.data.*;
import murach.business.*;

public class CartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext sc = getServletContext();

        String action = request.getParameter("action");
        if (action == null) {
            action = "cart"; 
        }

        String url = "/index.jsp";

        if (action.equals("shop")) {
            HttpSession session = request.getSession();

            String fromCheckout = request.getParameter("fromCheckout");
            if ("true".equals(fromCheckout)) {
                session.removeAttribute("cart");
            }

            url = "/index.jsp";

        } else if (action.equals("cart")) {
            String productCode = request.getParameter("productCode");
            String quantityString = request.getParameter("quantity");

            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
            }

            int quantity;
            try {
                quantity = Integer.parseInt(quantityString);
                if (quantity < 0) quantity = 1;
            } catch (NumberFormatException nfe) {
                quantity = 1;
            }

            String path = sc.getRealPath("/WEB-INF/products.txt");
            Product product = ProductIO.getProduct(productCode, path);

            LineItem lineItem = new LineItem();
            lineItem.setProduct(product);
            lineItem.setQuantity(quantity);

            String source = request.getParameter("source");
            if ("index".equals(source)) {
                cart.addItem(lineItem);
            } else {
                if (quantity > 0) {
                    cart.updateItem(lineItem);
                } else {
                    cart.removeItem(lineItem);
                }
            }

            session.setAttribute("cart", cart);
            url = "/cart.jsp";

        } else if (action.equals("checkout")) {
            url = "/checkout.jsp";
        }

        sc.getRequestDispatcher(url)
                .forward(request, response);
    }
}

