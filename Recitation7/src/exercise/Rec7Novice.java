package exercise;

import java.util.*;
import java.io.*;

public class Rec7Novice {

	public static void main(String[] args) {
		Scanner s = null;
		PrintWriter p = null;
		
		try{
			s = new Scanner(new BufferedReader(new FileReader("grades.txt")));
			p = new PrintWriter(new FileWriter("letter.txt"));
			int numStudent = s.nextInt();
			for(int i = 0 ; i < numStudent;i++){
				String initial = s.next().charAt(0)+", ";
				String lastName = s.next() +" ";
				double avg = 0;
				for(int j=0;j< weights.length;j++){
					avg += weights[j] *s.nextDouble()''
				}
				p.println(initial+lastName + )
			}
		}
	}

}
