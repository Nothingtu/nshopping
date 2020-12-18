package domain;

public class Type {
    private int tid;
    private String tname;
    public Type(){}
    public Type(String tname,int tid){
        this.tname = tname;
        this.tid = tid;
    }
    public void setTid(int tid){this.tid = tid;}
    public int getTid(){return this.tid;}

    public void setTname(String tname){this.tname = tname;}
    public String getTname(){return this.tname;}
}
