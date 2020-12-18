package domain;

public class User {
    private String uname;
    private String upassword;

    public User(){}
    public User(String uname,String upassword){
        this.uname = uname;
        this.upassword = upassword;
    }
    public void setUname(String uname){this.uname = uname;}
    public String getUname(){return this.uname;}

    public void setUpassword(String upassword){this.upassword = upassword;}
    public String  getUpassword(){return this.upassword;}
}
