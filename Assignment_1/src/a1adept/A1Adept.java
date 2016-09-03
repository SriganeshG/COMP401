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
		
		for (int i = 0; i < numAssignments; i++) {
			int[] ptsAssignments = new int[numAssignments];
			ptsAssignments[i] = s.nextInt();
			System.out.print(ptsAssignments[i] + " ");
		}
		
		int numStudents = s.nextInt();
		String firstName;
		String lastName;
		int numRecitation;
		double[] assignments = new double[numAssignments];
		double midterm_1;
		double midterm_2;
		double final_test;
		
		for (int i = 0; i < numStudents; i++) {
			firstName = s.next();
			lastName = s.next();
			numRecitation = s.nextInt();
			for (int j = 0; j < numAssignments; j++) {
				assignments[j] = s.nextDouble();
			}
			midterm_1 = s.nextDouble();
			midterm_2 = s.nextDouble();
			final_test = s.nextDouble();
			int gpa = ((final_test*.4)+(midterm_1*.15)+(midterm_2*.15)+())
		}
		
	}

}
