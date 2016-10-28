package a5.srig;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {


	static public String[] getTestNames() {
		String[] test_names = new String[3];

		test_names[0] = "testGetX";
		test_names[1] = "testGetY";
		test_names[2] = "testGetPixel";
		return test_names;
	}

	@Test
	public void testGetX() {
		Coordinate a = new Coordinate(5, 10);
		assertEquals("Coordinate getX is not correct.", 5, a.getX());
	}

	@Test
	public void testGetY() {
		Coordinate a = new Coordinate(5, 10);
		assertEquals("Coordinate getY is not correct.", 10, a.getY());
	}

	@Test
	public void testGetPixel() {
		Picture a = new PictureImpl(5, 5);
		Coordinate c = new Coordinate(1, 1);

		assertEquals("Overloaded getPixel with Coordinate does not match X and Y values", a.getPixel(1, 1),
				a.getPixel(c));
	}
	
	

}
