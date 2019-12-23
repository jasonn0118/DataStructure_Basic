/**
 * J A driver that demonstrates the Comparable aspect of the class Name that
 * answers Study Question 1 in Java Interlude 5.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class NameUsingInterfacesDemo {
	public static void main(String[] args) {
		NameUsingInterfaces jane1 = new NameUsingInterfaces("Jane", "Doe");
		NameUsingInterfaces jane2 = new NameUsingInterfaces("Jane", "Doe");
		NameUsingInterfaces jane3 = new NameUsingInterfaces("Jane", "Smith");
		NameUsingInterfaces lila = new NameUsingInterfaces("Lila", "Bleu");
		NameUsingInterfaces derek = new NameUsingInterfaces("Derek", "Greene");

		System.out.println("Testing Name's compareTo method:\n");

		System.out.print("Comparing Derek Greene and Lila Bleu using the method compareTo: ");
		if (derek.compareTo(lila) < 0)
			System.out.println(derek + " is before " + lila + "<--- ERROR!");
		else if (derek.compareTo(lila) > 0)
			System.out.println(derek + " is after " + lila);
		else
			System.out.println(derek + " equals " + lila + "<--- ERROR!");

		System.out.println("Comparing Lila Bleu and Derek Greene using the method compareTo: ");
		if (lila.compareTo(derek) < 0)
			System.out.println(lila + " is before " + derek);
		else if (lila.compareTo(derek) > 0)
			System.out.println(lila + " is after " + derek + "<--- ERROR!");
		else
			System.out.println(lila + " equals " + derek + "<--- ERROR!");

		System.out.println("Comparing Lila Bleu and Lila Bleu using the method compareTo: ");
		if (lila.compareTo(lila) < 0)
			System.out.println(lila + " is before " + lila + "<--- ERROR!");
		else if (lila.compareTo(lila) > 0)
			System.out.println(lila + " is after " + lila + "<--- ERROR!");
		else
			System.out.println(lila + " equals " + lila);

		System.out.println("Comparing Lila Bleu and Jane Doe using the method compareTo: ");
		if (lila.compareTo(jane1) < 0)
			System.out.println(lila + " is before " + jane1);
		else if (lila.compareTo(jane1) > 0)
			System.out.println(lila + " is after " + jane1 + "<--- ERROR!");
		else
			System.out.println(lila + " equals " + jane1 + "<--- ERROR!");

		System.out.println("\nTesting Name's equals method:\n");

		System.out.println("Comparing Jane Doe and another Jane Doe using the method equals: " + jane1.equals(jane2));

		System.out.println("Comparing Jane Doe and Jane Smith using the method equals: " + jane1.equals(jane3));

		System.out.println("\n\nDone.");
	} 
} 

/*
 Testing Name's compareTo method:
 
 Comparing Derek Greene and Lila Bleu using the method compareTo: Derek Greene is after Lila Bleu
 Comparing Lila Bleu and Derek Greene using the method compareTo:
 Lila Bleu is before Derek Greene
 Comparing Lila Bleu and Lila Bleu using the method compareTo:
 Lila Bleu equals Lila Bleu
 Comparing Lila Bleu and Jane Doe using the method compareTo:
 Lila Bleu is before Jane Doe
 
 Testing Name's equals method:
 
 Comparing Jane Doe and another Jane Doe using the method equals: true
 Comparing Jane Doe and Jane Smith using the method equals: false
 
 
 Done.
*/
