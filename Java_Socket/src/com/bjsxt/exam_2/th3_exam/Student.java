package com.bjsxt.exam_2.th3_exam;

import java.util.Objects;

public class Student implements Comparable<Student>{
    private int sid;
    private String sname;
    private int sage;

    public Student() {
    }

    public Student(int sid, String sname, int sage) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return sid == student.sid &&
                sage == student.sage &&
                Objects.equals(sname, student.sname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, sname, sage);
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                '}';
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    @Override
    public int compareTo(Student o) {
        if(o.getSage()>this.getSage()){
            return -1;
        }else if(o.getSage()<this.getSage()){
            return 1;
        }else if(this.getSid()>o.getSid()){
            return 1;
        }else if(this.getSid()<o.getSid()){
            return -1;
        }else {
            return 0;
        }

    }
}
