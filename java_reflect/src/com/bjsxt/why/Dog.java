package com.bjsxt.why;

import java.io.Serializable;

public class Dog  extends  Animal implements Serializable,Cloneable{

    public Dog() {
        System.out.println("------Dog-------");
    }

     Dog(String nickName, String color) {
        super(nickName, color);
    }

    @Override
    public void shout() {
        System.out.println("汪汪汪.........");
    }

    @Override
    public void shout(String site) {
        System.out.println("汪汪汪........."+site);
    }

    @Override
    void run() {
        System.out.println("Dog running..........");
    }
}
