import java.util.Scanner;
import java.math.BigDecimal;

public class TriangleChallenge {
	public static void main(String args[]) {
		BigDecimal[] sides = getSides();

		System.out.print("\nSides: ");
		System.out.println(sides[0].toString()+" "+sides[1].toString()+" "+sides[2].toString());

		Triangle t = new Triangle(sides[0], sides[1], sides[2]);
		Catergory c = t.catergorize();
		System.out.println(describeTriangle(c));
	}

	public static BigDecimal[] getSides() {
		BigDecimal[] sides = new BigDecimal[3];
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter side1:");
		sides[0] = getSidesLooper(sc);

		System.out.println("Enter side2:");
		sides[1] = getSidesLooper(sc);

		System.out.println("Enter side3:");
		sides[2] = getSidesLooper(sc);

		sc.close();
		return sides;
	}

	private static BigDecimal getSidesLooper(Scanner sc) {
		while (!sc.hasNextBigDecimal()) {
			System.out.println("		number, please: ");
			sc.nextLine();
		}
		BigDecimal side = sc.nextBigDecimal();
		sc.nextLine();

		return side;
	}

	public static String describeTriangle(Catergory c) {
		switch (c) {
			case Equilateral:
				return "It is an Equilateral triangle.";
			case Isosceles:
				return "It is an Isosceles triangle.";
			case Scalene:
				return "It is an Scalene triangle.";
			case Broken:
				return "It is not a triangle.";
		}
		return null;
	}
}