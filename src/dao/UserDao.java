package dao;

import domain.User;

import java.sql.*;

public class UserDao extends Dao{
    private String sql="SELECT UNAME,UPASSWORD FROM USER WHERE UNAME=?";

    //根据用户名查询用户的信息user
    public User selectOne(String uname){
        User user=null;
        Connection conn=null;
        PreparedStatement pstat=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection(url,name,password);
            pstat = conn.prepareStatement(sql);
            pstat.setString(1,uname);
            rs = pstat.executeQuery();
            while(rs.next()){
                String password = rs.getString("upassword");
                user= new User(uname,password);
                System.out.println(password);
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
        return user;
    }

}
