
public class Square implements Shape{

	double sideLength;
	String color;
	public Square(double sideLength){
		this.sideLength = sideLength;
		color = null;
	}
	
	public Square(double sideLength,String color){
		this.sideLength = sideLength;
		this.color = color;
	}
	
	@Override
	public void fillColor(String color) {
		this.color = color;
	}

	@Override
	public String getColor() {
		
		return color;
	}
	@Override
	public double getarea() {
		double area = sideLength*sideLength;
		return area;
	}
	
	public String toString(){
		return "Square with length:"+sideLength+" and color:"+color;
	}

}
