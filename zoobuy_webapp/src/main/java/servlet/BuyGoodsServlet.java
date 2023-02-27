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

@WebServlet("/buygoods")
public class BuyGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsService gs = new GoodsService();
        Goods goods = gs.SearchGoodsByGid(Integer.parseInt(request.getParameter("gid")));

        HttpSession session = request.getSession();
        session.setAttribute("goods", goods);

        RequestDispatcher rd = request.getRequestDispatcher("tradeinfo.jsp");
        rd.forward(request, response);
    }
}
