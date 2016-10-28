package a6adept;

public interface Picture extends Iterable<Pixel> {
	public int getWidth();

	public int getHeight();

	public void setPixel(int x, int y, Pixel p);

	public Pixel getPixel(int x, int y);

	public int countRange(double low, double high);

	public void print();

	SubPicture extract(int xOffset, int yOffset, int width, int height);

	public void setPixel(Coordinate c, Pixel p);

	public Pixel getPixel(Coordinate c);

	public SubPicture extract(Coordinate corner_a, Coordinate corner_b);

}
