package a6novice;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RowMajorPixelIterator implements Iterator<Pixel> {
	private int x;
	private int y;
	private Picture p;

	public RowMajorPixelIterator(Picture pIn) {
		this.p = pIn;
		x = 0;
		y = 0;
	}

	public boolean hasNext() {
		if (y < p.getHeight()) {
			return true;
		}
		return false;
	}

	public Pixel next() {
		if (hasNext() == false) {
			throw new NoSuchElementException("already past array");
		}
		Pixel p = this.p.getPixel(x, y);
		if (this.x == this.p.getWidth() - 1) {
			this.x = 0;
			this.y += 1;
		} else {
			this.x += 1;
		}
		return p;
	}

}
