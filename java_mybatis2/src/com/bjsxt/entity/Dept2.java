package com.bjsxt.entity;

public class Dept2 {
    private int deptNo;
    private String deptName;
    private String deptLoc;

    public Dept2() {
    }

    @Override
    public String toString() {
        return "Dept2{" +
                "deptNo=" + deptNo +
                ", deptName='" + deptName + '\'' +
                ", deptLoc='" + deptLoc + '\'' +
                '}';
    }

    public Dept2(int deptNo, String deptName, String deptLoc) {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.deptLoc = deptLoc;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptLoc() {
        return deptLoc;
    }

    public void setDeptLoc(String deptLoc) {
        this.deptLoc = deptLoc;
    }
}
