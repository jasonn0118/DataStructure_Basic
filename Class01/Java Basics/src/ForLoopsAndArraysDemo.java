
public class ForLoopsAndArraysDemo {

	public static void main(String[] args) {
		
		// print an array of integers and their sum
		int[] anArray = { 1, 2, 3, 4, 5 };
		int sum = 0;

		for (int integer : anArray) {
			System.out.println(integer);
			sum = sum + integer;
		}
		System.out.println("Integer Array size: " + anArray.length + " Sum: " + sum);
		
		
		// the following statements display all the strings in an array:
		String[] friends = { "Gavin", "Gail", "Jared", "Jessie" };

		System.out.println("Friends:");
		for (String name : friends)
			System.out.println(name);
		
		// shows use of anonymous object
		System.out.println("Departments:");
		for(String department : new String[] {"CSIS", "MKTG", "FINC"}) {
			System.out.println(department);
		}

	}

}
