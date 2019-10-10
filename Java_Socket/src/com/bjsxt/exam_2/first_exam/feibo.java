package com.bjsxt.exam_2.first_exam;

public class feibo {

    public static int no(int i) {
        if (i == 2) {
            return 1;
        }
        if (i == 1) {
            return 0;
        } else {
            return no(i - 1) + no(i - 2);
        }
    }
    public static void main(String[] args){
        System.out.println(no(10));
    }

}
