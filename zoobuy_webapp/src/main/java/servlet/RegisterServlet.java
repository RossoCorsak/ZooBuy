package servlet;

import domain.Users;
import service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users user = new Users();
        UsersService us = new UsersService();

        // read form fields
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");

        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone);

        int uid = us.register(user);

        if(uid>0){
            // create a session object
            HttpSession session = request.getSession();
            // set username as an attribute of session
            session.setAttribute("user", user);
            // redirect to login_success.jsp page
            response.sendRedirect("register_success.jsp");

        } else{
            response.sendRedirect("register_fail.jsp");
        }


    }
}
