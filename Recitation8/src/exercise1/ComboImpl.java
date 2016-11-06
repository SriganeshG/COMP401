package exercise1;

public class ComboImpl implements Combo {
	private Sandwich s;

	private String side;
	private double sidePrice;
	public ComboImpl(Sandwich s, String side) {
		this.s = s;
		switch(side){
		//assign this.side and this.sidePrice
		
		}
		this.makeSmall(); //default small combo
	}

	public String getSandwich() {
		return s.getSandwich();
	}

	public double getPrice() {
		return s.getPrice() + this.sidePrice *1.075;

	}
	
	public String getSide(){
		return this.side;
	}

	public void makeSmall() {
		
	}

	public void makeMedium() {

	}

	public void makeLarge() {

	}
}
