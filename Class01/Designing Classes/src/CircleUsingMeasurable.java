/**
 * A class that represents a circle.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class CircleUsingMeasurable implements Comparable<CircleUsingMeasurable>, Measurable {
	private double radius;

	public CircleUsingMeasurable() {
	} 

	public CircleUsingMeasurable(double newRadius) {
		radius = newRadius;
	} 

	public void setRadius(double newRadius) {
		radius = newRadius;
	} 

	public double getRadius() {
		return radius;
	} 

	public double getCircumference() {
		return 2.0 * Math.PI * radius;
	} 

	public double getPerimeter() // Measurable interface
	{
		return getCircumference();
	} 

	public double getArea() // Measurable interface
	{
		return Math.PI * radius * radius;
	} 

	public String toString() {
		return radius + " ";
	} 

	// Comparable methods
	public int compareTo(CircleUsingMeasurable other) {
		int result;
		if (this.equals(other))
			result = 0;
		else if (radius < other.radius)
			result = -1;
		else
			result = 1;

		return result;
	} // compareTo

	public boolean equals(Object other) {
		boolean result;

		// make sure it is not null or different classes
		// note use of reflection

		if ((other == null) || (getClass() != other.getClass()))
			result = false;
		else {
			// ok to cast although we could have taken a short cut here
			CircleUsingMeasurable otherCircle = (CircleUsingMeasurable) other;
			result = (radius == otherCircle.radius);
		} 

		return result;
	} 
} 
