package com.bjsxt.Threadcom;

public class Product {
    private String name;
    private String color;
    private int flag=0;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Product(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Product1{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
