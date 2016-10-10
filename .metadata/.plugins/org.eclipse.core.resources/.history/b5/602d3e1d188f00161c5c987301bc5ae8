package a6novice;

public class SubPictureImpl extends AnyPicture implements SubPicture {
	private Picture source;
	private int xOffset;
	private int yOffset;

	public SubPictureImpl(Picture source, int xOffset, int yOffset, int width, int height) {
		
		super(width,height);
		this.source = source;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		if(width <= 0 || height <=  0){
			throw new RuntimeException("height or width is 0 or below");
		}
		if (source == null) {
			throw new IllegalArgumentException();
		} else if ((xOffset + width) > source.getWidth()) {
			throw new IllegalArgumentException();
		} else if ((yOffset + height) > source.getHeight()) {
			throw new IllegalArgumentException();
		}
		
		
	}

	public int getWidth() {
		return super.getWidth();
	}

	public int getHeight() {
		return super.getHeight();
	}

	@Override
	public void setPixel(int x, int y, Pixel p) {
		source.setPixel(xOffset + x, yOffset + y, p);
	}

	@Override
	public Pixel getPixel(int x, int y) {
		return source.getPixel(x + xOffset, y + yOffset);
	}

	@Override
	public int countRange(double low, double high) {
		return super.countRange(low, high);
	}

	@Override
	public void print() {
		super.print();
	}

	@Override
	public Picture getSource() {
		return source;
	}

	@Override
	public int getXOffset() {
		return xOffset;
	}

	@Override
	public int getYOffset() {
		return yOffset;
	}

	@Override
	public SubPicture extract(int xOffset, int yOffset, int width, int height) {
		return super.extract(xOffset, yOffset, width, height);
	}

}
