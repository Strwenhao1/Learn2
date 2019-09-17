package com.bjsxt.shopping.dao.impl;

import com.bjsxt.shopping.dao.ProductDao;
import com.bjsxt.shopping.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    //存储商品信息的集合对象  商品列表只有一份
    private static List<Product> productList=new ArrayList<Product>();

    //静态代码块 第一次加载类的时候执行，只执行一次 一般是对静态变量的初始化操作
    static {
        productList.add(new Product(1111,"蜘蛛王皮鞋   ",238,"黑色",42,         6777));
        productList.add(new Product(3333,"Thinkpad    ",5939,"黑色",12,         50));
        productList.add(new Product(2222,"iphone 7plus",5686,"白色",5,          50000));
    }

    //添加商品
    //List 语法是不唯一的，但是可以通过编码判断（遍历List，如果指定编号的元素存在，就不添加）来实现其的唯一性
    //虽然可以实现，但是需要进行逐个比较  效率较低
    public  void add (Product product){
        //先判断集合中是否有已经指定id的商品
        boolean flag=false;//不存在

        for(int i=0;i<productList.size();i++){
            //取
            Product p= productList.get(i);
            //判断
            if(p.getId()==product.getId()){
                flag =true;//存在
                break;//存在了后面的无需判断

            }
        }
        //如果没有就添加，如果有就提示已经存在
        if(flag){
            System.out.println("该编号的商品已经存在");

        }else {
            productList.add(product);
            System.out.println("添加成功");
        }
    }
    //获取（不是输出）所有的商品信息
    public List<Product> findAll(){
        return productList;
    }
    //  获得指定编号的商品
    public Product findById(int id) {
        //如果按照索引查询效率高productList.get(id);但是此处是按照编号查询
        //只能逐个的比较，效率又些低
        for (int i = 0; i < productList.size(); i++) {
            //获得指定index的商品
            Product product = productList.get(i);
            //判断id是否相同
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
