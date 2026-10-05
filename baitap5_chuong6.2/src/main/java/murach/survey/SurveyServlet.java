package murach.survey;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import murach.business.User;

@WebServlet(name = "SurveyServlet", urlPatterns = {"/survey"})
public class SurveyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null || "join".equals(action)) {
            // Hiển thị lại form
            getServletContext().getRequestDispatcher("/index.html")
                    .forward(req, resp);
        } else {
            // Trường hợp khác thì xử lý như POST
            doPost(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String action = req.getParameter("action");
        if (action == null) action = "add";

        if ("add".equals(action)) {
            // Lấy dữ liệu form
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String email = req.getParameter("email");
            String heardFrom = req.getParameter("heardFrom");
            String contactVia = req.getParameter("contactVia");
            String[] wantsArr = req.getParameterValues("wantsUpdates");
            String wantsUpdates = (wantsArr != null && wantsArr.length > 0)
                    ? String.join(", ", wantsArr) : "No";

            // Tạo User + set vào request
            User user = new User(firstName, lastName, email, heardFrom, wantsUpdates, contactVia);
            req.setAttribute("user", user);

            // Sang trang cảm ơn
            getServletContext().getRequestDispatcher("/thanks.jsp")
                    .forward(req, resp);
        } else {
            // fallback: quay về form
            getServletContext().getRequestDispatcher("/index.html")
                    .forward(req, resp);
        }
    }
}
