package service;
import dao.GoodsDao;
import domain.Cart;
import dao.CartDao;
import domain.Goods;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    private CartDao cd = new CartDao();
    private GoodsDao gd = new GoodsDao();
    public int AddToCart(Integer uid, Integer gid){
        return cd.addCartByUidAndGid(uid, gid);
    }

    public int DeleteFromCart(Integer uid, Integer gid){return cd.deleteCartByUidAndGid(uid,gid);}

    public List<Goods> ShowGoodsInCart(Integer uid){
        List<Cart> cart_list = cd.findCartByUid(uid);
        List<Goods> goods_list = new ArrayList();
        if(cart_list!=null){
            for(int i=0;i< cart_list.size();i++){
                goods_list.add(gd.findGoodsByGid(cart_list.get(i).getGid()));
            }
        }
        return goods_list;
    }
}
