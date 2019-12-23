/**
 * A driver that demonstrates the class TextFileOperations.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class TextFileDriver {
	public static void main(String[] args) {
		String fileName = "MyTextFile";
		TextFileOperations.createTextFile(fileName, 5);
		TextFileOperations.displayFile(fileName);

		System.out.println("\nDone!");
	} 
} 

/*
 Enter 5 lines of data:
 Line 1: my line 1
 Line 2: my line 2
 Line 3: my line 3
 Line 4: my line 4
 Line 5: my line 5
 The file MyTextFile contains the following lines:
 my line 1
 my line 2
 my line 3
 my line 4
 my line 5
 
 Done!
*/
