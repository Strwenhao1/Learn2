import list.List;

import java.util.Dictionary;

public class Cylinder extends Circle{
	private double hight;



	public  Cylinder(double r,double h){
		super(r);
		this.hight = h;

	
	}

 	public double getVolume(){
		return getArea()*this.hight;
	}
	public void showVolume(){
		System.out.println(getVolume());
	}


}