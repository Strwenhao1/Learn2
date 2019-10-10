package com.bjsxt.clazz;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class TestClass1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        //1.获取一个类的结构信息（类对象 Class对象）
        Class clazz = Class.forName("com.bjsxt.why.Dog");

        //2.从类对象中获取类的各种结构信息
        //2.1 获取基本结构信息
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getSuperclass());
        System.out.println(Arrays.toString(clazz.getInterfaces()));


        //2.2 获取构造方法
        //Constructor[] constructors = clazz.getConstructors();//只能得到public修饰的构造方法
        Constructor[] constructors = clazz.getDeclaredConstructors(); //可以得到所有的构造方法
        System.out.println(constructors.length);
        for(Constructor con :constructors){
            //System.out.println(con.toString());
            System.out.println(con.getName() + "||" + Modifier.toString(con.getModifiers())+"  ||"
                    + Arrays.toString(con.getParameterTypes()));
        }

        //Constructor con = clazz.getConstructor();//获取无参数构造方法
        //Constructor con = clazz.getConstructor(String.class,String.class);
        Constructor con = clazz.getDeclaredConstructor(String.class,String.class);
        System.out.println(con);


        //2.3 获取属性
        System.out.println("------------------");
//        Field[] fields = clazz.getFields();
        Field [] fields = clazz.getDeclaredFields();
        for (Field field:fields){
            System.out.println(field);
        }


        //2.3 获取方法

    }
}
