package a6adept;
import java.util.*;

public class RowMajorPixelIterator implements Iterator<Pixel>{
	private Picture p;
	private int x;
	private int y;
	public RowMajorPixelIterator(Picture source){
		p = source;
		x=0;
		y=0;
	}
	
	public boolean hasNext(){
		return y < p.getHeight();
	}
	
	public Pixel next(){
		if(hasNext() == false){
			throw new NoSuchElementException("ayy there be no more pixels");
		}
		Pixel p = this.p.getPixel(x,y);
		if(x == this.p.getWidth() - 1){
			x = 0;
			y += 1;
		}else{
			x += 1;
		}
		return p;
	}
}
