package com.bjsxt.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception{
        Class<?> clazz = Class.forName("com.bjsxt.entity.Student");
        MyTableAnno MyTableAnno = clazz.getAnnotation(MyTableAnno.class);
        String tableName = MyTableAnno.tableName();

        Field[] fields = clazz.getDeclaredFields();
        Map<String,String> map =  new LinkedHashMap<>();
        for (Field f:fields){
            MyFieldAnno annotation1 = f.getAnnotation(MyFieldAnno.class);
            String name = annotation1.name();
            String type = annotation1.type();
            int length  = annotation1.length();
            //id int(4)

            map.put(name,type+"("+length+")");

        }
//        System.out.println(map);
        Set<String> strings = map.keySet();

        StringBuffer buffer = new StringBuffer();
        buffer.append("create table ");
        buffer.append(tableName);
        buffer.append(" ");
        buffer.append("(");
        for (String str:strings){
            buffer.append(str);
            buffer.append(" ");
            buffer.append(map.get(str));
            buffer.append(",");
        }


        buffer.deleteCharAt(buffer.length()-1);
        buffer.append(")");
        System.out.println(buffer.toString());
//        Connection connection = DBUtil.getConnection();
        int i = DBUtil.executeUpdate(buffer.toString(), new Object[]{});
        System.out.println(buffer.toString());
        System.out.println(i);

    }
}
