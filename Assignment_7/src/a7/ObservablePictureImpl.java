package a7;

public class ObservablePictureImpl implements ObservablePicture {
	// protected so children can access
	protected Picture p;

	public ObservablePictureImpl(Picture p) {
		if (p == null) {
			throw new IllegalArgumentException();
		}
		this.p = p;

	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return this.p.getWidth();
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return this.p.getHeight();
	}

	@Override
	public Pixel getPixel(int x, int y) {
		// TODO Auto-generated method stub
		return this.p.getPixel(x, y);
	}

	@Override
	public Pixel getPixel(Coordinate c) {
		// TODO Auto-generated method stub
		return this.p.getPixel(c);
	}

	@Override
	public void setPixel(int x, int y, Pixel p) {
		// TODO Auto-generated method stub
		this.p.setPixel(x, y, p);
	}

	@Override
	public void setPixel(Coordinate c, Pixel p) {
		// TODO Auto-generated method stub
		this.p.setPixel(c, p);
	}

	@Override
	public SubPicture extract(int xoff, int yoff, int width, int height) {
		// TODO Auto-generated method stub
		return this.p.extract(xoff, yoff, width, height);
	}

	@Override
	public SubPicture extract(Coordinate a, Coordinate b) {
		// TODO Auto-generated method stub
		return this.p.extract(a, b);
	}

	@Override
	public void registerROIObserver(ROIObserver observer, Region r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unregisterROIObservers(Region r) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unregisterROIObserver(ROIObserver observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public ROIObserver[] findROIObservers(Region r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void suspendObservable() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resumeObservable() {
		// TODO Auto-generated method stub

	}

}
