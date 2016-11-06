package lec16.ex3;

public class DukeFan implements GameObserver {

	public void update(Game game, String who_scored) {
		if (who_scored.equals("Duke")) {
			if (game.whoIsWinning().equals("Duke")) {
				System.out.println("Go Devils!");
			} else {
				System.out.println("Getting there, Duke!");
			}
		} 
	}
}
