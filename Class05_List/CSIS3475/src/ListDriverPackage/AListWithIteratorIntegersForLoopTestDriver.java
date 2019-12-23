package ListDriverPackage;
import ListWithIteratorsPackage.*;

/**
 * A driver that demonstrates the for-each statement with a class, such as
 * AListWithIterator, that implements Iterable. Note that
 * AListWithIterator implements Iterable because ListWithIteratorInterface
 * extends Iterable.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class AListWithIteratorIntegersForLoopTestDriver {
	public static void main(String[] args) {
//		ListWithIteratorInterface<Integer> integerList = new CompletedAListWithIterator<>();
		ListWithIteratorInterface<Integer> integerList = new AListWithIterator<>();
		integerList.add(16);
		integerList.add(4);
		integerList.add(33);
		integerList.add(27);

		for (Integer entry : integerList)
			System.out.print(entry + " ");
		System.out.println();

//		ListWithIteratorInterface<String> nameList = new CompletedAListWithIterator<>();
		ListWithIteratorInterface<String> nameList = new AListWithIterator<>();
		nameList.add("Joe");
		nameList.add("Jess");
		nameList.add("Josh");
		nameList.add("Joy");

		for (String name : nameList)
			System.out.print(name + " ");
		System.out.println();
	} 
} 

/*
16 4 33 27 
Joe Jess Josh Joy 

*/
