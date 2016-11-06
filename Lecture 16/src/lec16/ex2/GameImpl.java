package lec16.ex2;

import java.util.List;
import java.util.ArrayList;

public class GameImpl implements Game {
	private String home;
	private String visitor;
	private int home_score;
	private int visitor_score;
	private String sport;

	private List<GameObserver> observers;

	public GameImpl(String game_type, String visiting_team, String home_team) {
		sport = game_type;
		home = home_team;
		visitor = visiting_team;
		home_score = 0;
		visitor_score = 0;
		
		observers = new ArrayList<GameObserver>();
	}

	@Override
	public void addObserver(GameObserver o) {
		// Adds o to list of observers
		observers.add(o);
	}

	@Override
	public void deleteObserver(GameObserver o) {
		// Takes o off list of observers
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		// Trigger update method on
		// all observers
		for (GameObserver o : observers) {
			o.update(this);
		}
	}
	
	@Override
	public void scorePoints(String team, int points_to_add) {
		if (home.equals(team)) {
			home_score += points_to_add;
		} else if (visitor.equals(team)) {
			visitor_score += points_to_add;
		}
		notifyObservers();
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
