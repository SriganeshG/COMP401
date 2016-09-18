package lec04;

public class Lec04Example4 {

	public static void main(String[] args) {
		
		int[] a1;
		
		// iarray is declared to be a 
		// variable that can reference an
		// array of int's, but the array hasn't 
		// been created yet.
		
		// At this point, the value of a1 is null
		
		a1 = new int[10];
		
		// Now iarray references (aka "points to")
		// a new array of 10 integers
		// The default value for each element is 0.
		
		System.out.println("The length of iarray is: " + 
							a1.length);
		
		// Indexing is done with [] as in.
		// This is both for retrieving and setting.
		
		a1[0] = 42;
		a1[1] = 2;
		a1[2] = 120;
		a1[3] = 5;
		
		// What is the value of iarray[4]?
		// Since it hasn't been set yet, it gets the
		// default value for the type. In this case 0.
		
		System.out.println("iarray[4] = " + a1[4]);
		
		// We can also create an array literally by
		// specifying a sequence of values after the new
		// constructor for the appropriate type.

		a1 = new int[] {5, 6, 7};
		
		// Notice that I reused the a1 variable.
		// Same variable, but now a different array.
		// The old array will be "garbage collected"
		// if there isn't some other reference to it.
		
		System.out.println("The length of iarray is: " +
						   a1.length);
		
		// If you are declaring and initializing
		// an array variable with literals at the
		// same time, there is a shorthand for that as in:
		
		String[] sa1 = {"One fish", 
				        "Two fish", 
				        "Red fish", 
				        "Blue fish"};
		
		// A common operation is to run a for
		// loop across the elements of an array.
		// Here is one commonly used way to do that:
		
		int sum_of_lengths = 0;
		for (int i=0; i<sa1.length; i++) {
			String s = sa1[i];
			sum_of_lengths += s.length();
			
			// Can do the above without using 
			// an extra variable just as easily:
			//sum_of_lengths += sa1[i].length();
		}
		
		System.out.println("The sum of string lengths is: " +
		                   sum_of_lengths);
		
	}
}
