/**
 * A class that represents a circle.
 * 
 * @author Frank M. Carrano, Timothy M. Henry
 * @version 5.0
 */
public class Circle implements Circular {
	private double radius;

	public void setRadius(double newRadius) {
		radius = newRadius;
	} 

	public double getRadius() {
		return radius;
	} 

	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	} 
	

} 
