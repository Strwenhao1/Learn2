package com.bjsxt.Set;

import java.util.Objects;

public class Student implements Comparable{
    private int sid;
    private String name;
    private int course;
    private  int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return sid == student.sid &&
                course == student.course &&
                age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, name, course, age);
    }

    @Override
    public int compareTo(Object o) {
        return this.sid -((Student)o).sid;
    }

    public Student() {
    }

    public Student(int sid, String name, int age, int course) {
        this.sid = sid;
        this.name = name;
        this.course = course;
        this.age = age;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", course=" + course +
                ", age=" + age +
                '}';
    }
}
