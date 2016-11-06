package lec16.ex1;

public class UNCFan implements GameObserver {

	private Game game;
	
	public UNCFan(Game g) {
		game = g;
		game.addObserver(this);

	}
	
	public void update() {
		if (game.whoIsWinning().equals("UNC")) {
			System.out.println("Go Heels!");
		}
	}
}
