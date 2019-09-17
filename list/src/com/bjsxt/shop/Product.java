package com.bjsxt.shop;

import java.util.Objects;

public class Product implements Comparable<Product>{
    private int id;
    private String name;
    private double price;
    private String Color;
    private int siza;
    private int stock;


    




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Double.compare(product.price, price) == 0 &&
                siza == product.siza &&
                stock == product.stock &&
                Objects.equals(name, product.name) &&
                Objects.equals(Color, product.Color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, Color, siza, stock);
    }

    public Product() {
    }

    public Product(int id, String name, double price, String color, int siza, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        Color = color;
        this.siza = siza;
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
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public int getSiza() {
        return siza;
    }

    public void setSiza(int siza) {
        this.siza = siza;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    @Override
    public int compareTo(Product product) {
        return this.id - product.getId();
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", Color='" + Color + '\'' +
                ", siza=" + siza +
                ", stock=" + stock +
                '}';
    }
}
