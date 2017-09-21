/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilities.UserService;

/**
 *
 * @author 677571
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String returnMessage = "";

        if (username == null || password == null || username == "" || password == "") {
            returnMessage = "Both fields must be entered";
            request.setAttribute("returnMessage", returnMessage);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } else {
            UserService userService = new UserService();
            boolean authenticated = userService.validate(username, password);
            if (authenticated) {
                request.setAttribute("username", username);

                getServletContext().getRequestDispatcher("/WEB-INF/mainPage.jsp").forward(request, response);
            } else {
                returnMessage = "Invalid Credentials";
                request.setAttribute("returnMessage", returnMessage);
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
        }

    }

}
