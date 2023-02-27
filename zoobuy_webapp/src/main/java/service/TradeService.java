package service;
import dao.CartDao;
import domain.*;
import service.CartService;
import dao.TradingRecordDao;
import dao.GoodsDao;

import java.util.List;

public class TradeService {
    private TradingRecordDao trd = new TradingRecordDao();
    private GoodsDao gd = new GoodsDao();

    private CartDao cd = new CartDao();

    public int BuyGoodsInCart(TradingRecord tr){
        int num = 0;
        num = gd.sellGoodsByGid(tr.getGid());
        if(num==0){
            return num;
        }
        num = cd.deleteCartByUidAndGid(tr.getUid(),tr.getGid());
        num = trd.addTradingRecord(tr);
        return num;
    }

    public List<TradingRecord> ShowTradingRecordOfUsers(Integer uid){
        return trd.findAllTradingRecordByUid(uid);
    }
}
