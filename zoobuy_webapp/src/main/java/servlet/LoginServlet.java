package servlet;

import domain.*;
import service.UsersService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users user = new Users();
        UsersService us = new UsersService();

        // read form fields
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        user.setUid(Integer.parseInt(username));
        user.setPassword(password);

        System.out.println(user.getUid());
        System.out.println(user.getPassword());


        Users lguser = us.login(user);

        if(lguser!=null){
            // create a session object
            HttpSession session = request.getSession();
            // set username as an attribute of session
            session.setAttribute("user", lguser);
            // redirect to login_success.jsp page
            response.sendRedirect("ShowGoodsServlet");

        } else{
            response.sendRedirect("login_fail.jsp");
        }


    }
}
