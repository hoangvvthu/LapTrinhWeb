package murach.cart;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import murach.business.Cart;
import murach.business.Product;
import murach.business.LineItem;
import murach.data.ProductIO;

public class CartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String url = "/index.jsp";

        if (action == null) {
            action = "cart";
        }

        if (action.equals("cart")) {
            String productCode = request.getParameter("productCode");
            String quantityString = request.getParameter("quantity");
            String source = request.getParameter("source"); // 👈 Lấy giá trị source

            int quantity;
            try {
                quantity = Integer.parseInt(quantityString);
                if (quantity < 0) quantity = 1;
            } catch (NumberFormatException nfe) {
                quantity = 1;
            }

            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
            }

            String path = getServletContext().getRealPath("/WEB-INF/products.txt");
            Product product = ProductIO.getProduct(productCode, path);

            LineItem lineItem = new LineItem();
            lineItem.setProduct(product);
            lineItem.setQuantity(quantity);

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
        }

        else if (action.equals("checkout")) {
            session.removeAttribute("cart");
            url = "/checkout.jsp";
        }
        else if (action.equals("shop")) {
            response.sendRedirect("loadProducts");
            return;
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
