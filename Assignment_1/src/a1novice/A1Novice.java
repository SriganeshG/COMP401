package a1novice;

import java.util.Scanner;

public class A1Novice {

	// Do not change the main method.
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process(s);
	}

	public static void process(Scanner s) {
		int numStudents = s.nextInt();
		String[] studentRecords = new String[numStudents];
		String firstName;
		String lastName;
		String initial;
		String letterGrade = "Failed to initialize";
		double assignmentGrade;
		double recitationGrade;
		double midterm_1;
		double midterm_2;
		double finalGrade;
		double gpa;
		for (int i = 0; i < (numStudents); i++) {
			firstName = s.next();
			lastName = s.next();
			initial = firstName.substring(0, 1) + ".";
			assignmentGrade = s.nextDouble();
			recitationGrade = s.nextDouble();
			midterm_1 = s.nextDouble();
			midterm_2 = s.nextDouble();
			finalGrade = s.nextDouble();
			gpa = ((.4 * assignmentGrade) + (.1 * recitationGrade)
					+ (.15 * midterm_1) + (.15 * midterm_2) + (.2 * finalGrade));
			if (gpa >= 3.85) {
				letterGrade = "A";
			} else if (isBetween(gpa,3.5,3.85)) {
				letterGrade = "A-";
			} else if (isBetween(gpa,3.15,3.85)) {
				letterGrade = "B+";
			} else if (isBetween(gpa,2.85,3.15)) {
				letterGrade = "B";
			} else if (isBetween(gpa,2.5,2.85)) {
				letterGrade = "B-";
			} else if (isBetween(gpa,2.15,2.5)) {
				letterGrade = "C+";
			} else if (isBetween(gpa,1.85,2.15)) {
				letterGrade = "C";
			} else if (isBetween(gpa,1.5,1.85)) {
				letterGrade = "C-";
			} else if (isBetween(gpa,1.15,1.5)) {
				letterGrade = "D+";
			} else if (isBetween(gpa,.85,1.15)) {
				letterGrade = "D";
			} else if (gpa < 0.85) {
				letterGrade = "F";
			}
			studentRecords[i] = initial + " " + lastName +" "+ letterGrade;
		}
		for (int i = 0; i < numStudents;i++){
			System.out.println(studentRecords[i]);
		}

	}
	
	public static boolean isBetween(double value, double min, double max)
	{
	  return((value > min) && (value < max));
	}
}
