package murach.cart;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import murach.business.Product;
import murach.data.ProductIO;

public class ProductsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext sc = getServletContext();
        String path = sc.getRealPath("/WEB-INF/products.txt");

        List<Product> products = ProductIO.getProducts(path);

        request.setAttribute("products", products);

        String url = "/index.jsp";
        sc.getRequestDispatcher(url).forward(request, response);
    }
}
