package a4jedi;

public class HorizontalStackPicture extends AnyPicture implements Picture {
	private Picture left;
	private Picture right;
	public HorizontalStackPicture(Picture left, Picture right){
		super(Validate.validatePicture(left).getWidth()+Validate.validatePicture(right).getWidth(),Validate.validatePicture(left).getHeight());
		if(left.getHeight() != right.getHeight()){
			throw new IllegalArgumentException("Heights don't match!");
		}
		this.left = left;
		this.right = right;
	}
	@Override
	public void setPixel(int x, int y, Pixel p) {
		
	}
	@Override
	public Pixel getPixel(int x, int y) {
		if(x < left.getWidth()){
			return left.getPixel(x, y);
		}else{
			return right.getPixel(x-left.getWidth(), y);
		}
	}

}

class Validate{
	public static Picture validatePicture(Picture p){
		if(p == null){
			throw new IllegalArgumentException("Picture is null");
		}
		return p;
	}
}
