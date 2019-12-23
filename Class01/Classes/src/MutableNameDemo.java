/** 
   A driver that demonstrates the companion classes MutableName and ImmutableName.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class MutableNameDemo
{
	public static void main(String[] args) 
	{
		// Create an object of the class MutableName.
		MutableName derek = new MutableName("Derek", "Greene");
		System.out.println(derek + " is a mutable object.");

		// Change derek's last name
		derek.setLast("Black");
		System.out.println("After changing Derek's last name to Black: " + derek);

		// Convert derek to an immutable object without changing its data fields.
		ImmutableName staticDerek = derek.getImmutable();
//		staticDerek.setLast("WRONG"); // Illegal

		// Create an object of the class ImmutableName.
		ImmutableName lila = new ImmutableName("Lila", "Bleu");
		System.out.println(lila + " is an immutable object.");
//		lila.setLast("WRONG"); // Illegal

		// Convert lila to a mutable object without changing its data fields
		MutableName changableLila = lila.getMutable();
		System.out.println(changableLila + " is now a mutable object.");

		// Change changableLila's last name
		changableLila.setLast("White");
		System.out.println("After changing Lila's last name to White: " + changableLila);
	}
} 

/*
 Derek Greene is a mutable object.
 After changing Derek's last name to Black: Derek Black
 Lila Bleu is an immutable object.
 Lila Bleu is now a mutable object.
 After changing Lila's last name to White: Lila White
*/
