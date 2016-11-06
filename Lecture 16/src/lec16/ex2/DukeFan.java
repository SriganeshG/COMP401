package lec16.ex2;

public class DukeFan implements GameObserver {

	public void update(Game game) {
		if (game.whoIsWinning().equals("Duke")) {
			System.out.println("Go Devils!");
		}
	}
}
