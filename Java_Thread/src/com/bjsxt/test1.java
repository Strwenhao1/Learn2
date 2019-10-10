package com.bjsxt;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public  class test1 implements Serializable {
    public int j = 0;
    public static void main(String[] args)  {

        int d = 0;
        test1 test1 = new test1();



        System.out.println( test1.pic(20));

        int i = new int[]{1,5}.length;

    }


    int pic(int pi){
        if(pi/3>0){
            j += pi/3;
            pic((pi%3)+(pi/3));
        }
        return j;
    }

    public void sort(Object [] arr){
        //输出排序前数组 1分
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        //大循环，一共n个元素，达到最终有序，至多n-1趟比较
        Object temp;
        for(int i=0;i<arr.length-1 ;i++){
            //定义一个符号量
            boolean  flag = true;//没有交换，有序
            //小循环
            for(int j=0;j<arr.length-1-i;j++){
                //如果前一个大于后一个
                Comparable c1 = (Comparable)arr[j];
                Comparable c2 = (Comparable)arr[j+1];
                if(c1.compareTo(c2)>0){
                    //交换
                    temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    //修改符号量
                    flag = false;//交换过，无序
                }
            }
            //判断经过此趟循环后是否已经有序
            if(flag){
                break;//退出外层循环，省略后续趟循环
            }
        }
        //输出排序后数组
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }




    public int getIndexofArray(float[] f){
        int rtn=-1;
        float objf=3.4f;
        List list= new ArrayList();
        for(int i=0;i<f.length;i++){
            list.add(f[i]);
        }
        for(int i=0;i<list.size( );i++){
            float tmp=(float)list.get(i);
            if(objf==tmp){
                rtn=i;
            }
        }
        return rtn;
    }


}

