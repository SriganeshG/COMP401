package a6adept;

public class PictureImpl extends AnyPicture implements Picture {
	private Pixel[][] arrPixels;

	public PictureImpl(int width, int height) {
		super(width, height);

		if (width <= 0 || height <= 0) {
			throw new RuntimeException("height or width is 0 or below");
		}

		Pixel p = new ColorPixel(.5, .5, .5);
		arrPixels = new Pixel[height][width];
		for (int i = 0; i < arrPixels.length; i++) {
			for (int j = 0; j < arrPixels[i].length; j++) {
				arrPixels[i][j] = p;
			}
		}

	}

	@Override
	public void setPixel(int x, int y, Pixel p) {
		if (x < 0 || x >= super.getWidth() || y < 0 || y >= super.getHeight() || p == null) {
			throw new RuntimeException("x,y, or p is not valid.");
		}

		for (int i = 0; i < arrPixels.length; i++) {
			for (int j = 0; j < arrPixels[i].length; j++) {
				if (i == x && y == j) {
					arrPixels[i][j] = p;
				}
			}
		}

	}

	@Override
	public Pixel getPixel(int x, int y) {
		if (x < 0 || y < 0) {
			throw new RuntimeException("x or y less than 0");
		}
		return arrPixels[x][y];

	}

}
