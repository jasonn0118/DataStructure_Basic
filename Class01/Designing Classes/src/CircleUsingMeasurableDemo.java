/** 
   A driver that demonstrates the class Circle.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.0
*/
public class CircleUsingMeasurableDemo {
	public static void main(String[] args) {
		CircleUsingMeasurable c1 = new CircleUsingMeasurable(5.0);
		CircleUsingMeasurable c2 = new CircleUsingMeasurable(5.0);
		CircleUsingMeasurable c3 = new CircleUsingMeasurable(9.0);

		System.out.println("c1 and c2 are equal:");
		System.out.println("c1.equals(c2): " + c1.equals(c2));
		System.out.println("c1.compareTo(c2): " + c1.compareTo(c2));
		System.out.println();

		System.out.println("c1 and c3 are not equal:");
		System.out.println("c1.equals(c3): " + c1.equals(c3));
		System.out.println("c1 < c3: ");
		System.out.println("c1.compareTo(c3): " + c1.compareTo(c3));
		System.out.println();

		System.out.print("Calling displayCircleComparisonResult(c3); result should be > 0 : ");
		displayCircleComparisonResult(c3);

		Measurable c4 = new CircleUsingMeasurable(9.0);
		System.out.println("c4, whose radius is 9, has a circumference of " + c4.getPerimeter());
		System.out.println(" and an area of " + c4.getArea());

		System.out.println("\nDone.");
	} 

	/**
	 * Takes an item that implements the Comparable interface
	 * and compares it to a circle with a specific radius.
	 * @param item
	 */
	public static void displayCircleComparisonResult(Comparable<CircleUsingMeasurable> item) {
		System.out.println(item + " compared to circle with radius 6.0: " + item.compareTo(new CircleUsingMeasurable(6.0)));
	} 
} 

/*
c1 and c2 are equal:
c1.equals(c2): true
c1.compareTo(c2): 0

c1 and c3 are not equal:
c1.equals(c3): false
c1 < c3: 
c1.compareTo(c3): -1

Calling displayCircleComparisonResult(c3); result should be > 0 : 9.0  compared to circle with radius 6.0: 1
c4, whose radius is 9, has a circumference of 56.548667764616276
 and an area of 254.46900494077323

Done.

 
*/