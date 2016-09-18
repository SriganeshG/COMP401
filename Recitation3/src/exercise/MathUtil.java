package exercise;

public class MathUtil {
	
	public static double[] getMidpoint(double[] point1, double[] point2) {
		double x1 = point1[0];
		double y1 = point1[1];
		double x2 = point2[0];
		double y2 = point2[1];
		
		double x = (x1+x2)/2;
		double y = (y1+y2)/2;
		double[] midpoint = {x,y};
		
		return midpoint;
	}
	
	public static double linearInterpolate(double[] point1, double[] point2, double x) {
		double x1 = point1[0];
		double y1 = point1[1];
		double x2 = point2[0];
		double y2 = point2[1];
		
		double y = y1 + (y2-y1)*(x-x1)/(x2-x1);
		return y;
	}
	
	public static double computeMean(double[] nums) {
		double sum = 0;
		for (int i = 0; i < nums.length; ++i) {
			sum += nums[i];
		}
		
		return sum/nums.length;
	}
	
}
