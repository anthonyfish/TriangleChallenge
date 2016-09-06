import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;

public class TestTriangle {
   @Test
   public void testTriangleConstrutor() {
      //test data
      BigDecimal side = new BigDecimal("3");
      Triangle tri = new Triangle(side, side, side);

      assertNotNull(tri);
   }

   @Test
   public void testValidateWithValidSides() {
      //test data
      BigDecimal side1 = new BigDecimal("3");
      BigDecimal side2 = new BigDecimal("4");
      BigDecimal side3 = new BigDecimal("5");

      Triangle tri1 = new Triangle(side1, side1, side1);
      assertTrue(tri1.Validate());
      Triangle tri2 = new Triangle(side2, side3, side3);
      assertTrue(tri2.Validate());
      Triangle tri3 = new Triangle(side1, side2, side3);
      assertTrue(tri3.Validate());
   }

   @Test
   public void testBalidateWithNegativeSides() {
      //test data
      BigDecimal side1 = new BigDecimal("-3");
      BigDecimal side2 = new BigDecimal("4");
      BigDecimal side3 = new BigDecimal("5");

      // three negative sides
      Triangle tri1 = new Triangle(side1, side1, side1);
      assertFalse(tri1.Validate());
      // two negative sides
      Triangle tri2 = new Triangle(side2, side1, side1);
      assertFalse(tri2.Validate());
      // one negative sides
      Triangle tri3 = new Triangle(side1, side2, side3);
      assertFalse(tri3.Validate());
   }

   @Test
   public void testBalidateWithZeroSides() {
      //test data
      BigDecimal side1 = new BigDecimal("0");
      BigDecimal side2 = new BigDecimal("4");
      BigDecimal side3 = new BigDecimal("5");

      // three zero sides
      Triangle tri1 = new Triangle(side1, side1, side1);
      assertFalse(tri1.Validate());
      // two zero sides
      Triangle tri2 = new Triangle(side2, side1, side1);
      assertFalse(tri2.Validate());
      // one zero sides
      Triangle tri3 = new Triangle(side1, side2, side3);
      assertFalse(tri3.Validate());
   }

   @Test
   public void testValidateWithInvalidSides() {
      //test data
      BigDecimal side1 = new BigDecimal("1.5");
      BigDecimal side2 = new BigDecimal("4");
      BigDecimal side3 = new BigDecimal("7");

      Triangle tri1 = new Triangle(side1, side2, side3);
      assertFalse(tri1.Validate());
      Triangle tri2 = new Triangle(side1, side1, side3);
      assertFalse(tri2.Validate());
   }

   @Test
   public void testCatergorize() {
      //test data
      BigDecimal side0 = new BigDecimal("1");
      BigDecimal side1 = new BigDecimal("3");
      BigDecimal side2 = new BigDecimal("4");
      BigDecimal side3 = new BigDecimal("5");
      Catergory eq = Catergory.Equilateral;
      Catergory is = Catergory.Isosceles;
      Catergory sc = Catergory.Scalene;
      Catergory br = Catergory.Broken;

      // Equilateral triangle
      Triangle tri1 = new Triangle(side1, side1, side1);
      assertEquals(eq, tri1.catergorize());
      // Isosceles triangle
      Triangle tri2 = new Triangle(side1, side1, side3);
      assertEquals(is, tri2.catergorize());
      // Scalene triangle
      Triangle tri3 = new Triangle(side1, side2, side3);
      assertEquals(sc, tri3.catergorize());
      // Broken triangle
      Triangle tri4 = new Triangle(side0, side0, side1);
      assertEquals(br, tri4.catergorize());
   }

   @Test
   public void testValidateWithBigSides() {
      //test data
      BigDecimal side1 = new BigDecimal("1.99769313486231576E+309 ");
      BigDecimal side2 = new BigDecimal("0.79769313486231574E+309 ");
      BigDecimal side3 = new BigDecimal("1.39769313486231579E+309 ");

      Triangle tri1 = new Triangle(side1, side1, side1);
      assertTrue(tri1.Validate());
      Triangle tri2 = new Triangle(side2, side3, side3);
      assertTrue(tri2.Validate());
      Triangle tri3 = new Triangle(side1, side2, side3);
      assertTrue(tri3.Validate());
   }
}