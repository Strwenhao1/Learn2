package com.bjsxt.exam_1.first_exam;

public class Circle {
     double radius;
    Circle(){
    }

    Circle(double radius){
        this.radius = radius;
    }

    double getArea(){
        return Math.PI*Math.pow(this.radius,2);
    }
    double getPerimeter(){
        return 2*Math.PI*this.radius;
    }

    void show(){
        System.out.println("圆的面积是:"+getArea());
        System.out.println("圆的周长是:"+getPerimeter());
    }
}
