package lec7.ex2;

public class Triangle {

	private Point a;
	private Point b;
	private Point c;
	
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public Triangle(Point[] points) {
		a = points[0];
		b = points[1];
		c = points[2];
	}
	
	public Triangle(double x1, double y1,
			 double x2, double y2,
			 double x3, double y3) {
		a = new Point(x1, y1);
		b = new Point(x2, y2);
		c = new Point(x3, y3);
	}
}
