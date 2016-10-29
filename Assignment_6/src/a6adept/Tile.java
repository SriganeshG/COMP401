package a6adept;

import java.util.*;

public class Tile implements Iterator<SubPicture> {
	private Picture p;
	private int window_width;
	private int window_height;
	private int x, y;

	public Tile(Picture source, int tile_width, int tile_height) {
		p = source;
		this.window_height = tile_height;
		this.window_width = tile_width;
		x = source.getWidth() - tile_width;
		y = source.getHeight() - tile_height;
	}

	public boolean hasNext() {
		return y < p.getHeight();
	}

	public SubPicture next() {
		if (hasNext() == false) {
			throw new NoSuchElementException("windows are out");
		}
		//Pixel p = this.p.getPixel(x, y);
		Coordinate bottomRight = new Coordinate(window_width,window_height);
		Coordinate upperLeft = new Coordinate(x,y);
		x += 1;
		if (x >= window_width) {
			x = 0;
			y += 1;
		}
		return p.extract(upperLeft,bottomRight);
	}
}
