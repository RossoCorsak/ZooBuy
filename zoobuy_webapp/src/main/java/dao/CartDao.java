package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.Cart;

public class CartDao extends BaseDao{
    @Override
    public List<Cart> getAllInfo(ResultSet rs) {
        List<Cart> list = null;
        try{
            //判断rs是否为空
            if(null !=rs){
                //创建List
                list = new ArrayList<Cart>();
                //遍历结果集
                while(rs.next()){
                    //创建goods对象
                    Cart cart = new Cart();
                    //取出结果集中的值
                    cart.setUid(rs.getInt("uid"));
                    cart.setGid(rs.getInt("gid"));
                    //cart.setNum(rs.getInt("num"));
                    //将该对象添加进集合
                    list.add(cart);
                }
            }
            //返回list
            return list;
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //返回某一用户购物车中的记录
    public List<Cart> findCartByUid(Integer uid) {
        String preparedSql = "SELECT * FROM cart where uid = ?;";
        Object[] param = new Object[1];
        param[0] = uid;
        List<Cart> list = null;
        try {
            list = executeQuerySQL(preparedSql, param);
            return list;
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Cart findCartByUidAndGid(Integer uid, Integer gid) {
        String preparedSql = "SELECT * FROM cart where uid = ? and gid = ?;";
        Object[] param = new Object[2];
        param[0] = uid;
        param[1] = gid;
        List<Cart> list = null;
        Cart cart = null;
        try {
            list = executeQuerySQL(preparedSql, param);
            if(list != null && !list.isEmpty()) {
                cart = list.get(0);
            }
            return cart;
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int deleteCartByUidAndGid(Integer uid, Integer gid) {
        String preparedSql = "DELETE FROM cart WHERE uid = ? AND gid = ?;";
        Object[] param = new Object[2];
        param[0] = uid;
        param[1] = gid;
        int num = 0;
        try {
            num = executeUpdateSQL(preparedSql, param);
            return num;
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            return num;
        }
    }

    public int addCartByUidAndGid(Integer uid, Integer gid) {
        String preparedSql = "INSERT INTO cart VALUES(?,?);";
        Object[] param = new Object[2];
        param[0] = uid;
        param[1] = gid;
        int num = 0;
        try {
            num = executeUpdateSQL(preparedSql, param);
            return num;
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            return num;
        }
    }

}

