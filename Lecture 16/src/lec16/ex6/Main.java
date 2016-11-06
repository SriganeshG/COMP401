package lec16.ex6;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		GameImpl[] games = new GameImpl[3];
		games[0] = new GameImpl("Basketball", "Duke", "UNC");
		games[1] = new GameImpl("Baseball", "UNC" , "NCState");
		games[2] = new GameImpl("Lacrosse", "Duke", "Georgetown");
		
		UNCFan tar_heel = new UNCFan();
		DukeFan dookie = new DukeFan();
		UNCFan tar_heel2 = new UNCFan();
		
		for (GameImpl g : games) {
			g.addScoreChangeObserver(tar_heel);
			g.addScoreChangeObserver(dookie);
			g.addBigLeadObserver(tar_heel2);
		}
		
		while (s.hasNext()) {
			int gidx = s.nextInt();
			
			String team = s.next();
			int points_to_add = s.nextInt();
			
			games[gidx].scorePoints(team, points_to_add);
			games[gidx].printScore();
		}
	}
}
