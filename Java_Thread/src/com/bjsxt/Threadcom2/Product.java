package com.bjsxt.Threadcom2;

public class Product {
    private String name;
    private String color;
    private int flag = 0;

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
        return "Product{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public synchronized void Produc(String name,String color) {
        if (this.getFlag() == 1) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        this.color = color;
        System.out.println("生产者生产：" + this.getName() + "  " + this.getColor());
        this.setFlag(1);
        this.notify();
    }


    public synchronized void Consu() {
        if (this.getFlag() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费者 消费了" + this.getName() + "   " + this.getColor());
        this.setFlag(0);
        this.notify();
    }
}
