package a5.srig;

import static org.junit.Assert.*;
import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "testSample";
		
		return test_names;
	}
		
	@Test
	public void testSample() {
		Picture a = new  PictureImpl(10,10);
		Iterator<Pixel> iter = a.sample(0, 0, 1, 1);
		assertEquals("Sample method is not working", iter.next(), a.iterator().next());
	}
}
