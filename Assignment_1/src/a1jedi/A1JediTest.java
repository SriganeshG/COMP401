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
		String[] studentRecords = new String[numStudents];
		String[][] studentNames = new String[numStudents][2];
		double[][] studentRecitation = new double[numStudents][];
		double[][] studentAssignments = new double[numStudents][numAssignments];
		double[][] rawMidterm = new double[numStudents][2];
		double[][] rawFinal = new double[numStudents][];
		double stdDevMidterm,stdDevFinal, meanMidterm, meanFinal;
		
		for(int i = 0; i < numStudents; i++){
			/*
			for(int j = 0; j < (6+numAssignments); j++){
				studentNames[i][j] = s.next();
			}
			*/
			studentNames[i][0] = s.next();
			studentNames[i][1] = s.next();
			studentRecitation[i][0] = s.nextDouble();
			for(int j = 0; j < numAssignments; j++){
				studentAssignments[i][j] = s.nextDouble();
			}
			rawMidterm[i][0] = s.nextDouble();
			rawMidterm[i][1] = s.nextDouble();
			rawFinal[i][0] = s.nextDouble();
			meanMidterm = getMean(rawMidterm, i, rawMidterm.length);
			stdDevMidterm = getStdDev(rawMidterm, i, rawMidterm.length, meanMidterm);
		}
		
	}
	
	public static double getMean(double[][] array, int beginIndex, int loopCond){
		double sum = 0.0;
		
		for(int i = 0; i < loopCond; i++){
			sum += array[beginIndex][i] + sum;
		}
		
		double average = sum / array.length;
		return average;
	}
	
	public static double getVariance(double[][] array, int beginIndex, int loopCond, double mean){
		double temp = 0;
		for(int i = 0; i < loopCond; i++){
			temp += (array[beginIndex][i] - mean)*(array[beginIndex][i]);
		}
		return temp / array[beginIndex].length;
	}
	
	public static double getStdDev(double[][] array, int beginIndex, int loopCond, double mean){
		double stdDev = getVariance(array, beginIndex, loopCond, mean);
		return Math.sqrt(stdDev);
	}
}
