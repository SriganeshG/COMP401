package lec16.ex5;

public interface Game {

	public void scorePoints(String team, int points_to_add);

	public void printScore();

	public String whoIsWinning();

}