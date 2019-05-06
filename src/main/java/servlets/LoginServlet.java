package servlets;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import app.*;

@WebServlet(name="LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        Data data = new Data();
        Map<String, String> users = data.getUsers();


        PrintWriter responceWriter =  resp.getWriter();
        responceWriter.println("<body>");

        if (!login.isEmpty()) {

            for (Map.Entry<String,String> user : users.entrySet()) {

                String userName = user.getKey();
                String userPass = user.getValue();

                if (userName.equalsIgnoreCase(login)) {
                    if (userPass.equals(password)) {

                        responceWriter.println("You have successfully entered");
                    } else {

                        responceWriter.println("Not successfully");
                    }
                }
            }

        } else {
            responceWriter.println("404 Not Found");
        }

    }
}
