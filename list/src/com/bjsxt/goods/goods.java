package com.bjsxt.goods;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        goods goods = (goods) o;
        return gid == goods.gid &&
                gprice == goods.gprice &&
                gamount == goods.gamount &&
                Objects.equals(gname, goods.gname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gid, gprice, gname, gamount);
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
