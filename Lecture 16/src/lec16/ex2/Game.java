package lec16.ex2;

public interface Game {

	public void addObserver(GameObserver o);

	public void deleteObserver(GameObserver o);

	public void notifyObservers();

	public void scorePoints(String team, int points_to_add);

	public void printScore();

	public String whoIsWinning();

}