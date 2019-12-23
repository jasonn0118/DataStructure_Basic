package ListDriverPackage;
import ListPackage.*;

/**
 * A driver that uses a list to track the runners in a race as they cross the
 * finish line.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class RoadRaceDemo {
	public static void main(String[] args) {

		// comment out the implementation to test
		
		ListInterface<String> runnerList = new AList<>();
//		ListInterface<String> runnerList = new LList<>();
//		ListInterface<String> runnerList = new LListWithTail<>();
//		ListInterface<String> runnerList = new CompletedAList<>();
//		ListInterface<String> runnerList = new CompletedLList<>();
//		ListInterface<String> runnerList = new CompletedLListWithTail<>();
		
		// runnerList has only methods in ListInterface

		runnerList.add("16"); // Winner
		runnerList.add("4"); // Second place
		runnerList.add("33"); // Third place
		runnerList.add("27"); // Fourth place
		
		DemoUtilities.display(runnerList, "List of Runners");
		DemoUtilities.displayUsingGetEntry(runnerList, "List of Runners");
	} 
} 

/*
Display: List of Runners, size = 4
16,  4, 33, 27, 
Display using getEntry(): List of Runners, size = 4
16,  4, 33, 27, 


*/
