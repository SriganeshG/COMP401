package lec6.v2;

public class Triangle {
	
	private Point a;
	private Point b;
	private Point c;
	
	Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public Point getA() {
		return a;
	}
	
	public void setA(Point p) {
		a = p;
	}
	
	public Point getB() {
		return b;
	}
	
	public void setB(Point p) {
		b = p;
	}
	
	public Point getC() {
		return c;
	}
	
	public void setC(Point p) {
		c = p;
	}
		
	double perimeter() {
		return sideABLength() + sideBCLength() + sideCALength();
	}
	
	double sideABLength() {
		return a.distanceTo(b);
	}
	
	double sideBCLength() {
		return b.distanceTo(c);
	}
	
	double sideCALength() {
		return c.distanceTo(a);
	}
}
