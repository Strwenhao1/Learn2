package com.bjsxt.goods;

public class goods {
    private int gid;
    private int gprice;
    private String gname;
    private int gamount;

    @Override
    public String toString() {
        return "goods{" +
                "gid=" + gid +
                ", gprice=" + gprice +
                ", gname='" + gname + '\'' +
                ", gamount=" + gamount +
                '}';
    }

    public goods() {
    }

    public goods(int gid, int gprice, String gname, int gamount) {
        this.gid = gid;
        this.gprice = gprice;
        this.gname = gname;
        this.gamount = gamount;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getGprice() {
        return gprice;
    }

    public void setGprice(int gprice) {
        this.gprice = gprice;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public int getGamount() {
        return gamount;
    }

    public void setGamount(int gamount) {
        this.gamount = gamount;
    }
}
