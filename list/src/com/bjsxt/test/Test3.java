package com.bjsxt.test;

import com.bjsxt.shopping.dao.ProductDao;
import com.bjsxt.shopping.dao.impl.ProductDaoImpl;
import com.bjsxt.shopping.entity.Product;

import java.util.List;
import java.util.Scanner;

/**
 * 购物车条目的设计
 * 1 什么是购物车条目
 *      一个购物车中可以存储多个购物车的条目，购物车应该用集合表示
 *        购物车的条目并不完全是商品信息（比如数量）
 *      购物车： cart shoppingcart
 *      购物车条目： shoppingcart
 *
 *
 * 2购物车的设计
 *      购物车的特点：
 *      1：有序  添加的顺序   不是商品编号的顺序
 *      2：添加删除和删除的操作比较多，  效率有要求
 *      3：添加和删除必须先查找到，对查询效率有要去
 *      4：唯一： 同一种只能出现一次，会叠加数量
 *      条件1：必须满足     有 序 添加顺序  必须有的  不可以商量
 *      条件2，条件3是效率问题可以商量
 *      条件4： 即使是不唯一的集合List 也可以通过编程实现唯一 ，可以不考虑
 *
 *          集合类型
 *          AraayList   有序  添加顺序  可以考虑 不适合添加和删除不是最佳方案
 *                          但是购物车不可能有很多条目，效率差异不是特别大可以考虑
 *          LinkedList    有序  添加顺序   可以考虑  适合添加和删除  可以考虑
 *                          但是添加删除需要先查询 但是查询效率低 不是最佳方案
 *                          LinkedList  每个节点不仅存数据，还存前后地址，
 *                          浪费一定空间不是最佳方案
 *          HashSet  无序  排除
 *          LinkedHashSet   有序 添加顺序 添加和删除效率高  查询效率高
 *                          它无法判断某个条目是否存在   无法确定之前的数量
 *          TreeSet     自然数顺序  排除
 *          HashMap    无序  排除
 *          LinkedHashMap   有序 添加顺序   添加删除效率高 查询效率高
 *                      可以判断某个条目是否存在
 *                      可以通过条目的id作为key，通过key来获取条目
 *          TreeMap  自然数顺序  排除
 *
 *              LinkehashMap 是购物车的最佳方案
 * 3购物车条目的设计
 *      方案1 ：直接使用Product 作为购物车的条目
 *          可以字Product中增加一个数量自动作为购物车条目使用，但是不是最佳方案
 *              1：购物车不需要Product的所有属性（只需要核心属性）
 *              2： Product 中没有购物车条目的数量
 *              可以字Product中增加一个数量自动作为购物车条目使用，但是不是最佳方案
 * 方案2： 使用新的类CartItem作为购物车条目
 *       1：购物车的关键属性： 编号  名称 单价   颜色
 *       2：新增的数量属性amount
 *
 *
 *
 *
 */


public class Test3 {
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
