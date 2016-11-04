package a7;
import java.util.*;
public class ObservablePictureImpl implements Region {
	private Picture p;
	public ObservablePictureImpl(Picture p){
		if(p == null){
			throw new IllegalArgumentException("picture is invalid"); 
		}
		this.p = p;
	}

	@Override
	public Coordinate getUpperLeft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coordinate getLowerRight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTop() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBottom() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLeft() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Region intersect(Region other) throws NoIntersectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Region union(Region other) {
		// TODO Auto-generated method stub
		return null;
	}

}
