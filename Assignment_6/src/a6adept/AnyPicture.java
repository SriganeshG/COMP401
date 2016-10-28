package a6adept;

public abstract class AnyPicture implements Picture{
	private int width;
	private int height;
	
	public AnyPicture(int width, int height){
		if(width <= 0 || height <=  0){
			throw new RuntimeException("height or width is 0 or below");
		}
		
		this.width = width;
		this.height = height;
	}
	
	public abstract void setPixel(int x, int y, Pixel p);
	public abstract Pixel getPixel(int x, int y);
	
	public Pixel getPixel(Coordinate c){
		return getPixel(c.getX(),c.getY());
	}
	
	public void setPixel(Coordinate c, Pixel p){
		setPixel(c.getX(),c.getY(),p);
	}
	
	public int countRange(double low, double high) {
		int sum =0;
		for(int i = 0; i < this.getWidth();i++){
			for(int j = 0; j < this.getHeight();j++){
				double intensity = this.getPixel(i, j).getIntensity();
				if((intensity <= high)&&(intensity>=low)){
					sum++;
				}
			}
		}
		return sum;
	}
	
	public void print(){
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				if (isBetween(this.getPixel(i, j).getIntensity(), 0, 9)) {
					System.out.print("#");
				} else if (isBetween(this.getPixel(i,j).getIntensity(), 10, 19)) {
					System.out.print("M");
				} else if (isBetween(this.getPixel(i,j).getIntensity(), 20, 29)) {
					System.out.print("X");
				} else if (isBetween(this.getPixel(i,j).getIntensity(), 30, 39)) {
					System.out.print("D");
				} else if (isBetween(this.getPixel(i,j).getIntensity(), 40, 49)) {
					System.out.print("<");
				} else if (isBetween(this.getPixel(i,j).getIntensity(), 50, 59)) {
					System.out.print(">");
				} else if (isBetween(this.getPixel(i,j).getIntensity(), 60, 69)) {
					System.out.print("s");
				} else if (isBetween(this.getPixel(i,j).getIntensity(), 70, 79)) {
					System.out.print(":");
				} else if (isBetween(this.getPixel(i,j).getIntensity(), 80, 89)) {
					System.out.print("-");
				} else if (isBetween(this.getPixel(i,j).getIntensity(), 90, 99)) {
					System.out.print(" ");
				}
			}
			//System.out.print("\n");
		}
	}
	
	
	public SubPicture extract(int xOffset, int yOffset, int width, int height) {
		SubPicture subPic = new SubPictureImpl(this, xOffset, yOffset, width, height);
		return subPic;
	}
	
	public SubPicture extract(Coordinate corner_a, Coordinate corner_b){
		
		int minX = corner_a.getX() < corner_b.getX() ? corner_a.getX() : corner_b.getX();
		int minY = corner_a.getY() < corner_b.getY() ? corner_a.getY() : corner_b.getY();
		int maxX = corner_a.getX() >= corner_b.getX() ? corner_a.getX() : corner_b.getX();
		int maxY = corner_a.getY() >= corner_b.getY() ? corner_a.getY() : corner_b.getY();
		return this.extract(minX, minY, maxX-minX, maxY-minY);
	}
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight(){
		return this.height;
	}
	
	public static boolean isBetween(double value, double min, double max) {
		return ((value >= min) && (value <= max));
	}
	
}