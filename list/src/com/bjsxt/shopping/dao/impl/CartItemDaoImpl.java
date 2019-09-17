package com.bjsxt.shopping.dao.impl;

import com.bjsxt.shopping.dao.CartItemDao;
import com.bjsxt.shopping.entity.CartItem;

import java.util.LinkedHashMap;

public class CartItemDaoImpl implements CartItemDao {
    //购物车不适应static修饰 ，每个用户都有自己的购物车
    private static LinkedHashMap<Integer,CartItem>
       shoppingCart=new  LinkedHashMap<Integer,CartItem>();
    //不能使用static代码块给购物车赋初始值
    static {

    }
    //添加条目到购物车
    public  void addCarItem(CartItem item){
        //判断指定编号的条目是否存在 如果存在修改数量 之前已经存在
       CartItem item2 =shoppingCart.get(item.getId());
        //如果没有修改数量
        if(item2==null){
           //直接添加条目
           shoppingCart.put(item.getId(),item);
        }else {
            //修改数量
            //获取原来的数量
            // int num1 = item2.getAmount();
            //获取现在的数量
            // int num2 = item.getAmount();
            //数量相加
            //int num = num1 + num2;
            //将新的数量给条目
            // item2.setAmount(num);
            item2.setAmount(item2.getAmount()+item.getAmount());
        }
            shoppingCart.put(item.getId(), item);

    }
    //获取所有的购物车条目== 获取购物车的信息
    public LinkedHashMap<Integer,CartItem> findCart(){
        //假设购物车之前有俩个条目
       // shoppingCart.put();
        return shoppingCart;
    }

}
