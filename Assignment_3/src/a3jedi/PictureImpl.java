package a3jedi;

public class PictureImpl implements Picture {
	private int _width;
	private int _height;
	private Pixel[][] arrPixels;
	
	public PictureImpl(int width, int height){
		if(width <= 0 || height <=  0){
			throw new RuntimeException("height or width is 0 or below");
		}
		_width = width;
		_height = height;
		Pixel p = new ColorPixel(.5,.5,.5);
		arrPixels = new Pixel[height][width];
		for(int i =0;i<arrPixels.length;i++){
			for(int j = 0;j<arrPixels[i].length;j++){
				arrPixels[i][j] = p;
			}
		}
	}

	@Override
	public int getWidth() {
		return _width;
	}

	@Override
	public int getHeight() {
		return _height;
	}

	@Override
	public void setPixel(int x, int y, Pixel p) {
		if(x < 0 || x >= _width || y < 0 || y >= _height || p == null){
			throw new RuntimeException("x,y, or p is not valid.");
		}
		
		for(int i = 0; i < arrPixels.length;i++){
			for(int j = 0; j < arrPixels[i].length;j++){
				if(i == x && y == j){
					arrPixels[i][j] = p;
				}
			}
		}
		
	}

	@Override
	public Pixel getPixel(int x, int y) {
		if(x < 0 || y < 0){
			throw new RuntimeException("x or y less than 0");
		}
		return arrPixels[x][y];
		
	}

	@Override
	public int countRange(double low, double high) {
		int sum =0;
		for(int i = 0; i < arrPixels.length;i++){
			for(int j = 0; j < arrPixels[i].length;j++){
				if(arrPixels[i][j].getIntensity() >= low && arrPixels[i][j].getIntensity() <= high){
					sum++;
				}
			}
		}
		return sum;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub

	}

	@Override
	public double unequalPixelRatio(Picture p) {
		if(p.getHeight() != _height || p.getWidth() != _width || p == null){
			throw new RuntimeException("Pictures height and width are not the same.");
		}
		Pixel[][] p2 = new Pixel[p.getHeight()][p.getWidth()];
		for(int i = 0; i < p2.length; i++){
			for(int j = 0; j < p2[i].length;j++){
				p2[i][j] = p.getPixel(i, j);
			}
		}
		double total = _height*_width;
		double diff = 0;
		for(int i = 0; i < p2.length; i++){
			for(int j = 0; j < arrPixels[i].length;j++){
				if(arrPixels[i][j].equals(p2[i][j]) == false){
					diff++;
				}
			}
		}
		return diff/total;
	}

	@Override
	public double calculatePSNR(Picture p) {
		if(p.getHeight() != _height || p.getWidth() != _width || p == null){
			throw new RuntimeException("Pictures height and width are not the same.");
		}
		Pixel[][] p2 = new Pixel[p.getHeight()][p.getWidth()];
		for(int i = 0; i < p2.length; i++){
			for(int j = 0; j < p2[i].length;j++){
				p2[i][j] = p.getPixel(i, j);
			}
		}
		double sumSquare = 0;
		double mse;
		for(int i = 0; i < _height; i ++){
			for(int j =0; j< _width; j++){
				double a = arrPixels[i][j].getIntensity();
				double b = p2[i][j].getIntensity();
				double diff = a-b;
				sumSquare = sumSquare + (diff * diff);
			}
		}
		
		mse = sumSquare / (_height*_width);
		if(mse == 0){
			throw new RuntimeException("MSE is 0!");
		}
		double psnr = (20*Math.log10(1.0)) - (10*Math.log10(mse));
		return psnr;
	}

}
