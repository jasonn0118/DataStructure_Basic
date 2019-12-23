import java.util.*;
/** 
   A driver that demonstrates the class Name and
   the interface NameInterface.
 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class PersonDemo
{
	public static void main(String[] args) 
	{
		PersonExtendsName jamie = new PersonExtendsName("Jamie", "Jones", 22);

		PersonExtendsName jane = new PersonExtendsName();
		jane.setFirst("Jane");
		jane.setLast("Doe");

		System.out.println("Here are two names: ");
		
		System.out.println(jamie);
		System.out.println(jane);	
		
		System.out.println("Jamie Jones adopts Jill Doe and changes Jill's last name:");
		
		jamie.giveLastNameTo(jane);

		System.out.println("After name change: ");
		
		System.out.println(jamie);
		System.out.println(jane);
		
		System.out.println("\n\nLet jamie and friend be aliases. ");
		NameInterface friend = jamie;
		
		System.out.println("\nChange jamie's last name to Smith: ");
		jamie.setLast("Smith");
		System.out.println(jamie);
		System.out.println("\nHere is friend's last name: ");
		System.out.println(friend.getLast());
		
		System.out.println("Testing aliases:");
		if (jamie == friend)
			System.out.println("friend and jamie are aliases" );
		else
			System.out.println("friend and jamie are NOT aliases" );

		System.out.println("\n\nDone.");
	}  // end main
}  // end Driver

/*
 Here are two names:
 Jamie Jones
 Jane Doe
 Jamie Jones adopts Jill Doe and changes Jill's last name:
 After name change:
 Jamie Jones
 Jane Jones
 
 
 Let jamie and friend be aliases.
 
 Change jamie's last name to Smith:
 Jamie Smith
 
 Here is friend's last name:
 Smith
 Testing aliases:
 friend and jamie are aliases
 
 
 Done.


*/
