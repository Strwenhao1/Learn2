package com.bjsxt.test;

import java.util.Scanner;

public class Test {
    public static void main(String[]args){
        Scanner input = new Scanner (System.in);
        do{
            System.out.println("");
            System.out.println("*******欢迎使用京东商城***********");
            System.out.println("\t1.添加商品");
            System.out.println("\t2.查看所有商品");
            System.out.println("\t3.查看指定编号的商品");
            System.out.println("\t4.添加购物车");
            System.out.println("\t5.显示购物车");
            System.out.println("\6.退出");

            System.out.println("**************");
            System.out.println("选择菜单:");

            int choice =input.nextInt();

            switch(choice){
                case 1:
                    System.out.println("添加商品");
                    break;
                case 2:
                    System.out.println("查看所有信息");
                    break;
                case 3:
                    System.out.println("查看指定商品编号");
                    break;
                case 4:
                    System.out.println("添加到购物车");
                    break;
                case 5:
                    System.out.println("显示购物车");
                    break;
                case 6:
                    System.out.println("谢谢使用");
                    break;
                default:
                    System.out.println("输入错误");
            }
        }while(true);

    }
}
