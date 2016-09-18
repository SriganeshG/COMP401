package lec04;

public class Lec04Example5 {
	public static void main(String[] args) {
		
		int[] a = {1, 1, 2, 3, 5, 8};
		
		// We can pass arrays as arguments to another method
		print_array("Original a", a);
		
		// Arrays are reference types, so copying an
		// array reference from one variable to another
		// does NOT create a new array.
		// Instead, the two variables simply refer
		// to the same array.
		
		int[] b = a;
		
		// This means that if we change the contents
		// of the array using one of the variables,
		// the contents change with respect to the other variable
		// as well since they are simply pointing to the same array.
		
		a[0] = 10;
		b[1] = 20;
		
		print_array("a now", a);
		print_array("b now", b);
		
		// Similarly, if we send the array to a method 
		// and that method changes its contents, then
		// those changes are "seen" via our original
		// reference
		
		print_array("a before add_one_to_all", a);
		add_one_to_all(a);		
		print_array("a after add_one_to_all", a);
		
		// And since a and b are still both
		// referencing the same variable, accessing
		// the array via b gives us the same values
		
		print_array("b at this point", b);
		
		// The clone() method of arrays will 
		// create a brand new array of the same
		// type and copy each element from the
		// original to the new array and return
		// the new array. 
		
		b = a.clone();
		
		// So now, b and a have the same element
		// values.
		
		print_array("a after clone", a);
		print_array("b after clone", b);
		
		// But are not the same array.
		
		add_one_to_all(a);
		
		print_array("a is modified", a);
		print_array("b is not", b);
		
		// So if you need to pass an array
		// to a method but want to ensure
		// that nothing happens to your original
		// values, pass a clone instead.
		// Don't even need to create a variable
		// to do this.
		
		print_array("a before passing clone to add_one_to_all", a);
		add_one_to_all(a.clone());
		print_array("a after passing clone to add_one_to_all", a);		
	}

	// This method accepts an array of int's as its second parameter
	// and prints its contents along with a label provided as its
	// first parameter.
	public static void print_array(String label, int[] array_to_print) {
		System.out.print(label + ": ");
		for (int i=0; i<array_to_print.length; i++) {
			System.out.print(array_to_print[i]);

			if (i != array_to_print.length-1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}
	
	
	public static void add_one_to_all(int[] array_to_modify) {
		for (int i=0; i<array_to_modify.length; i++) {
			array_to_modify[i] += 1;
		}
	}
}
