package servlet;

import domain.*;
import service.CartService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addcart")
public class AddCartServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartService cs = new CartService();

        HttpSession session = request.getSession();
        Users user = (Users)session.getAttribute("user");

        int gid = Integer.parseInt(request.getParameter("gid"));

        System.out.println(user.getUid());
        System.out.println(gid);

        cs.AddToCart(user.getUid(),gid);
    }
}
