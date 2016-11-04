package a7;

public class RegionImpl implements Region {
	private Coordinate c1;
	private Coordinate c2;
	public RegionImpl(Coordinate a, Coordinate b){
		c1=a;
		c2=b;
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
