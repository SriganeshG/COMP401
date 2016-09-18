package lec04;

public class Lec04Example3 {

	public static void main(String[] args) {
		
		String s1 = "A String";
		String s2 = "A String";
		String s3 = new String("A String");
		
		System.out.println("s1.equals(s2) is " + s1.equals(s2));
		System.out.println("s1.equals(s3) is " + s1.equals(s3));

		System.out.println("s1 == s2 is " + (s1 == s2));
		System.out.println("s1 == s3 is " + (s1 == s3));
			
	}
}
