package com.bjsxt.exam_2.th3_exam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class test {
    public static void main(String[] args) {
//        Student s1 = new Student(1,"王一", 18);
//        Student s2 = new Student(2,"王二",27);
//        Student s3 = new Student(3,"王三",9);
//        Student s4 = new Student(4,"王四",29);
//        Student s5 = new Student(5,"王五",16);
//        Student s6 = new Student(6,"王六",16);

        Set<Student> set = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        String str;
        while (!(str = scanner.nextLine()).equals("exit")){
            String[] strs = str.split("#");
            set.add(new Student(Integer.parseInt(strs[0]),strs[1],Integer.parseInt(strs[2])));
        }

//        set.add(s1);
//        set.add(s2);
//        set.add(s3);
//        set.add(s4);
//        set.add(s5);
//        set.add(s6);
        Iterator<Student> it = set.iterator();
        BufferedWriter bw = null;

        try {
           bw = new BufferedWriter(new FileWriter("d:/as.txt"));
            while (it.hasNext()){
                Student s = it.next();
                bw.write(s.getSid()+" "+s.getSname()+" "+s.getSage());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bw!=null){
                    bw.close();
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }


    }
}
