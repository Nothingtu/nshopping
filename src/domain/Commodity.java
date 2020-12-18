package domain;

public class Commodity {
    private int cid;
    private String cname;
    private float cprice;

    public Commodity(){}
    public Commodity(int cid,String cname,float cprice){
        this.cid = cid;
        this.cname = cname;
        this.cprice = cprice;
    }
    public void setCid(int cid){this.cid = cid;}
    public int getCid(){return this.cid;}

    public void setCname(String cname){this.cname =cname;}
    public String getCname(){return this.cname;}

    public void setCprice(float cprice){this.cprice = cprice;}
    public float getCprice(){return this.cprice;}
}
