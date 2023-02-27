package servlet;

import domain.Goods;
import domain.TradingRecord;
import domain.Users;
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
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/addtrade")
public class AddTradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        TradingRecord tr = new TradingRecord();

        HttpSession session = request.getSession();
        Goods goods = (Goods)session.getAttribute("goods");
        Users users = (Users)session.getAttribute("user");
        tr.setUid(users.getUid());
        tr.setGid(goods.getGid());
        tr.setPrice(goods.getPrice());
        tr.setGname(goods.getGname());
        tr.setImage(goods.getImage());
        tr.setRealname(request.getParameter("realname"));
        tr.setAddress(request.getParameter("address"));
        tr.setPhone(request.getParameter("phone"));

        TradeService ts = new TradeService();

        int num = 0;
        num = ts.BuyGoodsInCart(tr);
        if(num>0){//购买成功
            RequestDispatcher rd = request.getRequestDispatcher("trade_success.jsp");
            rd.forward(request, response);
        } else{
            RequestDispatcher rd = request.getRequestDispatcher("trade_fail.jsp");
            rd.forward(request, response);
        }


    }
}
