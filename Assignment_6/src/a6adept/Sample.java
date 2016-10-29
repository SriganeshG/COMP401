package a6adept;

import java.util.*;

public class Sample implements Iterator<Pixel> {
	private Picture p;
	private int dx, dy, init_y, init_x, x, y;

	public Sample(Picture source, int init_x, int init_y, int dx, int dy) {

		p = source;
		this.dx = dx;
		this.dy = dy;
		this.init_x = init_x;
		this.init_y = init_y;
		x = init_x;
		y = init_y;
	}

	public boolean hasNext() {
		return y < p.getHeight();
	}

	public Pixel next() {

		Coordinate c = new Coordinate(x,y);

		x += dx;

		if (x >= this.p.getWidth()) {
			x = init_x;
			y += dy;
		}
		return this.p.getPixel(c);
	}
}
