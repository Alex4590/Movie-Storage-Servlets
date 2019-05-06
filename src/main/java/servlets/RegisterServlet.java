package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.util.*;
import app.*;

@WebServlet(name = "registerServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        Data data = new Data();
        Map<String,String> users = data.getUsers();

        PrintWriter responceWriter =  resp.getWriter();


        if (!login.isEmpty()) {

            for (Map.Entry<String,String> user : users.entrySet()) {

                String userName = user.getKey();
                String userPass = user.getValue();

                if (userName.equalsIgnoreCase(login)) {

                    if (userPass.equals(password)) {

                        responceWriter.println("Вы успешно авторизовались");

                        // responceWriter.println("login: " + login + "<br>password: " + password);

                    }
                }
            }

        } else {

            responceWriter.println("404 Not found");

        }

    }

}
