package a4jedi;

public class Threshold implements PixelTransformation {
	private double threshold;

	public Threshold(double threshold) {
		this.threshold = threshold;
	}

	@Override
	public Pixel transform(Pixel p) {
		Pixel pTrans;
		if (p.getIntensity() > threshold) {
			pTrans = p.lighten(1.0);
			return pTrans;
		} else {
			pTrans = p.darken(1.0);
			return pTrans;
		}
	}

}
