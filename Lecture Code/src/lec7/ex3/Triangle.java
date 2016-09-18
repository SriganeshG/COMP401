package lec7.ex3;

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
		// No code goes here.
		this(points[0], points[1], points[2]);
		
	
		// Any code here would run after the call
		// to the chained constructor.
	}
	
	public Triangle(double x1, double y1,
			 double x2, double y2,
			 double x3, double y3) {		

		// The following chains to the first constructor 
		// which takes three Point objects as parameters
		
		this(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3));

		// Alternatively could have done this to chain
		// to the second constructor which takes an array
		// of Point objects which would then subsequently
		// chain to the first one.
		
		// this(new Point[] {new Point(x1, y1), 
		//                  new Point(x2, y2), 
		//                  new Point(x3, y3)});
	}
}
