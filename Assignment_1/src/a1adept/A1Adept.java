package a1adept;

import java.util.Scanner;

public class A1Adept {

	// Do not change the main method.
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process(s);

	}

	public static void process(Scanner s) {
		//initial variables
		String letterGrade = "no grade?";
		String initial;
		int numAssignments = s.nextInt();
		int[] ptsAssignments = new int[numAssignments];
		int numStudents = s.nextInt();
		String[] studentRecords = new String[numStudents];
		String firstName, lastName;
		double reciGrade;
		double[] grade = new double[numAssignments];
		double[] assignments = new double[numAssignments];
		double midterm_1, midterm_2, final_test;
		//assign assignment points to array
		for (int i = 0; i < numAssignments; i++) {
			ptsAssignments[i] = s.nextInt();
			//System.out.print(ptsAssignments[i] + " ");
		}
		
		//runs for each student, calculates their stats
		for (int i = 0; i < numStudents; i++) {
			firstName = s.next();
			initial = firstName.substring(0, 1) + ".";
			lastName = s.next();
			reciGrade = (s.nextInt()* 1.0d)/15;
			for (int j = 0; j < numAssignments; j++) {
				assignments[j] = s.nextDouble();
				//grade[j] = perToGpa(assignments[j], j);
				if(isBetween((assignments[j]/ptsAssignments[j]), .7,.9)){
					grade[j] = 10*(assignments[j]/ptsAssignments[j]) - 5.5;
				}else if(isBetween((assignments[j]/ptsAssignments[j]), .4,.7)){
					grade[j] = 5*(assignments[j]/ptsAssignments[j]) - 2;
				}
			}
			if(isBetween(reciGrade, .7,.9)){
				reciGrade = 10*(reciGrade) - 5.5;
			}else if(isBetween((reciGrade), .4,.7)){
				reciGrade = 5*(reciGrade) - 2;
			}
			double gpaAss = averageGPA(grade);
			midterm_1 = s.nextDouble();
			midterm_2 = s.nextDouble();
			final_test = s.nextDouble();
			
			double gpa = ((final_test*.2)+(midterm_1*.15)+(midterm_2*.15)+(gpaAss*.4)+(reciGrade*.1));
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
			studentRecords[i]= initial +" "+ lastName + " " + letterGrade;
		}
		for(int i = 0; i < numStudents; i++){
			System.out.println(studentRecords[i]);
		}	
	}
	public static boolean isBetween(double value, double min, double max)
	{
	  return((value > min) && (value < max));
	}
	public static double averageGPA(double[] array){
		double sum = 0;
		for(int i = 0; i < array.length; i++){
			sum = sum + array[i];
		}
		double average = sum / array.length;
		return average;
	}

}
