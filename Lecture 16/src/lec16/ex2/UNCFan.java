package lec16.ex2;

public class UNCFan implements GameObserver {

	public void update(Game game) {
		if (game.whoIsWinning().equals("UNC")) {
			System.out.println("Go Heels!");
		}
	}
}
