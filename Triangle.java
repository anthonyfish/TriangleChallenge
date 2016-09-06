/* Triangle Challenge: 
Write a program that will determine the type of a  triangle. 
It should take the lengths of the  triangle's three sides as input, 
and return whether the  triangle is equilateral, isosceles or scalene.

We are looking for solutions that showcase problem solving skills and 
structural considerations that can be applied to larger and potentially 
more complex problem domains. Pay special attention to tests, readability 
of code and error cases. Please complete this using Java. Once it is 
complete, push it into Github and send me the link. 
*/
import java.math.BigDecimal;


public class Triangle {
	private BigDecimal side1, side2, side3;

	// constructor
	public Triangle(BigDecimal side1, BigDecimal side2, BigDecimal side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	private boolean greaterThanZERO(BigDecimal d) {
		return d.compareTo(BigDecimal.ZERO) == 1;
	}

	// check if the sides can form a triangle
	// return true if possible, false otherwise
	public boolean Validate() {
		if(greaterThanZERO(side1) && greaterThanZERO(side2) && greaterThanZERO(side3)) {
			if ((side1.add(side2)).compareTo(side3)==1 && (side2.add(side3)).compareTo(side1)==1 && (side3.add(side1)).compareTo(side2)==1) {
				return true;
			}
		}
		return false;
	}

	// catergorize triangle the triangle
	// return null if triangle is not valid
	public Catergory catergorize() {
		if (!Validate()) {
			return Catergory.Broken;
		}
		if (side1.compareTo(side2)==0 && side1.compareTo(side3)==0) {
			return Catergory.Equilateral;
		} else if (side1.compareTo(side2)==0 || side1.compareTo(side3)==0 || side2.compareTo(side3)==0) {
			return Catergory.Isosceles;
		} else {
			return Catergory.Scalene;
		}
	}
}