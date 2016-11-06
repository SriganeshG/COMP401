package lec16.ex1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		Game g = new GameImpl("Duke", "UNC");
		
		UNCFan tar_heel = new UNCFan(g);
		DukeFan dookie = new DukeFan(g);
				
		while (s.hasNext()) {
			String team = s.next();
			int points_to_add = s.nextInt();
			
			g.scorePoints(team, points_to_add);
			g.printScore();
		}
	}
}
