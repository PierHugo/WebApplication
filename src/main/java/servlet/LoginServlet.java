package servlet;

import controller.Controller;
import model.Admin;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (!username.equals("") && !password.equals(""))
        {
            password = DigestUtils.sha256Hex(password);
            String type = "";
            boolean isFound = false;
            Admin admin = Controller.getAdminDAO().findByUsernameAndPassword(username, password);

            if (admin != null)
            {
                isFound = true;
                type = "admin";
            }

            if (isFound)
            {
                HttpSession session = request.getSession(true);
                session.setAttribute("type", type);
                session.setAttribute("username", username);
                session.setAttribute("password", password);

                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            } else
            {
                request.setAttribute("error", "Login credentials do not match any account");
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }
        } else
        {
            request.setAttribute("error", "Please fill in all fields");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String type = request.getParameter("type");

        if (type != null)
        {
            HttpSession session = request.getSession(false);
            if (session != null)
                session.invalidate();
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        } else
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
