package dao;

import domain.Commodity;

import java.sql.*;
import java.util.ArrayList;

public class CommodityDao extends Dao{


    public ArrayList<Commodity> selectTypeCommodity(String tid){
        String sql="SELECT CNAME,CPRICE ,CID FROM COMMODITY WHERE TID=?";
        ArrayList<Commodity> commodityList=new ArrayList<>();
        Connection conn= null;
        PreparedStatement pstat= null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection(url,name,password);
            pstat= conn.prepareStatement(sql);
            pstat.setString(1,tid);
            rs=pstat.executeQuery();
            while(rs.next()){
                String cname = rs.getString("cname");
                String cprice = rs.getString("cprice");
                String cid = rs.getString("cid");
                Commodity commodity= new Commodity();
                commodity.setCid(Integer.parseInt(cid));
                commodity.setCname(cname);
                commodity.setCprice(Float.parseFloat(cprice));
                commodityList.add(commodity);
            }
        }catch(Exception e){
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
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return  commodityList;
    }

    public Commodity selectOneCommodity(String cid){
        String sql="SELECT CNAME,CPRICE FROM COMMODITY WHERE CID=?";
        Commodity commodity=null;
        Connection conn= null;
        PreparedStatement pstat= null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection(url,name,password);
            pstat= conn.prepareStatement(sql);
            pstat.setString(1,cid);
            rs=pstat.executeQuery();
            while(rs.next()){
                String cname = rs.getString("cname");
                String cprice = rs.getString("cprice");
                commodity= new Commodity();
                commodity.setCname(cname);
                commodity.setCprice(Float.parseFloat(cprice));
            }
        }catch(Exception e){
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
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return  commodity;
    }

    public static void main(String[] args) {
        CommodityDao c= new CommodityDao();
        Commodity commodity = c.selectOneCommodity("3");
        System.out.println(commodity.getCname()+"---"+commodity.getCprice());

    }
}
