package com.bjsxt.shopping.dao;


import com.bjsxt.shopping.entity.Product;

import java.util.List;

public interface ProductDao {
    public  void add(Product product);



    //获取（不是输出）所有的商品信息
    public List<Product> findAll();


    //  获得指定编号的商品
    public  Product findById(int id);

}


