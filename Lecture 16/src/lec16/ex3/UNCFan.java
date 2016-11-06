package lec16.ex3;

public class UNCFan implements GameObserver {

	public void update(Game game, String who_scored) {
		if (who_scored.equals("UNC")) {
			if (game.whoIsWinning().equals("UNC")) {
				System.out.println("GO HEELS!");
			} else {
				System.out.println("Good job, Carolina.");
			}
		} else if (game.whoIsWinning().equals("UNC")) {
			System.out.println("Stay tough, Heels.");
		}
	}
}
