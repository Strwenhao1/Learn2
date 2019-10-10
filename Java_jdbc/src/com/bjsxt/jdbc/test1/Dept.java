package com.bjsxt.jdbc.test1;

public class Dept {
    private int deptno;
    private String dname;
    private String location;

    public Dept() {
    }

    public Dept(int deptno, String dname, String location) {
        this.deptno = deptno;
        this.dname = dname;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno='" + deptno + '\'' +
                ", dname='" + dname + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
