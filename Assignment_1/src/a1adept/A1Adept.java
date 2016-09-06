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
		double[] ptsAssignments = new double[numAssignments];
		double totalPtsAss = 0;
		double donePtsAss = 0;
		double gpaAss = 0;
		String firstName, lastName;
		int reci;
		double reciGrade;
		double[] assignments = new double[numAssignments];
		double midterm_1, midterm_2, final_test;
		//assign assignment points to array
		for (int i = 0; i < numAssignments; i++) {
			ptsAssignments[i] = s.nextInt();
			//System.out.print(ptsAssignments[i] + " ");
		}
		totalPtsAss = totalArray(ptsAssignments);
		int numStudents = s.nextInt();
		String[] studentRecords = new String[numStudents];
		//runs for each student, calculates their stats
		for (int i = 0; i < numStudents; i++) {
			firstName = s.next();
			initial = firstName.substring(0, 1) + ".";
			lastName = s.next();
			reci = s.nextInt();
			
			for (int j = 0; j < numAssignments; j++) {
				assignments[j] = s.nextDouble();
				/*
				if(isBetween((assignments[j]/ptsAssignments[j]), .7,.9)){
					grade[j] = 10*(assignments[j]/ptsAssignments[j]) - 5.5;
				}else if(isBetween((assignments[j]/ptsAssignments[j]), .4,.7)){
					grade[j] = 5*(assignments[j]/ptsAssignments[j]) - 2;
				}*/
			}
			donePtsAss = totalArray(assignments);
			reciGrade = (double) reci / 15.0;
			if(isBetween(reciGrade, .7,1.1)){
				reciGrade = 10*(reciGrade) - 5.5;
			}else if(isBetween((reciGrade), .4,.7)){
				reciGrade = 5*(reciGrade) - 2;
			}
			gpaAss = donePtsAss / totalPtsAss;
			if(isBetween(gpaAss, .7,1.1)){
				gpaAss = 10*(gpaAss) - 5.5;
			}else if(isBetween((gpaAss), .4,.7)){
				gpaAss = 5*(gpaAss) - 2;
			}
			//double gpaAss = averageArray(grade);
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
	
	public static double averageArray(double[] array){
		double sum = 0;
		for(int i = 0; i < array.length; i++){
			sum = sum + array[i];
		}
		double average = sum / array.length;
		return average;
	}
	public static double totalArray(double[] array){
		double sum = 0;
		for(int i = 0; i < array.length; i++){
			sum = sum + array[i];
		}
		return sum;
	}

}