package com.bjsxt.entity;

import com.bjsxt.test.MyFieldAnno;
import com.bjsxt.test.MyTableAnno;

@MyTableAnno(tableName="tb_student")
public class Student {
    @MyFieldAnno(name = "id",type = "int",length = 4)
    private int id;
    @MyFieldAnno(name = "name",type = "varchar",length = 20)
    private String name;
    @MyFieldAnno(name = "age",type = "int" , length = 4)
    private int age;


    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
