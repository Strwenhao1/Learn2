package com.bjsxt.shopping.entity;

import java.util.LinkedHashMap;
import java.util.Objects;

/**
 *购物车条目类
 */

public class CartItem implements Comparable<CartItem>{
    private  int id;//编号
    private String name;//商品名称
    private  double price;//单价
    private  int amount;//数量


    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return id == cartItem.id &&
                Double.compare(cartItem.price, price) == 0 &&
                amount == cartItem.amount &&
                Objects.equals(name, cartItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, amount);
    }

    public CartItem() {
    }

    public CartItem(int id, String name, double price, int amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public int compareTo(CartItem other) {
        return this.id-other.id ;
    }
}

