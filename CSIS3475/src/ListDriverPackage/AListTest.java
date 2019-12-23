package ListDriverPackage;

import ListPackage.AList;
import ListPackage.DemoUtilities;
import ListPackage.ListInterface;

public class AListTest {
	public static void main(String[] args) {
		ListInterface<String> myList = new AList<>();
		
		myList.add("11");
		myList.add("22");
		myList.add("33");
		
		myList.replace(1, "44");
		DemoUtilities.display(myList, "This is my List");
		}
}
