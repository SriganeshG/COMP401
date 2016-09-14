package a2novice;

import java.util.Scanner;

public class A2Novice {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int width = s.nextInt();
		int height = s.nextInt();
		int[][] pixelDensity = new int[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				pixelDensity[i][j] = s.nextInt();
			}
		}
		s.close();
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				if (isBetween(pixelDensity[i][j], 0, 9)) {
					System.out.print("#");
				} else if (isBetween(pixelDensity[i][j], 10, 19)) {
					System.out.print("M");
				} else if (isBetween(pixelDensity[i][j], 20, 29)) {
					System.out.print("X");
				} else if (isBetween(pixelDensity[i][j], 30, 39)) {
					System.out.print("D");
				} else if (isBetween(pixelDensity[i][j], 40, 49)) {
					System.out.print("<");
				} else if (isBetween(pixelDensity[i][j], 50, 59)) {
					System.out.print(">");
				} else if (isBetween(pixelDensity[i][j], 60, 69)) {
					System.out.print("s");
				} else if (isBetween(pixelDensity[i][j], 70, 79)) {
					System.out.print(":");
				} else if (isBetween(pixelDensity[i][j], 80, 89)) {
					System.out.print("-");
				} else if (isBetween(pixelDensity[i][j], 90, 99)) {
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
		int pixMin = findMin(pixelDensity);
		int pixMax = findMax(pixelDensity);
		double pixAvg = findAvg(pixelDensity);
		System.out.println("Min value = "+pixMin);
		System.out.println("Max value = "+pixMax);
		System.out.println("Average value = "+ pixAvg);
	}

	public static int findMin(int[][] array){
		int temp = array[0][0];
		for(int i = 0; i < array.length;i++){
			for(int j = 0; j < array[i].length;j++){
				if(array[i][j] < temp){
					temp = array[i][j];
				}
			}
		}
		return temp;
	}
	
	public static int findMax(int[][] array){
		int temp = array[0][0];
		for(int i = 0; i < array.length;i++){
			for(int j = 0; j < array[i].length;j++){
				if(array[i][j] > temp){
					temp = array[i][j];
				}
			}
		}
		return temp;
	}
	
	public static double findAvg(int[][] a){
		double sum = 0;
		int count = 0;
		for(int i = 0; i < a.length;i++){
			for(int j = 0; j < a[i].length; j++){
				sum += a[i][j];
				count++;
			}
		}
		double avg = (double) sum / count;
		return avg;
	}
	
	public static boolean isBetween(double value, double min, double max) {
		return ((value >= min) && (value <= max));
	}

}
