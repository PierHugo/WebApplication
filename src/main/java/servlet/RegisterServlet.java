package servlet;

import controller.Controller;
import model.Admin;
import model.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String age = request.getParameter("age");
        String city = request.getParameter("city");
        String check_admin = request.getParameter("check_admin");

        boolean isCreated = false;

        if (username.equals("") || password.equals("") || firstName.equals("") || lastName.equals("") || age.equals("") || city.equals(""))
        {
            request.setAttribute("error", "Please fill in all fields");
            RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
            dispatcher.forward(request, response);
            return;
        }
        System.out.println(check_admin);
        if (check_admin != null)
        {
            Admin admin = new Admin(firstName, lastName, username, DigestUtils.sha256Hex(password), age, city);
            isCreated = Controller.getAdminDAO().saveOrUpdate(admin);
        } else
        {
            User user = new User(firstName, lastName, username, DigestUtils.sha256Hex(password), age, city);
            isCreated = Controller.getUserDAO().saveOrUpdate(user);
        }

        if (isCreated)
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        } else
        {
            request.setAttribute("error", "Registration failed");
            RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setAttribute("error", "");
        RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
        dispatcher.forward(request, response);
    }
}
