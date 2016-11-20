package a8;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TileSubPictureIterator implements Iterator<SubPicture> {

	private Picture source;
	private final int width;
	private final int height;
	private int xOffset;
	private int yOffset;

	public TileSubPictureIterator(Picture source, int width, int height) {
		if (source == null || width <= 0 || width > source.getWidth() || height <= 0 || height > source.getHeight()) {
			throw new IllegalArgumentException("Invalid picture and tile widths and heights");
		}
		this.source = source;
		this.width = width;
		this.height = height;
		xOffset = 0;
		yOffset = 0;
	}

	public boolean hasNext() {
		return yOffset + height <= source.getHeight();
	}

	public SubPicture next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}

		SubPicture subP = source.extract(xOffset, yOffset, width, height);
		xOffset += width;
		if (width + xOffset > source.getWidth()) { // Move tile down "height" units after last possible subpicture of current row
			xOffset = 0;
			yOffset += height;
		}
		return subP;
	}
}
