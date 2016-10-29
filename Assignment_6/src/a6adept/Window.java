
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
		//Pixel p = this.p.getPixel(x, y);
		x += 1;
		if (x >= window_width) {
			x = 0;
			y += 1;
		}
		
		return p.extract(x, y, window_width, window_height);
	}
}
