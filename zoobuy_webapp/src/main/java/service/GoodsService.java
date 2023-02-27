package service;

import dao.GoodsDao;
import domain.Goods;

import java.util.List;

public class GoodsService {
    private GoodsDao gd = new GoodsDao();
    public List<Goods> ShowGoods(){return gd.findAllGoods();}

    public List<Goods> SearchGoods(String keyword){
        return gd.findGoodsByKeyword(keyword);
    }

    public int BuyGoods(Integer gid){return gd.sellGoodsByGid(gid);}

    public Goods SearchGoodsByGid(Integer gid){
        return gd.findGoodsByGid(gid);
    }
}
