package lec7.ex2;

public class Main {


	public static void main(String[] args) {
		
		Point p1 = new Point(1.5, 2.5);
		Point p2 = new Point(3.4, 6.7);
		Point p3 = new Point(5.1, 0.6);
		
		Point[] points = new Point[] {p1, p2, p3};
		
		Triangle t1 = new Triangle(p1, p2, p3);
		Triangle t2 = new Triangle(points);
		Triangle t3 = new Triangle(1.5, 2.5, 3.4, 6.7, 5.1, 0.6);
		
		System.out.println("Done");
	}

}
