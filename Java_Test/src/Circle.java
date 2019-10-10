public class Circle{
	private double radius;
	public double s;
	public  Circle(){
	
	}
	
	public  Circle(double r){
		this.radius = r;
	
	}
	
	public double getArea(){
		return Math.PI*radius*radius;
	
	}
	public double getPerimeter(){
		return 2*Math.PI*radius;
	}
}