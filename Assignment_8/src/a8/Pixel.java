package a8;

public interface Pixel {

	public double getRed();
	public double getBlue();
	public double getGreen();
	public double getIntensity();
	public char getChar();
	Pixel blend(Pixel p, double weight);
	Pixel lighten(double factor);
	Pixel darken(double factor);	
}
