package lec6.v7;

public class Lec6Ex1 {

	public static void main (String[] args) {
		
		Point p1 = new CartesianPoint(5, 5);
		Point p2 = new CartesianPoint(10, 15);
		Point p3 = new PolarPoint(8.2, 2.45);
		
		Triangle t1 = new Triangle(p1, p2, p3);
		
		System.out.println("Perimeter of T1 = " + t1.getPerimeter());
	}
}
