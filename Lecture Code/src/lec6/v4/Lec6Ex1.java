package lec6.v4;

public class Lec6Ex1 {

	public static void main (String[] args) {
		
		Point p1 = new Point(5, 5);
		Point p2 = new Point(10, 15);
		Point p3 = new Point(15, -2);
		
		Triangle t1 = new Triangle(p1, p2, p3);
		
		System.out.println("Perimeter of T1 = " + t1.getPerimeter());
		System.out.println("");
		
		t1.setA(p2);
		
		Triangle t2 = new Triangle(new Point(0,0), new Point(5, 0), new Point(10, 0));
	}
}
