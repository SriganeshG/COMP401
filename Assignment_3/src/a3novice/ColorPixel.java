package a3novice;

public class ColorPixel implements Pixel {
	private double _red;
	private double _blue;
	private double _green;
	
	public ColorPixel(double red, double green, double blue){
		if(red < 0 || red > 1){
			throw new RuntimeException("All pixel values must be between 0 and 1");
		} else if(green < 0 || green > 1){
			throw new RuntimeException("All pixel values must be between 0 and 1");
		}else if(blue < 0 || blue > 1){
			throw new RuntimeException("All pixel values must be between 0 and 1");
		}
		_red = red;
		_blue = blue;
		_green = green;
	}

	@Override
	public double getRed() {
		return _red;
	}

	@Override
	public double getGreen() {
		return _green;
	}

	@Override
	public double getBlue() {
		return _blue;
	}

	@Override
	public double getIntensity() {
		double intensity = (.299 * getRed()) + (.587* getGreen()) + (.114*getBlue());
		return intensity;
	}

	@Override
	public char getChar() {
		double i = getIntensity();
		char charPix = 'E';
		if(isBetween(i,0.0,0.1)){
			charPix = '#';
		}else if(isBetween(i,.1,.2)){
			charPix = 'M';
		}else if(isBetween(i, .2, .3)){
			charPix = 'X';
		}else if(isBetween(i, .3 ,.4)){
			charPix = 'D';
		}else if(isBetween(i, .4,.5)){
			charPix = '<';
		}else if(isBetween(i,.5,.6)){
			charPix = '>';
		}else if(isBetween(i, .6, .7)){
			charPix = 's';
		}else if(isBetween(i,.7,.8)){
			charPix = ':';
		}else if(isBetween(i,.8,.9)){
			charPix = '-';
		}else if(isBetween(i,.9,1) || i == 0){
			charPix = ' ';
		}
		return charPix;
	}
	
	public static boolean isBetween(double value, double min, double max) {
		return ((value >= min) && (value <= max));
	}

}
