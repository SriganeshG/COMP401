package a1adept;

import java.util.Scanner;

public class A1Adept {
	
	// Do not change the main method.	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		process(s);
		
	}
	
	public static void process(Scanner s) {
		int numAssignments = s.nextInt();
		for(int i = 0; i < numAssignments; i++){
			int[] ptsAssignments = new int[numAssignments];
			ptsAssignments[i] = s.nextInt();
			System.out.print(ptsAssignments[i]+" ");
		}
		int numStudents = s.nextInt();
		
	}

}
