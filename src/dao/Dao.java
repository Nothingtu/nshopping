package dao;

/**
 * 此处设计一个接口  方便每个dao共用url name password
 */
public class Dao  {
    protected String url = "jdbc:mysql://localhost:3306/nshopping?serverTimezone=CST&characterEncoding=UTF-8";
    protected String name="root";
    protected String password="root18268174991@";
}
