package lec04;

public class Lec04Example2 {

	public static void main(String[] args) {
		
		String s = "This is my string";
		
		// Length of string
		System.out.println("Length of s: " + s.length());
		
		// Character access
		char c = s.charAt(5);
		System.out.println("The sixth character of s: " + c);
		
		// Testing for equality
		if (s.equals("This is my string!")) {
			System.out.println("Equality test is true.");
		} else {
			System.out.println("Equality test is false.");			
		}
		
		// Extracting a substring
		
		String sub = s.substring(3, 12);
		System.out.println("Substring: " + sub);

		// Trimming space from beginning and end
		
		String trimmed = "    trim me     ".trim();
		System.out.println(">" + trimmed + "<");
		
		// Finding first occurrence of a substring
		
		int idx = s.indexOf("my");
		System.out.println(s.substring(idx));
		
	}

}
