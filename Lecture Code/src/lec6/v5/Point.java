package lec6.v5;

public class Point {

	private int x;
	private int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	double distanceTo(Point other) {
		return Math.sqrt((getX() - other.getX())*(getX() - other.getX()) +
				         (getY() - other.getY())*(getY() - other.getY()));
	}
	
	public int getX() {
		return x;
	}
		
	public int getY() {
		return y;
	}
	
	boolean equals(Point other) {
		return ((getX() == other.getX()) && (getY() == other.getY()));
	}
}
