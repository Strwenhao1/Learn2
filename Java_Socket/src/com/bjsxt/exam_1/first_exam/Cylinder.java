package com.bjsxt.exam_1.first_exam;

public class Cylinder extends Circle {
    private double hight;
    Cylinder(double r,double h){
        super.radius = r;
        this.hight = h;
    }

    double getVolume(){
        return getArea()*hight;
    }
    void showVolume(){
        System.out.println(getVolume());
    }
}
