package com.bjsxt.why;

public class Cat extends  Animal {

    public Cat() {
        System.out.println("------Cat------");
    }

    public Cat(String nickName, String color) {
        super(nickName, color);
    }

    @Override
    public void shout() {
        System.out.println("喵喵喵.........");
    }

    @Override
    public void shout(String site) {
        System.out.println("喵喵喵........."+site);
    }

    @Override
    void run() {
        System.out.println("Cat running ........");
    }
}
