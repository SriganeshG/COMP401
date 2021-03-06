package a2jedi;

import java.util.Scanner;

public class A2Jedi {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int binWidth = s.nextInt();
		int width = s.nextInt();
		int height = s.nextInt();
		int numBins = (int) Math.ceil(100.0 / binWidth);
		int[] pixelIntensity = new int[width * height];
		int[] bin = new int[numBins];

		for (int i = 0; i < width * height; i++) {
			pixelIntensity[i] = (s.nextInt() / binWidth);
		}
		s.close();
		for (int i = 0; i < pixelIntensity.length; i++) {
			bin[pixelIntensity[i]]++;
		}
		// int printCount = 0;
		double numPixels = height * width;
		double[] numStars = new double[numBins];
		for (int i = 0; i < numBins; i++) {
			numStars[i] = Math.floor((bin[i] / numPixels) * 100.0);
		}
		double max = getLargestValD(numStars);

		/*
		 * for(double max = getLargestValD(numStars); 0 < getLargestVal(bin);
		 * max--){ for(int j = 0; j < bin.length; j++){ if(bin[j] == 0){
		 * System.out.print("*"); }else{ System.out.print(" "); }
		 * System.out.print("\n"); } //System.out.print("test"); }
		 */

		for (int i = 0; i < max; i++) {
			for (int j = 0; j < numBins; j++) {
				if (i < max - numStars[j]) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
				//System.out.print(j);
			}
			System.out.print("\n");
		}

		for (int i = 0; i < numBins; i++) {
			System.out.print("-");
		}
		// int printCount = 0;
		System.out.print("\n");
		for (int i = 0; i < numBins; i++) {
			if ((i * binWidth / 10) % 10 == 0) {
				System.out.print(" ");
			} else {
				System.out.print((i * binWidth / 10) % 10);
			}
		}
		System.out.print("\n");
		for (int i = 0; i < numBins; i++) {
			System.out.print((i * binWidth) % 10);
		}

	}

	public static int getLargestVal(int[] a) {
		int max = a[0];
		for (int i = 0; i < a.length; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		return max;
	}

	public static double getLargestValD(double[] a) {
		double max = a[0];
		for (int i = 0; i < a.length; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		return max;
	}

	public static boolean isBetween(double value, double min, double max) {
		return ((value >= min) && (value <= max));
	}

}
