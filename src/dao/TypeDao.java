package dao;

import domain.Type;

import java.sql.*;
import java.util.ArrayList;

public class TypeDao extends Dao{
    private String sql="SELECT TID,TNAME FROM TYPE";

    //查询所有商品的种类
    public ArrayList<Type> selectAllType(){
        ArrayList<Type> typeList=new ArrayList<Type>();
        Connection conn=null;
        PreparedStatement pstat=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection(url,name,password);
            pstat = conn.prepareStatement(sql);
            rs = pstat.executeQuery();
            while(rs.next()){
                int tid = rs.getInt("tid");
                String tname = rs.getString("tname");
                Type type = new Type(tname,tid);
                typeList.add(type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(pstat!=null){
                try {
                    pstat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return typeList;
    }
}
