package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.TradingRecord;
import jdbcUtil.DBUtil;

public class TradingRecordDao extends BaseDao {
    @Override
    public List<TradingRecord> getAllInfo(ResultSet rs) {
        List<TradingRecord> list = null;
        try{
            //判断rs是否为空
            if(null !=rs){
                //创建List
                list = new ArrayList<TradingRecord>();
                //遍历结果集
                while(rs.next()){
                    //创建goods对象
                    TradingRecord tr = new TradingRecord();
                    //取出结果集中的值
                    tr.setTid(rs.getInt("tid"));
                    tr.setUid(rs.getInt("uid"));
                    tr.setGid(rs.getInt("gid"));
                    tr.setPrice(rs.getDouble("price"));
                    tr.setGname(rs.getString("gname"));
                    tr.setImage(rs.getString("image"));
                    tr.setRealname(rs.getString("realname"));
                    tr.setPhone(rs.getString("phone"));
                    tr.setAddress(rs.getString("address"));
                    tr.setPay(rs.getDouble("pay"));
                    //将该对象添加进集合
                    list.add(tr);
                }
            }
            //返回list
            return list;
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //查看所有交易记录
    public List<TradingRecord> findAllTradingRecord() {
        String preparedSql = "SELECT * FROM tradingrecord;";
        Object[] param = null;
        List<TradingRecord> list = null;
        try {
            list = executeQuerySQL(preparedSql, param);
            return list;
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    //查看某个用户的交易记录
    public List<TradingRecord> findAllTradingRecordByUid(Integer uid) {
        String preparedSql = "SELECT * FROM tradingrecord WHERE uid = ?;";
        Object[] param = new Object[1];
        param[0] = uid;
        List<TradingRecord> list = null;
        try {
            list = executeQuerySQL(preparedSql, param);
            return list;
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public TradingRecord findTradingRecordByTid(Integer tid) {
        String preparedSql = "SELECT * FROM tradingrecord WHERE tid = ?;";
        Object[] param =  new Object[1];
        param[0] = tid;
        List<TradingRecord> list = null;
        TradingRecord tr = null;
        try {
            list = executeQuerySQL(preparedSql, param);
            if(list!=null&&!list.isEmpty()) {
                tr = list.get(0);
            }
            return tr;
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

    //下单时调用
    public int addTradingRecord(TradingRecord tr) {
        String preparedSql = "INSERT INTO tradingrecord VALUES(null,?,?,?,?,?,?,?,?,0);";
        Object[] param = new Object[8];
        param[0]=tr.getUid();
        param[1]=tr.getGid();
        param[2]=tr.getPrice();
        param[3]=tr.getGname();
        param[4]=tr.getImage();
        param[5]=tr.getRealname();
        param[6]=tr.getPhone();
        param[7]=tr.getAddress();
        int tid = 0;
        try {
            tid = executeInsertSQL(preparedSql,param);
            tr.setTid(tid);
            return tid;
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
            return tid;
        }

    }

    //付款后调用
    public int payTradingRecordByTid(Integer tid) {
        String preparedSql = "UPDATE tradingrecord SET pay = price WHERE tid = ?;";
        Object[] param = new Object[1];
        param[0]=tid;
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
