package a7;
import java.util.*;
public class ObservablePictureImpl implements ObservablePicture {
	// protected so children can access
	protected Picture p;
	protected List<ROIObserverDecorator> obs;
	protected boolean suspended;
	protected Region changes;
	
	public ObservablePictureImpl(Picture p) {
		if (p == null) {
			throw new IllegalArgumentException();
		}
		this.p = p;
		obs = new ArrayList<ROIObserverDecorator>();
		suspended = false;
		changes = null;

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
		this.setPixel(new Coordinate(x, y), p);
	}

	@Override
	public void setPixel(Coordinate c, Pixel p) {
		// TODO Auto-generated method stub
		this.p.setPixel(c, p);
		Region r = new RegionImpl(c,c);
		if(!suspended){
			for(ROIObserverDecorator o:this.obs){
				try{
					Region intersection = o.getRegion().intersect(r);
					o.notify(this, intersection);
				}catch (NoIntersectionException e){
					
				}
			}
		} else{
			changes = r.union(changes);
		}
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
		if(r == null || observer == null){
			throw new IllegalArgumentException();
		}
		obs.add(new ROIObserverDecoratorImpl(observer,r));
		
	}

	@Override
	public void unregisterROIObservers(Region r) {
		// TODO Auto-generated method stub
		if(r == null){
			throw new IllegalArgumentException();
		}
		List<ROIObserverDecorator> keep = new ArrayList<ROIObserverDecorator>();
		for(ROIObserverDecorator o: this.obs){
			try{
				o.getRegion().intersect(r);
			}catch(NoIntersectionException e){
				keep.add(o);
			}
		} 
		obs = keep;
	}

	@Override
	public void unregisterROIObserver(ROIObserver observer) {
		if(observer == null){
			throw new IllegalArgumentException();
		}
		List<ROIObserverDecorator> keep = new ArrayList<ROIObserverDecorator>();
		for(ROIObserverDecorator o: this.obs){
			if(o.getROIObserver() != observer){
				keep.add(o);
			}
		}
		obs = keep;
	}

	@Override
	public ROIObserver[] findROIObservers(Region r) {
		if(r == null){
			throw new IllegalArgumentException();
		}
		List<ROIObserver> oList = new ArrayList<ROIObserver>();
		for(ROIObserverDecorator o: this.obs){
			try{
				o.getRegion().intersect(r);
				oList.add(o.getROIObserver());
			}catch(NoIntersectionException e){
				
			}
		}
		ROIObserver[] oArray = new ROIObserver[oList.size()];
		oArray = oList.toArray(oArray);
		return oArray;
	}

	@Override
	public void suspendObservable() {
		// TODO Auto-generated method stub
		suspended = true;
	}

	@Override
	public void resumeObservable() {
		// TODO Auto-generated method stub
		suspended = false;
		for(ROIObserverDecorator o:this.obs){
			try{
				Region intersection = o.getRegion().intersect(changes);
				o.notify(this, intersection);
			}catch (NoIntersectionException e){
				
			}
		}
		changes = null;
	}

}
