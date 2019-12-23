package GenericsPackage;

/**
 * A class that represents a circle.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class Circle implements Comparable<Circle>, Measurable {
	private double radius;

	// needs constructor here

	public int compareTo(Circle other) {
		int result;
		if (this.equals(other))
			result = 0;
		else if (radius < other.radius)
			result = -1;
		else
			result = 1;

		return result;
	} 

	// other methods here
	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}
} 
