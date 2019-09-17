package com.bjsxt.test;

import com.bjsxt.shopping.dao.ProductDao;
import com.bjsxt.shopping.dao.impl.ProductDaoImpl;
import com.bjsxt.shopping.entity.Product;

import java.util.List;
import java.util.Scanner;

/**
 * 分层技术
 * dao  数据操作接口
 * dao。impl   数据操作类
 * entity   实体类
 *  test   client   前台 客户端
 *
 */

public class Test2 {
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
            System.out.println("\t6.退出");

            System.out.println("**************");
            System.out.println("选择菜单:");

            int choice =input.nextInt();

            switch(choice){
                case 1:
                  //  System.out.println("添加商品");
                    addProduct();
                    break;
                case 2:
                    //System.out.println("显示所有商品");
                    showAll();
                    break;
                case 3:
                    //System.out.println("查看指定商品编号");
                    showById();
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

    private static void addProduct() {
        //在前台输入商品的相关信息
        Scanner input = new Scanner (System.in);
        System.out.println("请输入商品编号");
        int id =input.nextInt();
        System.out.println("请输入商品名称");
        String name =input.next();
        System.out.println("请输入商品价格");
        double price =input.nextInt();
        System.out.println("请输入商品颜色");
        String color =input.next();
        System.out.println("请输入商品尺寸");
        int size =input.nextInt();
        System.out.println("请输入商品库存");
        int stock =input.nextInt();




        //将商品信息写入后台
        Product product =new Product(id,name,price,color,size,stock);
        ProductDao productDao =new ProductDaoImpl();
        productDao.add(product);


        //输出结果
//        System.out.println("添加成功");

    }

    //获取后台的指定编号商品并输出
    public  static  void showById(){
        //输入要查询的商品编号
        Scanner input = new Scanner (System.in);
        System.out.println("输入要查询的商品编号");
        int id=input.nextInt();
        //根据后台的获得编码信息
        ProductDao productDao= new ProductDaoImpl();
        Product product=productDao.findById(id);

        //输出
        System.out.println("编号\t商品名称        \t价格\t颜色\t尺寸  库存");
        if(product==null){
            System.out.println("该编号的商品不存在");
        }else{
            System.out.println(product.getId()+"\t"+product.getName()+
                    "\t"+product.getPrice()+"\t"+product.getColor()+"\t"+product.getSize()+"\t"+product.getStock());

        }
    }


        //获取后台的商品并输出
    public  static  void showAll(){
        //获取后台商品的信息
        ProductDao productDao= new ProductDaoImpl();
        List<Product> productList = productDao.findAll();

        //输出

        System.out.println("编号\t商品名称        \t价格\t颜色\t尺寸  库存");
        for(Product product:productList ){
            System.out.println(product.getId()+"\t"+product.getName()+
                    "\t"+product.getPrice()+"\t"+product.getColor()+"\t"+product.getSize()+"\t"+product.getStock());

        }
    }
}
