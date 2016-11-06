package lec16.ex5;

import java.util.Observable;
import java.util.Observer;

public class GameImpl implements Game {
	private String home;
	private String visitor;
	private int home_score;
	private int visitor_score;
	private String sport;

	private ObservableGame observable_game;
	
	public GameImpl(String game_type, String visiting_team, String home_team) {
		sport = game_type;
		home = home_team;
		visitor = visiting_team;
		home_score = 0;
		visitor_score = 0;
		
		observable_game = new ObservableGame(this);
	}
	
	public void addObserver(Observer o) {
		observable_game.addObserver(o);
	}

	@Override
	public void scorePoints(String team, int points_to_add) {
		if (home.equals(team)) {
			home_score += points_to_add;
		} else if (visitor.equals(team)) {
			visitor_score += points_to_add;
		}
		observable_game.notifyObservers(team);
	}
	
	@Override
	public void printScore() {
		System.out.println(sport + ": " + visitor + " " + visitor_score + " - " + home_score + " " + home);
	}
	
	@Override
	public String whoIsWinning() {
		if (home_score > visitor_score) {
			return home;
		} else if (home_score < visitor_score) {
			return visitor;
		}
		return "Tie Game";
	}
}

class ObservableGame extends Observable implements Game {
	private Game actual_game;
	
	ObservableGame(Game game) {
		actual_game = game;
	}

	@Override
	public void scorePoints(String team, int points_to_add) {
		actual_game.scorePoints(team, points_to_add);
	}

	@Override
	public void printScore() {
		actual_game.printScore();
	}

	@Override
	public String whoIsWinning() {
		return actual_game.whoIsWinning();
	}

	@Override
	public void notifyObservers(Object arg) {
		setChanged();
		super.notifyObservers(arg);
	}
}