package a5.srig;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "testZigZag";
		
		return test_names;
	}
		
	@Test
	public void testZigZag() {
		Picture a = new PictureImpl(5,5);
		Iterator<Pixel> aZigZag = a.zigzag();
		Pixel b = aZigZag.next();
		assertEquals("zigzag not working as intended",a.getPixel(1, 1), b);
	}
}
