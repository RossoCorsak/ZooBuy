package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import domain.Users;
import jdbcUtil.DBUtil;

public class UsersDao extends BaseDao{
    @Override
    public List<Users> getAllInfo(ResultSet rs) {
        List<Users> list = null;
        try{
            //判断rs是否为空
            if(null !=rs){
                //创建List
                list = new ArrayList<Users>();
                //遍历结果集
                while(rs.next()){
                    //创建goods对象
                    Users users = new Users();
                    //取出结果集中的值
                    users.setUid(rs.getInt("uid"));
                    users.setUsername(rs.getString("username"));
                    users.setPassword(rs.getString("password"));
                    users.setPhone(rs.getString("phone"));
                    //将该对象添加进集合
                    list.add(users);
                }
            }
            //返回list
            return list;
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //返回所有用户
    public List<Users> findAllUsers() {
        String preparedSql = "SELECT * FROM users";
        Object[] param = null;
        List<Users> list = null;
        try {
            list = executeQuerySQL(preparedSql, param);
            return list;
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    //通过uid查找用户
    public Users findUsersByUid(Integer uid) {
        String preparedSql = "SELECT * FROM users where uid = ?";
        Object[] param = new Object[1];
        param[0] = uid;
        List<Users> list = null;
        Users users = null;
        try {
            list = executeQuerySQL(preparedSql, param);
            if(list != null && !list.isEmpty()) {
                users = list.get(0);
            }
            return users;
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    //通过uid查找用户
    public Users findUsersByUidAndPassword(Users users) {
        String preparedSql = "SELECT * FROM users WHERE uid = ? AND password = ?";
        Object[] param = new Object[2];
        param[0] = users.getUid();
        param[1] = users.getPassword();
        List<Users> list = null;
        Users bean = null;
        try {
            list = executeQuerySQL(preparedSql, param);
            if(list != null) {
                if(!list.isEmpty()){
                    bean = list.get(0);
                }
            }
            return bean;
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    //通过phone查找
    public Users findUsersByPhone(String phone) {
        String preparedSql = "SELECT * FROM users where phone = ?";
        Object[] param = new Object[1];
        param[0] = phone;
        List<Users> list = null;
        Users users = null;
        try {
            list = executeQuerySQL(preparedSql, param);
            if(list != null && !list.isEmpty()) {
                users = list.get(0);
            }
            return users;
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

    //新增用户，返回自增的用户id
    public int addNewUsers(Users users) {
        String preparedSql = "INSERT INTO users VALUES(NULL,?,?,?);";
        //String querySql = "SELECT LAST_INSERT_ID();";
        Object[] param = new Object[3];
        param[0] = users.getUsername();
        param[1] = users.getPassword();
        param[2] = users.getPhone();
        int uid = 0;
        try {
            uid = executeInsertSQL(preparedSql, param);
            users.setUid(uid);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        return uid;
    }

    //删除用户，返回收影响行数
    public int deleteUsersByUid(Integer uid) {
        String preparedSql = "DELETE FROM users WHERE uid = ?;";
        Object[] param = new Object[1];
        param[0] = uid;
        int num = 0;
        try {
            num = executeUpdateSQL(preparedSql, param);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        return num;
    }
}
