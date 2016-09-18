package lec6.v2;

public class Point {

	private int x;
	private int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	double distanceTo(Point other) {
		return Math.sqrt((this.x - other.x)*(this.x - other.x) +
				         (this.y - other.y)*(this.y - other.y));
	}

	public int getX() {
		return x;
	}
		
	public int getY() {
		return y;
	}
}
