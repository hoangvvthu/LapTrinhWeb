package murach.download;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import murach.business.User;
import murach.data.UserIO;
import murach.util.CookieUtil;

public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException, ServletException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "viewAlbums";
        }

        String url = "/index.jsp";
        if (action.equals("viewAlbums")) {
            url = "/index.jsp";
        } else if (action.equals("checkUser")) {
            url = checkUser(request, response);
        } else if (action.equals("view_cookies")) {
            url = "/view_cookies.jsp";
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException, ServletException {

        String action = request.getParameter("action");
        String url = "/index.jsp";

        if (action.equals("registerUser")) {
            url = registerUser(request, response);
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    private String checkUser(HttpServletRequest request,
                             HttpServletResponse response) {

        String productCode = request.getParameter("productCode");
        HttpSession session = request.getSession();
        session.setAttribute("productCode", productCode);
        User user = (User) session.getAttribute("user");

        String url;
        if (user == null) {
            Cookie[] cookies = request.getCookies();
            String emailAddress =
                    CookieUtil.getCookieValue(cookies, "emailCookie");

            if (emailAddress == null || emailAddress.equals("")) {
                // không có cookie → bắt đăng ký
                url = "/register.jsp";
            } else {
                // có cookie → kiểm tra trong file
                ServletContext sc = getServletContext();
                String path = sc.getRealPath("/WEB-INF/EmailList.txt");
                user = UserIO.getUser(emailAddress, path);

                if (user == null) {
                    // cookie không khớp user trong file → bắt đăng ký lại
                    url = "/register.jsp";
                } else {
                    session.setAttribute("user", user);
                    url = "/" + productCode + "_download.jsp";
                }
            }
        } else {
            url = "/" + productCode + "_download.jsp";
        }
        return url;
    }


    private String registerUser(HttpServletRequest request,
                                HttpServletResponse response) {

        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        User user = new User();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        ServletContext sc = getServletContext();
        String path = sc.getRealPath("/WEB-INF/EmailList.txt");
        UserIO.add(user, path);

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        Cookie c = new Cookie("emailCookie", email);
        c.setMaxAge(60 * 60 * 24 * 365 * 2);
        c.setPath("/");
        response.addCookie(c);

        String productCode = (String) session.getAttribute("productCode");
        String url = "/" + productCode + "_download.jsp";
        return url;
    }
}
