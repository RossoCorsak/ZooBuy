package servlet;
import domain.Goods;
import domain.TradingRecord;
import domain.Users;
import service.CartService;
import service.GoodsService;
import service.TradeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/ShowTradingRecordServlet")
public class ShowTradingRecordServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TradeService ts = new TradeService();

        HttpSession session = request.getSession();
        Integer uid = ((Users)session.getAttribute("user")).getUid();

        List<TradingRecord> tradeOfUsers = ts.ShowTradingRecordOfUsers(uid);
        // set goods list as an attribute in request object
        request.setAttribute("tradeOfUsers", tradeOfUsers);
        // forward request to shop.jsp page
        RequestDispatcher rd = request.getRequestDispatcher("mytrade.jsp");
        rd.forward(request, response);
    }
}
