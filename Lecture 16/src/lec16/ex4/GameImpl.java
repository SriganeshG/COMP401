package lec16.ex4;

import java.util.Observable;

public class GameImpl extends Observable implements Game {
	private String home;
	private String visitor;
	private int home_score;
	private int visitor_score;
	private String sport;

	public GameImpl(String game_type, String visiting_team, String home_team) {
		sport = game_type;
		home = home_team;
		visitor = visiting_team;
		home_score = 0;
		visitor_score = 0;		
	}

	@Override
	public void scorePoints(String team, int points_to_add) {
		if (home.equals(team)) {
			home_score += points_to_add;
		} else if (visitor.equals(team)) {
			visitor_score += points_to_add;
		}
		setChanged();
		notifyObservers(team);
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
