package servlet;
import domain.Goods;
import domain.Users;
import service.CartService;
import service.GoodsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/ShowCartServlet")
public class ShowCartServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartService cs = new CartService();

        HttpSession session = request.getSession();
        Integer uid = ((Users)session.getAttribute("user")).getUid();

        List<Goods> goodsInCart = cs.ShowGoodsInCart(uid);
        // set goods list as an attribute in request object
        request.setAttribute("goodsInCart", goodsInCart);
        // forward request to shop.jsp page
        RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
        rd.forward(request, response);
    }
}
