package a6adept;

import java.util.*;

public abstract class AnyPicture implements Picture {
	private int width;
	private int height;
	private Picture source;
	private Pixel[][] arrPixels;

	public AnyPicture(int width, int height) {
		if (width <= 0 || height <= 0) {
			throw new RuntimeException("height or width is 0 or below");
		}
		this.width = width;
		this.height = height;
	}

	public int countRange(double low, double high) {
		int sum = 0;
		for (int i = 0; i < arrPixels.length; i++) {
			for (int j = 0; j < arrPixels[i].length; j++) {
				if (arrPixels[i][j].getIntensity() >= low && arrPixels[i][j].getIntensity() <= high) {
					sum++;
				}
			}
		}
		return sum;
	}

	public void print() {
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				if (isBetween(arrPixels[i][j].getIntensity(), 0, 9)) {
					System.out.print("#");
				} else if (isBetween(arrPixels[i][j].getIntensity(), 10, 19)) {
					System.out.print("M");
				} else if (isBetween(arrPixels[i][j].getIntensity(), 20, 29)) {
					System.out.print("X");
				} else if (isBetween(arrPixels[i][j].getIntensity(), 30, 39)) {
					System.out.print("D");
				} else if (isBetween(arrPixels[i][j].getIntensity(), 40, 49)) {
					System.out.print("<");
				} else if (isBetween(arrPixels[i][j].getIntensity(), 50, 59)) {
					System.out.print(">");
				} else if (isBetween(arrPixels[i][j].getIntensity(), 60, 69)) {
					System.out.print("s");
				} else if (isBetween(arrPixels[i][j].getIntensity(), 70, 79)) {
					System.out.print(":");
				} else if (isBetween(arrPixels[i][j].getIntensity(), 80, 89)) {
					System.out.print("-");
				} else if (isBetween(arrPixels[i][j].getIntensity(), 90, 99)) {
					System.out.print(" ");
				}
			}
		}
	}

	public Picture getSource() {
		return source;
	}

	public void setPixel(Coordinate c, Pixel p) {
		setPixel(c.getX(), c.getY(), p);
	}

	public Pixel getPixel(Coordinate c) {
		return getPixel(c.getX(), c.getY());
	}

	public SubPicture extract(int xOffset, int yOffset, int width, int height) {
		SubPicture subPic = new SubPictureImpl(this, xOffset, yOffset, width, height);
		return subPic;
	}

	public SubPicture extract(Coordinate corner_a, Coordinate corner_b) {
		int minX = corner_a.getX() < corner_b.getX() ? corner_a.getX() : corner_b.getX();
		int maxX = corner_a.getX() >= corner_b.getX() ? corner_a.getX() : corner_b.getX();
		int minY = corner_a.getY() < corner_b.getY() ? corner_a.getY() : corner_b.getY();
		int maxY = corner_a.getY() >= corner_b.getY() ? corner_a.getY() : corner_b.getY();

		return extract(minX, minY, maxX - minX + 1, maxY - minY + 1);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Iterator<Pixel> iterator() {
		return new RowMajorPixelIterator(this);
	}

	public Iterator<Pixel> sample(int init_x, int init_y, int dx, int dy) {
		if ((init_x < 0) || (init_y < 0) || (init_x >= getWidth()) || (init_y >= getHeight())) {
			throw new IllegalArgumentException("Initial x and y of sampling must be within picture");
		}
		if ((dx < 0) || (dy < 0)) {
			throw new IllegalArgumentException("dx and dy must be positive");
		}
		return new Sample(this, init_x,init_y,dx,dy);
	}
	
	
	public Iterator<SubPicture> window(int window_width, int window_height){
		
		return new Window(this,window_width,window_height);
	}
	
	public Iterator<SubPicture> tile(int tile_width, int tile_height){
		
		return new Tile(this,tile_width,tile_height);
	}

	public static boolean isBetween(double value, double min, double max) {
		return ((value >= min) && (value <= max));
	}
}
