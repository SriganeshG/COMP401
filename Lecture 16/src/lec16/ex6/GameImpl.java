package lec16.ex6;

import java.util.Observable;
import java.util.Observer;

public class GameImpl implements Game {
	private String home;
	private String visitor;
	private int home_score;
	private int visitor_score;
	private String sport;

	private ObservableGameEvent score_change;
	private ObservableGameEvent lead_change;
	private ObservableGameEvent big_lead;
	
	public GameImpl(String game_type, String visiting_team, String home_team) {
		sport = game_type;
		home = home_team;
		visitor = visiting_team;
		home_score = 0;
		visitor_score = 0;
		
		score_change = new ObservableGameEvent(this);
		lead_change = new ObservableGameEvent(this);
		big_lead = new ObservableGameEvent(this);
	}
	
	public void addScoreChangeObserver(Observer o) {
		score_change.addObserver(o);
	}

	public void addLeadChangeObserver(Observer o) {
		lead_change.addObserver(o);
	}

	public void addBigLeadObserver(Observer o) {
		big_lead.addObserver(o);
	}

	@Override
	public void scorePoints(String team, int points_to_add) {
		String winning_before = whoIsWinning();
		
		if (home.equals(team)) {
			home_score += points_to_add;
		} else if (visitor.equals(team)) {
			visitor_score += points_to_add;
		}
		
		if (!winning_before.equals(whoIsWinning())) {
			if (!whoIsWinning().equals("Tie Game")) {
				lead_change.notifyObservers(team);
			}
		}
		
		score_change.notifyObservers(team);
		
		if (Math.abs(home_score - visitor_score) > 10) {
			big_lead.notifyObservers(team);
		}
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

class ObservableGameEvent extends Observable implements Game {
	private Game actual_game;
	
	ObservableGameEvent(Game game) {
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