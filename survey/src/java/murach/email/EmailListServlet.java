package murach.email;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import murach.business.User;

@WebServlet(name = "EmailListServlet", urlPatterns = {"/emailList"})
public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/index.html";
        String action = request.getParameter("action");
        if (action == null) action = "join";

        if (action.equals("join")) {
            url = "/index.html";
        } else if (action.equals("add")) {
            // Lấy dữ liệu từ form
            String firstName    = request.getParameter("firstName");
            String lastName     = request.getParameter("lastName");
            String email        = request.getParameter("email");
            String dateOfBirth  = request.getParameter("dateOfBirth");
            String hearAbout    = request.getParameter("hearAbout");

            String announceOffers = request.getParameter("announceOffers") != null ? "Yes" : "No";
            String announceEmails = request.getParameter("announceEmails") != null ? "Yes" : "No";

            String contactMethod = request.getParameter("contactMethod");

            User user = new User(firstName, lastName, email,
                                 dateOfBirth, hearAbout,
                                 announceOffers, announceEmails,
                                 contactMethod);

            request.setAttribute("user", user);
            url = "/thanks.jsp";
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}

