package lec16.ex5;

import java.util.Observer;
import java.util.Observable;

public class DukeFan implements Observer {

	public void update(Observable o, Object arg) {
		Game game = (Game) o;
		String who_scored = (String) arg;
		
		if (who_scored.equals("Duke")) {
			if (game.whoIsWinning().equals("Duke")) {
				System.out.println("Go Devils!");
			} else {
				System.out.println("Getting there, Duke!");
			}
		} 
	}
}
