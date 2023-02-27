package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.BrowsingRecord;

public class BrowsingRecordDao extends BaseDao{
    @Override
    public List<BrowsingRecord> getAllInfo(ResultSet rs) {
        List<BrowsingRecord> list = null;
        try{
            //判断rs是否为空
            if(null !=rs){
                //创建List
                list = new ArrayList<BrowsingRecord>();
                //遍历结果集
                while(rs.next()){
                    //创建goods对象
                    BrowsingRecord br = new BrowsingRecord();
                    //取出结果集中的值
                    br.setUid(rs.getInt("uid"));
                    br.setGid(rs.getInt("gid"));
                    br.setBtime(rs.getDate("btime"));
                    //将该对象添加进集合
                    list.add(br);
                }
            }
            //返回list
            return list;
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<BrowsingRecord> findAllBrowsingRecord() {
        String preparedSql = "SELECT * FROM browsingrecord;";
        Object[] param = null;
        List<BrowsingRecord> list = null;
        try {
            list = executeQuerySQL(preparedSql, param);
            return list;
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int addBrowsingRecord(BrowsingRecord br) {
        String preparedSql = "INSERT INTO browsingrecord VALUES(?,?,?);";
        Object[] param = new Object[3];
        param[0] = br.getUid();
        param[1] = br.getGid();
        param[2] = br.getBtime();
        int num = 0;
        try {
            num = executeUpdateSQL(preparedSql, param);
            return num;
        }catch(Exception e){
            e.printStackTrace();
            return num;
        }
    }
}

