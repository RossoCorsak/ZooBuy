package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



import domain.Goods;
import jdbcUtil.DBUtil;
import dao.BaseDao;

public class GoodsDao extends BaseDao {

    @Override
    public List<Goods> getAllInfo(ResultSet rs) {
        List<Goods> list = null;
        try{
            //判断rs是否为空
            if(null !=rs){
                //创建List
                list = new ArrayList<Goods>();
                //遍历结果集
                while(rs.next()){
                    //创建goods对象
                    Goods goods = new Goods();
                    //取出结果集中的值
                    goods.setGid(rs.getInt("gid"));
                    goods.setGname(rs.getString("gname"));
                    goods.setPrice(rs.getDouble("price"));
                    goods.setStocks(rs.getInt("stocks"));
                    goods.setImage(rs.getString("image"));
                    //将该对象添加进集合
                    list.add(goods);
                }
            }
            //返回list
            return list;
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //返回所有商品
    public List<Goods> findAllGoods() {
        String preparedSql = "SELECT * FROM goods;";
        Object[] param = null;
        List<Goods> list = null;
        try {
            list = executeQuerySQL(preparedSql, param);
            return list;
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }


    }

    //通过关键词查找，只有一个关键词
    public List<Goods> findGoodsByKeyword(String keyword){
        String preparedSql = "SELECT * FROM goods WHERE gname LIKE ?;";
        String gname = "%" + keyword.replaceAll(" ", "%") + "%";//实现多关键词
        Object[] param = new Object[1];
        param[0] = gname;
        List<Goods> list = null;
        try {
            list = executeQuerySQL(preparedSql, param);
            return list;
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Goods findGoodsByGid(Integer gid) {
        String preparedSql = "SELECT * FROM goods where gid = ?;";
        Object[] param = new Object[1];
        param[0] = gid;
        List<Goods> list = null;
        Goods goods = null;
        try {
            list = executeQuerySQL(preparedSql, param);
            if(list != null && !list.isEmpty()) {
                goods = list.get(0);
            }
            return goods;
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    //执行insert，返回自增id
    public int executeInsertSQL(String preparedSql, Object[] param) throws ClassNotFoundException{
        int num = 0;
        int id = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        /* 处理SQL,执行SQL */
        try {
            conn = DBUtil.getConectionDb(); // 得到数据库连接
            pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setObject(i + 1, param[i]); // 为预编译sql设置参数
                }
            }
            num = pstmt.executeUpdate();// 执行SQL语句
            pstmt = conn.prepareStatement("SELECT LAST_INSERT_ID();");
            rs = pstmt.executeQuery();
            while(rs.next()) {
                id = rs.getInt("LAST_INSERT_ID()");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 处理SQLException异常
        } finally {
            try {
                DBUtil.CloseDB(null, pstmt, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return id;
    }

    //新增商品，返回自增的商品id
    public int addNewGoods(Goods goods) {
        String preparedSql = "INSERT INTO goods VALUES(NULL,?,?,?,?);";
        //String querySql = "SELECT LAST_INSERT_ID();";
        Object[] param = new Object[4];
        param[0] = goods.getGname();
        param[1] = goods.getPrice();
        param[2] = goods.getStocks();
        param[3] = goods.getImage();
        int gid = 0;
        try {
            gid = executeInsertSQL(preparedSql, param);
            goods.setGid(gid);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        return gid;
    }

    //删除商品，返回收影响行数
    public int deleteGoodsByGid(Integer gid) {
        String preparedSql = "DELETE FROM goods WHERE gid = ?;";
        Object[] param = new Object[1];
        param[0] = gid;
        int num = 0;
        try {
            num = executeUpdateSQL(preparedSql, param);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        return num;
    }

    //更新库存，返回受影响行数
    public int updateGoodsStocksByGid(Integer gid, Integer stocks) {
        String preparedSql = "UPDATE goods SET stocks = ? WHERE gid = ?;";
        Object[] param = new Object[2];
        param[0] = stocks;
        param[1] = gid;
        int num = 0;
        try {
            num = executeUpdateSQL(preparedSql,param);
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        return num;
    }

    //更新价格
    public int updateGoodsPriceByGid(Integer gid, double price) {
        String preparedSql = "UPDATE goods SET price = ? WHERE gid = ?;";
        Object[] param = new Object[2];
        param[0] = price;
        param[1] = gid;
        int num = 0;
        try {
            num = executeUpdateSQL(preparedSql,param);
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        return num;
    }

    //更新照片路径，主要用于生成gid后将照片名改为gid
    public int updateGoodsImageByGid(Integer gid, String image) {
        String preparedSql = "UPDATE goods SET image = ? WHERE gid = ?;";
        Object[] param = new Object[2];
        param[0] = image;
        param[1] = gid;
        int num = 0;
        try {
            num = executeUpdateSQL(preparedSql,param);
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        return num;
    }

    //更新名称
    public int updateGoodsGnameByGid(Integer gid, String gname) {
        String preparedSql = "UPDATE goods SET gname = ? WHERE gid = ?;";
        Object[] param = new Object[2];
        param[0] = gname;
        param[1] = gid;
        int num = 0;
        try {
            num = executeUpdateSQL(preparedSql,param);
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        return num;
    }

    public int sellGoodsByGid(Integer gid) {
        String preparedSql = "UPDATE goods SET stocks = stocks - 1 WHERE gid = ?;";
        Object[] param = new Object[1];
        param[0] = gid;
        int num = 0;
        try {
            num = executeUpdateSQL(preparedSql,param);
            return num;
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
            return num;
        }
    }

}
