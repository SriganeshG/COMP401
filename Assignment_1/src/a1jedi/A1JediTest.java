package a1jedi;

import java.util.Scanner;

public class A1JediTest {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		process(s);

	}
	
	public static void process(Scanner s){
		int numAssignments = s.nextInt();
		double[] ptsAssignments = new double[numAssignments];
		for(int i = 0; i < numAssignments; i++){
			ptsAssignments[i] = s.nextInt();
		}
		int numStudents = s.nextInt();
		String[][] studentRecords = new String[numStudents][(numStudents * 2)+];
		
	}
}
