package lec16.ex6;

import java.util.Observer;
import java.util.Observable;

public class UNCFan implements Observer {

	public void update(Observable o, Object arg) {
		Game game = (Game) o;
		String who_scored = (String) arg;
		
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
