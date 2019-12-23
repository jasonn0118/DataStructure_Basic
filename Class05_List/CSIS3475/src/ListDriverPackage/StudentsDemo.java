package ListDriverPackage;
import ListPackage.*;

/**
 * Makes an alphabetical list of names as students enter a room.
 * 
 * @author Frank M. Carrano, Timothy M. Henry
 * @version 5.0
 */
public class StudentsDemo {
	public static void main(String[] args) {
		
		// comment out the implementation to test
		
		ListInterface<String> alphaList = new AList<>();
//		ListInterface<String> alphaList = new LList<>();
//		ListInterface<String> alphaList = new LListWithTail<>();
//		ListInterface<String> alphaList = new CompletedAList<>();
//		ListInterface<String> alphaList = new CompletedLList<>();
//		ListInterface<String> alphaList = new CompletedLListWithTail<>();


		alphaList.add(0, "Amy"); // Amy
		alphaList.add(1, "Elias"); // Amy Elias
		alphaList.add(1, "Bob"); // Amy Bob Elias
		alphaList.add(2, "Drew"); // Amy Bob Drew Elias
		alphaList.add(0, "Aaron"); // Aaron Amy Bob Drew Elias
		alphaList.add(3, "Carol"); // Aaron Amy Bob Carol Drew Elias
		
		DemoUtilities.display(alphaList, "List of Students");
		DemoUtilities.displayUsingGetEntry(alphaList, "List of Students");
	} 
} 
/*
Display: List of Students, size = 6
Aaron, Amy, Bob, Carol, Drew, Elias, 
Display using getEntry(): List of Students, size = 6
Aaron, Amy, Bob, Carol, Drew, Elias, 

*/
