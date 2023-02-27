package servlet;

import domain.Goods;
import service.GoodsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ShowGoodsServlet")
public class ShowGoodsServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsService gs = new GoodsService();
        // get goods list from database
        List<Goods> goodsList = gs.ShowGoods();
        // set goods list as an attribute in request object
        request.setAttribute("goodsList", goodsList);
        // forward request to shop.jsp page
        RequestDispatcher rd = request.getRequestDispatcher("mainshop.jsp");
        rd.forward(request, response);
    }
}
