package a2adept;

import java.util.Scanner;

public class A2Adept {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int binWidth = s.nextInt();
		int width = s.nextInt();
		int height = s.nextInt();
		int numBins = (int) Math.ceil(100.0/binWidth);
		int[] pixelIntensity = new int[width*height];
		int[] bin = new int[numBins];
		for(int i = 0; i < width*height;i++){
			pixelIntensity[i]=(s.nextInt()/binWidth);
		}
		for(int i = 0; i < pixelIntensity.length;i++){
			bin[pixelIntensity[i]]++;
		}
		int printCount = 0;
		double numPixels = height*width;
		for(int i = 0; i < numBins;i++){
			double asterisk =Math.floor((bin[i]/numPixels)*100.0);
			if(isBetween(printCount,0,9)){
				System.out.print(" "+printCount+":");
				for(int j = 0; j < asterisk; j++){
					System.out.print("*");
				}
				System.out.print("\n");
				printCount += binWidth;
			}else{
				System.out.print(printCount+":");
				for(int j = 0; j < asterisk; j++){
					System.out.print("*");
				}
				System.out.print("\n");
				printCount += binWidth;
			}
		}
		s.close();
	}
	public static boolean isBetween(double value, double min, double max) {
		return ((value >= min) && (value <= max));
	}

}
