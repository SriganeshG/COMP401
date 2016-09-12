package a1jedi;

import java.util.Scanner;


public class A1Jedi {

	// Do not change the main method.
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process(s);

	}

	public static void process(Scanner s) {
		//initial variables
		//String letterGrade = "no grade?";
		//String initial;
		int numAssignments = s.nextInt();
		double[] ptsAssignments = new double[numAssignments];
		double totalPtsAss = 0;
		double donePtsAss = 0;
		//String firstName, lastName;
		int reci;
		double[] assignments = new double[numAssignments];
		//assign assignment points to array
		for (int i = 0; i < numAssignments; i++) {
			ptsAssignments[i] = s.nextInt();
			//System.out.print(ptsAssignments[i] + " ");
		}
		totalPtsAss = totalArray(ptsAssignments);
		int numStudents = s.nextInt();
		double[] gpaAss = new double[numStudents];
		double[] reciGrade = new double[numStudents];
		//String[] studentRecords = new String[numStudents];
		double[] rawMid1 = new double[numStudents];
		double[] rawMid2 = new double[numStudents];
		double[] rawFinal = new double[numStudents];
		//runs for each student, calculates their stats
		for (int i = 0; i < numStudents; i++) {
			s.next();
			//initial = firstName.substring(0, 1) + ".";
			s.next();
			reci = s.nextInt();
			
			for (int j = 0; j < numAssignments; j++) {
				assignments[j] = s.nextDouble();
			}
			donePtsAss = totalArray(assignments);
			reciGrade[i] = (double) reci / 15.0;
			if(reciGrade[i] >= 1){
				reciGrade[i] = 4.0;
			}else if(isBetween(reciGrade[i], .7,1)){
				reciGrade[i] = 10*(reciGrade[i]) - 5.5;
			}else if(isBetween((reciGrade[i]), .4,.7)){
				reciGrade[i] = 5*(reciGrade[i]) - 2;
			}
			gpaAss[i] = donePtsAss / totalPtsAss;
			if(isBetween(gpaAss[i], .7,1)){
				gpaAss[i] = 10*(gpaAss[i]) - 5.5;
			}else if(isBetween((gpaAss[i]), .4,.7)){
				gpaAss[i] = 5*(gpaAss[i]) - 2;
			}
			//double gpaAss = averageArray(grade);
			rawMid1[i] = s.nextDouble();
			rawMid2[i] = s.nextDouble();
			rawFinal[i] = s.nextDouble();
			
			
			//studentRecords[i]= initial +" "+ lastName + " " + letterGrade;
		}
		
		double avgMid1 = averageArray(rawMid1);
		double avgMid2 = averageArray(rawMid2);
		double avgFinal = averageArray(rawFinal);
		double stdDevMid1 = Math.sqrt(getVariance(rawMid1, avgMid1));
		double stdDevMid2 = Math.sqrt(getVariance(rawMid2, avgMid2));
		double stdDevFinal = Math.sqrt(getVariance(rawFinal, avgFinal));
		int a = 0,am = 0,bp = 0,b = 0,bm = 0,cp = 0,c = 0,cm = 0,dp = 0,d =0,dm = 0,f = 0;
		double nMid1,nMid2,nFinal;
		for(int i = 0; i < numStudents; i++){
			nMid1 = (rawMid1[i] - avgMid1)/stdDevMid1;
			nMid2 = (rawMid2[i]-avgMid2)/stdDevMid2;
			nFinal = (rawFinal[i] - avgFinal)/stdDevFinal;
			double curvedMid1 = curved(nMid1);
			double curvedMid2 = curved(nMid2);
			double curvedFinal = curved(nFinal);
			
			double gpa = ((curvedFinal*.2)+(curvedMid1*.15)+(curvedMid2*.15)+(gpaAss[i]*.4)+(reciGrade[i]*.1));
			if (gpa >= 3.85) {
				
				a++;
			} else if (isBetween(gpa,3.5,3.85)) {
				
				am++;
			} else if (isBetween(gpa,3.15,3.85)) {
			
				bp++;
			} else if (isBetween(gpa,2.85,3.15)) {
				
				b++;
			} else if (isBetween(gpa,2.5,2.85)) {
				
				bm++;
			} else if (isBetween(gpa,2.15,2.5)) {
				
				cp++;
			} else if (isBetween(gpa,1.85,2.15)) {
				
				c++;
			} else if (isBetween(gpa,1.5,1.85)) {
				
				cm++;
			} else if (isBetween(gpa,1.15,1.5)) {
				
				dp++;
			} else if (isBetween(gpa,.85,1.15)) {
				
				d++;
			} else if (gpa < 0.85) {
				
				f++;
			}
			
		}
		/*
		for(int i = 0; i < numStudents; i++){
			System.out.println(studentRecords[i]);
		}
		*/
		System.out.println("A :" + a);
		System.out.println("A- :" +am);
		System.out.println("B+ :" +bp);
		System.out.println("B :"+b);
		System.out.println("B- :"+bm);
		System.out.println("C+ :" + cp);
		System.out.println("C :"+c);
		System.out.println("C- :"+cm);
		System.out.println("D+ :" + dp);
		System.out.println("D :"+d);
		System.out.println("D- :"+dm);
		System.out.println("F :"+f);
		
	}
	public static boolean isBetween(double value, double min, double max)
	{
	  return((value >= min) && (value <= max));
	}
	
	public static double curved(double normalized){
		
		if(normalized >= 1){
			normalized = 4;
		}else if(isBetween(normalized,-1,1)){
			normalized = normalized + 3; 
		}else if(isBetween(normalized,-2,-1)){
			normalized = (normalized*2)+4;
		}
		
		return normalized;
	}
	
	public static double averageArray(double[] array){
		double sum = 0;
		for(int i = 0; i < array.length; i++){
			sum = sum + array[i];
		}
		double average = sum / array.length;
		return average;
	}
	
	public static double getVariance(double[] array, double avg){
		double temp = 0;
		for(int i = 0; i < array.length; i++){
			temp += (array[i] - avg)*(array[i]- avg);
		}
		return temp / array.length;
	}
	
	public static double totalArray(double[] array){
		double sum = 0;
		for(int i = 0; i < array.length; i++){
			sum = sum + array[i];
		}
		return sum;
	}
	
	/*
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
	*/
}
