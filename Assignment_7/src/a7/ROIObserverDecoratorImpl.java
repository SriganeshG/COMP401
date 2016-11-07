package a7;

public class ROIObserverDecoratorImpl implements ROIObserverDecorator {
	protected ROIObserver op;
	protected Region r;
	
	public ROIObserverDecoratorImpl(ROIObserver op, Region r){
		this.op = op;
		this.r = r;
	}
	
	
	public void notify(ObservablePicture picture, Region changed_region) {
		
	}
	
	public Region getRegion(){
		return r;
	}
	
	public ROIObserver getROIObserver(){
		return op;
	}

}
