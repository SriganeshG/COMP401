package lec16.ex1;

public class DukeFan implements GameObserver {

	private Game game;
	
	public DukeFan(Game g) {
		game = g;
		game.addObserver(this);
	}
	
	public void update() {
		if (game.whoIsWinning().equals("Duke")) {
			System.out.println("Go Devils!");
		}
	}
}
