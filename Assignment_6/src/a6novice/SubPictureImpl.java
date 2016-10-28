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

	
	public void setPixel(int x, int y, Pixel p) {
		this.source.setPixel(this.xOffset + x, this.yOffset + y, p);
	}

	
	public Pixel getPixel(int x, int y) {
		return source.getPixel(x + this.xOffset, y + this.yOffset);
	}

	@Override
	public Picture getSource() {
		return this.source;
	}

	@Override
	public int getXOffset() {
		return this.xOffset;
	}

	@Override
	public int getYOffset() {
		return this.yOffset;
	}

}
