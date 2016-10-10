package a4jedi;

public class TransformedPicture extends AnyPicture implements Picture {
	/*
	 * private Picture source; private PixelTransformation xform;
	 */
	private Picture source;
	private PixelTransformation xform;

	public TransformedPicture(Picture source, PixelTransformation xform) {
		super(source.getWidth(), source.getHeight());
		this.source = source;
		this.xform = xform;
		
		/*
		 * this.source = source; this.xform = xform;
		 */
	}

	@Override
	public void setPixel(int x, int y, Pixel p) {
		throw new UnsupportedOperationException("cant do this kiddo");
	}

	@Override
	public Pixel getPixel(int x, int y) {
		return xform.transform(source.getPixel(x, y));
	}
}
