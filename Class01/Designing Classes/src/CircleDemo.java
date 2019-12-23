/** 
   A driver that demonstrates the class Circle.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class CircleDemo
{
	public static void main(String[] args) 
	{
		Circle myCircle = new Circle();
		myCircle.setRadius(5.5);
		
		System.out.println("Circle of radius " + myCircle.getRadius() +
		                   " has an area of "  + myCircle.getArea());
      System.out.println("\nDone.");
	} 
} 

/*
 Circle of radius 5.5 has an area of 95.03317777109123
 
 Done.
*/
