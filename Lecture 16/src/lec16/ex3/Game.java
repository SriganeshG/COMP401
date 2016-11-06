package lec16.ex3;

public interface Game {

	public void addObserver(GameObserver o);

	public void deleteObserver(GameObserver o);

	public void notifyObservers(String who_scored);

	public void scorePoints(String team, int points_to_add);

	public void printScore();

	public String whoIsWinning();

}