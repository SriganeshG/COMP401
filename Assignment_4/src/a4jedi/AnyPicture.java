package a4jedi;

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
			// System.out.print("\n");
		}
	}

	public Picture getSource() {
		return source;
	}

	public SubPicture extract(int xOffset, int yOffset, int width, int height) {
		return new SubPictureImpl(this, xOffset, yOffset, width, height);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public static boolean isBetween(double value, double min, double max) {
		return ((value >= min) && (value <= max));
	}

	public TransformedPicture transform(PixelTransformation xform) {
		return new TransformedPicture(this, xform);
	}
}
