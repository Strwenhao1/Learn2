package com.bjsxt.shopping.entity;

import java.util.Objects;

/**
 * 商品类
 *1.重写toString（），便于直接输出
 * 2.重写equals（）和hashCode（）可以放入哈希表结构的集合对象
 * 3.实现了Comaprable，可以比较和排序，可以放入Treeset
 * 4. 这就是一个标准的JavaBean，实体类，用来存储数据的
 *      1.类public 公共的
 *      2.属性private 私有的
 *      3. 提供public的getter和stter方法
 *      4.提供一个无参的构造器
 *问题：商品类中既有数据既有操作，代码量大
 * 解决：分开
 *            Product：存储商品的数据
 *            productDao ：存储商品的操作
 * 项目的架构
 * 后台：ProductDao  productDaoImal 完成商品的操作 面向接口编程的思想
 *前台： Test。Java
 * 实体类：product  存储商品的信息，在前台和后台直接传递数据
 *
 */
public class Product implements Comparable<Product>{
    private  int id;//编号
    private String name;//商品名称
    private  double price;//单价
    private  String  color;//颜色
    private int size;//尺寸
    private int stock;//库存

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", size=" + size +
                ", stock=" + stock +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Double.compare(product.price, price) == 0 &&
                size == product.size &&
                stock == product.stock &&
                Objects.equals(name, product.name) &&
                Objects.equals(color, product.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, color, size, stock);
    }

    public Product() {
    }

    public Product(int id, String name, double price, String color, int size, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = color;
        this.size = size;
        this.stock = stock;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public int compareTo(Product o) {
        return this.id-o.id;
    }


    }

