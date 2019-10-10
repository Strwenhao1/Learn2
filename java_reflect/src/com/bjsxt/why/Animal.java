package com.bjsxt.why;

public abstract   class Animal {

    String nickName;
    public  String color;

    public Animal() {
    }

    public Animal(String nickName, String color) {
        this.nickName = nickName;
        this.color = color;
    }

    public abstract void shout();

    public abstract void shout(String site);

    abstract void run();

    @Override
    public String toString() {
        return "Animal{" +
                "nickName='" + nickName + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
