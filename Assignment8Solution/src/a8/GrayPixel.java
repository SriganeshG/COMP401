package a8;

public class GrayPixel implements Pixel {

	private double intensity;

	private static final char[] PIXEL_CHAR_MAP = { '#', 'M', 'X', 'D', '<', '>', 's', ':', '-', ' ' };

	public GrayPixel(double intensity) {
		if (intensity < 0.0 || intensity > 1.0) {
			throw new IllegalArgumentException("Intensity of gray pixel is out of bounds.");
		}
		this.intensity = intensity;
	}

	@Override
	public double getRed() {
		return getIntensity();
	}

	@Override
	public double getBlue() {
		return getIntensity();
	}

	@Override
	public double getGreen() {
		return getIntensity();
	}

	@Override
	public double getIntensity() {
		return intensity;
	}

	@Override
	public char getChar() {
		return PIXEL_CHAR_MAP[(int) (getIntensity() * 10.0)];
	}

	@Override
	public Pixel blend(Pixel p, double weight) {
		double r = getRed(), g = getGreen(), b = getBlue();
		r = (this.getRed() * weight) + (p.getRed() * (1 - weight));
		g = (this.getGreen() * weight) + (p.getGreen() * (1 - weight));
		b = (this.getBlue() * weight) + (p.getBlue() * (1 - weight));
		return new ColorPixel(r, g, b);
	}

	@Override
	public Pixel lighten(double factor) {
		Pixel whitePixel = new ColorPixel(1.0, 1.0, 1.0);
		return blend(whitePixel, 1 - factor);
	}

	@Override
	public Pixel darken(double factor) {
		Pixel blackPixel = new ColorPixel(0.0, 0.0, 0.0);
		return blend(blackPixel, 1 - factor);
	}

}
