package lec6.v3;

public class Triangle {
	
	private Point a;
	private Point b;
	private Point c;
	
	Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
		
		if (check_colinearity()) {
			throw new RuntimeException("Triangle points are co-linear");
		}
	}
	
	public Point getA() {
		return a;
	}
	
	public void setA(Point p) {
		if (p.equals(b) || p.equals(c)) {
			throw new RuntimeException("Attempting to set point A to same value as either B or C");
		}
		
		a = p;
		
		if (check_colinearity()) {
			throw new RuntimeException("Triangle points are co-linear");
		}
	}
	
	public Point getB() {
		return b;
	}
	
	public void setB(Point p) {
		if (p.equals(a) || p.equals(c)) {
			throw new RuntimeException("Attempting to set point B to same value as either A or C");
		}
		
		b = p;
		
		if (check_colinearity()) {
			throw new RuntimeException("Triangle points are co-linear");
		}
	}
	
	public Point getC() {
		return c;
	}
	
	public void setC(Point p) {
		if (p.equals(a) || p.equals(b)) {
			throw new RuntimeException("Attempting to set point C to same value as either A or B");
		}
		
		c = p;
		
		if (check_colinearity()) {
			throw new RuntimeException("Triangle points are co-linear");
		}
	}
		
	double perimeter() {
		return sideABLength() + sideBCLength() + sideCALength();
	}
	
	double area() {
		double s = perimeter() / 2.0;
		return Math.sqrt(s * (s-sideABLength()) * (s-sideBCLength()) * (s-sideCALength()));
	}
	
	boolean check_colinearity() {
		return (area() < 0.000001);
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
