
package a6adept;

import java.util.*;

public class Window implements Iterator<SubPicture> {
	private Picture p;
	private int window_width;
	private int window_height;
	private int x, y;

	public Window(Picture source, int window_width, int window_height) {
		p = source;
		this.window_height = window_height;
		this.window_width = window_width;
		x = source.getWidth() - window_width;
		y = source.getHeight() - window_height;
	}

	public boolean hasNext() {
		return y < p.getHeight();
	}

	public SubPicture next() {
		if (hasNext() == false) {
			throw new NoSuchElementException("windows are out");
		}
		// Pixel p = this.p.getPixel(x, y);
		Coordinate c1 = new Coordinate(x, y);
		Coordinate c2 = new Coordinate(p.getWidth() + c1.getX() - 1, p.getHeight() + c1.getY() - 1);
		x += 1;
		if (x >= p.getWidth() - window_width) {
			x = 0;
			y += 1;
		}

		return p.extract(c1, c2);
	}
}
