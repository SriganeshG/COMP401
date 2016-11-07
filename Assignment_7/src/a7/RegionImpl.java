package a7;

public class RegionImpl implements Region {
	private Coordinate a;
	private Coordinate b;

	public RegionImpl(Coordinate a, Coordinate b) {
		if (a == null || b == null) {
			throw new IllegalArgumentException();
		}
		this.a = a;
		this.b = b;

	}

	@Override
	public Coordinate getUpperLeft() {
		return new Coordinate(this.getLeft(),this.getTop());
	}

	@Override
	public Coordinate getLowerRight() {
		return new Coordinate(this.getRight(),this.getBottom());
	}

	@Override
	public int getTop() {
		//
		return a.getY() > b.getY() ? b.getY() : a.getY();
	}

	@Override
	public int getBottom() {
		return a.getY() > b.getY() ? a.getY() : b.getY();
	}

	@Override
	public int getLeft() {
		return a.getX() > b.getX() ? b.getX():a.getX();
	}

	@Override
	public int getRight() {
		return a.getX() > b.getX() ? a.getX():b.getX();
	}

	@Override
	public Region intersect(Region other) throws NoIntersectionException {
		if (other == null) {
			throw new NoIntersectionException();
		}
		if (other.getLeft() > this.getRight()) {
			throw new NoIntersectionException();
		}
		if (other.getBottom() < this.getTop()) {
			throw new NoIntersectionException();
		}
		
		int left, right, top, bottom = 0;
		if (this.getLeft() > other.getLeft()) {
			left = this.getLeft();
		} else {
			left = other.getLeft();
		}
		if (this.getRight() < other.getRight()) {
			right = this.getRight();
		} else {
			right = other.getRight();
		}
		if (this.getTop() > other.getTop()) {
			top = this.getTop();
		} else {
			top = other.getTop();
		}
		if (this.getBottom() < other.getBottom()) {
			bottom = this.getBottom();
		} else {
			bottom = other.getBottom();
		}
		Coordinate ulNew = new Coordinate(left, top);
		Coordinate brNew = new Coordinate(right, bottom);
		return new RegionImpl(ulNew, brNew);
	}

	@Override
	public Region union(Region other) {
		if (other == null) {
			return this;
		}
		int left, right, top, bottom = 0;
		if (this.getLeft() > other.getLeft()) {
			left = other.getLeft();
		} else {
			left = this.getLeft();
		}
		if (this.getRight() < other.getRight()) {
			right = other.getRight();
		} else {
			right = this.getRight();
		}
		if (this.getTop() > other.getTop()) {
			top = other.getTop();
		} else {
			top = this.getTop();
		}
		if (this.getBottom() < other.getBottom()) {
			bottom = other.getBottom();
		} else {
			bottom = this.getBottom();
		}
		
		Coordinate ulNew = new Coordinate(left, top);
		Coordinate brNew = new Coordinate(right, bottom);
		
		return new RegionImpl(ulNew, brNew);

	}

}
