package com.bjsxt.shopping.dao;

import com.bjsxt.shopping.entity.CartItem;

import java.util.LinkedHashMap;

public interface CartItemDao {
    //添加条目到购物车
    public  void addCarItem(CartItem itme);


    //获取所有的购物车条目== 获取购物车的信息
    public LinkedHashMap<Integer,CartItem> findCart();


}
