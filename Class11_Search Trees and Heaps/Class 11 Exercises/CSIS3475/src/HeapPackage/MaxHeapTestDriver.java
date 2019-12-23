package HeapPackage;

/**
 * A driver that demonstrates the class MaxHeap.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class MaxHeapTestDriver {
	public static void main(String[] args) {
		String jared = "Jared";
		String brittany = "Brittany";
		String jazmin = "Jazmin";
		String doug = "Doug";
		String megan = "Megan";
		String tia = "Tia";
		String jada = "Jada";
		String jamal = "Jamal";
		String regis = "Regis";
		String zeke = "Zeke";

//		CompletedMaxHeapUsingSwap<String> aHeap = new CompletedMaxHeapUsingSwap<>();
//		CompletedMaxHeapUsingSwapAndAList<String> aHeap = new CompletedMaxHeapUsingSwapAndAList<>();
//		CompletedMaxHeap<String> aHeap = new CompletedMaxHeap<>();
		MaxHeap<String> aHeap = new MaxHeap<>();
		aHeap.add(jared);
		aHeap.add(brittany);
		aHeap.add(jazmin);
		aHeap.add(doug);
		aHeap.add(megan);
		aHeap.add(tia);
		aHeap.add(jada);
		aHeap.add(jamal);
		aHeap.add(regis);

		if (aHeap.isEmpty())
			System.out.println("The heap is empty - INCORRECT");
		else
			System.out.println("The heap is not empty; it contains " + aHeap.size() + " entries.");

		System.out.println("The largest entry is " + aHeap.getMax());
		
		aHeap.display();

		System.out.println("\n\nRemoving entries in descending order:");
		while (!aHeap.isEmpty())
			System.out.println("Removing " + aHeap.removeMax());

		System.out.println("\n\nTesting constructor with array parameter:\n");

		String[] nameArray = { jared, jazmin, doug, tia, megan, jada, jamal, brittany, regis, zeke };
		
//		MaxHeapInterface<String> anotherHeap = new CompletedMaxHeap<>(nameArray);
		
//		CompletedMaxHeapUsingSwap<String> anotherHeap = new CompletedMaxHeapUsingSwap<>(nameArray);
		CompletedMaxHeapUsingSwapAndAList<String> anotherHeap = new CompletedMaxHeapUsingSwapAndAList<>(nameArray);
//		CompletedMaxHeap<String> anotherHeap = new CompletedMaxHeap<>();

		if (anotherHeap.isEmpty())
			System.out.println("The heap is empty - INCORRECT");
		else
			System.out.println("The heap is not empty; it contains " + anotherHeap.size() + " entries.");

		System.out.println("The largest entry is " + anotherHeap.getMax());

		anotherHeap.display();
		System.out.println("\n\nRemoving entries in descending order:");
		while (!anotherHeap.isEmpty())
			System.out.println("Removing " + anotherHeap.removeMax());
	} 
} 

/*
The heap is not empty; it contains 9 entries.
The largest entry is Tia
 PARENT : Tia LEFT CHILD : Regis RIGHT CHILD :Megan
 PARENT : Regis LEFT CHILD : Jazmin RIGHT CHILD :Doug
 PARENT : Megan LEFT CHILD : Jared RIGHT CHILD :Jada
 PARENT : Jazmin LEFT CHILD : Brittany RIGHT CHILD :Jamal


Removing entries in descending order:
Removing Tia
Removing Regis
Removing Megan
Removing Jazmin
Removing Jared
Removing Jamal
Removing Jada
Removing Doug
Removing Brittany


Testing constructor with array parameter:

The heap is not empty; it contains 10 entries.
The largest entry is Zeke
 PARENT : Zeke LEFT CHILD : Tia RIGHT CHILD :Jamal
 PARENT : Tia LEFT CHILD : Regis RIGHT CHILD :Megan
 PARENT : Jamal LEFT CHILD : Jada RIGHT CHILD :Doug
 PARENT : Regis LEFT CHILD : Brittany RIGHT CHILD :Jared
 PARENT : Megan LEFT CHILD : Jazmin RIGHT CHILD :null


Removing entries in descending order:
Removing Zeke
Removing Tia
Removing Regis
Removing Megan
Removing Jazmin
Removing Jared
Removing Jamal
Removing Jada
Removing Doug
Removing Brittany

 */
