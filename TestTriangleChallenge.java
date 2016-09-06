import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.io.OutputStream;

public class TestTriangleChallenge {
	@Test
	public void testGetSidesWithGoodSides() {
		String input = "3\n4\n5\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		PrintStream originalStream = System.out;
		PrintStream dummyStream    = new PrintStream(new OutputStream(){
			public void write(int b) {
				//NO-OP
			}
		});

		// disable all print statement
		System.setOut(dummyStream);

		// expected output
		BigDecimal[] sides = TriangleChallenge.getSides();
		BigDecimal s1 = new BigDecimal("3");
		BigDecimal s2 = new BigDecimal("4");
		BigDecimal s3 = new BigDecimal("5");

		assertEquals(s1, sides[0]);
		assertEquals(s2, sides[1]);
		assertEquals(s3, sides[2]);
	}

	@Test
	public void testGetSidesWithSomeBadSides() {
		String input = "d\n4.3\n44.42s\n4\n57f\n5\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		PrintStream originalStream = System.out;
		PrintStream dummyStream    = new PrintStream(new OutputStream(){
			public void write(int b) {
				//NO-OP
			}
		});

		// disable all print statement
		System.setOut(dummyStream);

		// expected output
		BigDecimal[] sides = TriangleChallenge.getSides();
		BigDecimal s1 = new BigDecimal("4.3");
		BigDecimal s2 = new BigDecimal("4");
		BigDecimal s3 = new BigDecimal("5");

		assertEquals(s1, sides[0]);
		assertEquals(s2, sides[1]);
		assertEquals(s3, sides[2]);
	}

	@Test
	public void testDescribeTriangle() {
		Catergory eq = Catergory.Equilateral; 
		Catergory is = Catergory.Isosceles; 
		Catergory sc = Catergory.Scalene; 
		Catergory br = Catergory.Broken; 

		// expected output
		String o1 = "It is an Equilateral triangle.";
		String o2 = "It is an Isosceles triangle.";
		String o3 = "It is an Scalene triangle.";
		String o4 = "It is not a triangle.";

		// assertions
		assertEquals(o1, TriangleChallenge.describeTriangle(eq));
		assertEquals(o2, TriangleChallenge.describeTriangle(is));
		assertEquals(o3, TriangleChallenge.describeTriangle(sc));
		assertEquals(o4, TriangleChallenge.describeTriangle(br));
	}
}