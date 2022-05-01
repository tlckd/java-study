package prob6;

public class Rectangle extends Shape implements Resizable{

	private double width;
	private double height;
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		double area = width*height;
		return area;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		double perimeter = (width+height)*2;
		return perimeter;
	}

	@Override
	public void resize(double s) {
		// TODO Auto-generated method stub
		width = width*s;
		height = height*s;
	}

}
