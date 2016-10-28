package example;

import java.io.*;

public class HandleException {

	public static void main(String[] args) throws IOException {
		
		Reader in = null;
		try {
			// stuff that may throws an exception
			in = new FileReader("input.txt");
			System.out.println("Reader created");
		} catch (Exception e) {
			// if an exception is caught, handle it
			System.out.println("opening file failed");
			System.out.println("Error: " + e);
		} finally {
			// some clean up, will execute no matter what
			System.out.println("executing finally block");
			if (in != null) {
				in.close();
			}
		}
	}

}
