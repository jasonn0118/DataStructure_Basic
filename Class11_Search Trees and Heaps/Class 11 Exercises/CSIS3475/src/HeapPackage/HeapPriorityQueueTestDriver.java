package HeapPackage;

/**
 * A driver that demonstrates the class HeapPriorityQueue.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class HeapPriorityQueueTestDriver {
	public static void main(String[] args) {
		testPriorityQueueOperations();
		System.out.println("\n\nDone.");
	} 

	public static void testPriorityQueueOperations() {
		// Create 9 Things with priorities 1 - 9
		PQEntry<String, Integer> one = new PQEntry<>("one", 1);
		PQEntry<String, Integer> two = new PQEntry<>("two", 2);
		PQEntry<String, Integer> three = new PQEntry<>("three", 3);
		PQEntry<String, Integer> four = new PQEntry<>("four", 4);
		PQEntry<String, Integer> five = new PQEntry<>("five", 5);
		PQEntry<String, Integer> six = new PQEntry<>("six", 6);
		PQEntry<String, Integer> seven = new PQEntry<>("seven", 7);
		PQEntry<String, Integer> eight = new PQEntry<>("eight", 8);
		PQEntry<String, Integer> nine = new PQEntry<>("nine", 9);

		// Add them to a priority queue
		System.out.println("Create a priority queue: ");
		PriorityQueueInterface<PQEntry<String, Integer>> myPQ = new CompletedHeapPriorityQueue<>();
//		PriorityQueueInterface<PQEntry<String, Integer>> myPQ = new HeapPriorityQueue<>();
		System.out.println("\n\nisEmpty() returns " + myPQ.isEmpty() + "\n");

		System.out.println("Add 9 entries in no particular order");

		myPQ.add(nine);
		myPQ.add(eight);
		myPQ.add(seven);
		myPQ.add(one);
		myPQ.add(three);
		myPQ.add(two);
		myPQ.add(four);
		myPQ.add(six);
		myPQ.add(five);

		System.out.print("\nThe priority queue should not be empty: ");
		System.out.println("\nisEmpty returns " + myPQ.isEmpty() + "\n");

		System.out.println("\nThe priority queue should have 9 entries.\n " + "size returns " + myPQ.size());

		System.out.println("\n\nTesting peek and remove:\n");
		System.out.println("Entries should appear in priority order.\n");
		while (!myPQ.isEmpty()) {
			PQEntry<String, Integer> front = myPQ.peek();
			System.out.println(front + " is at the front of the priority queue.");

			front = myPQ.remove();
			System.out.println(front + " is removed from the front of the priority queue.\n");
		} 

		System.out.print("\nThe priority queue should be empty: ");
		System.out.println("isEmpty() returns " + myPQ.isEmpty() + "\n\n");

		System.out.println("Add 4 entries:");

		myPQ.add(three);
		myPQ.add(nine);
		myPQ.add(one);
		myPQ.add(seven);

		System.out.print("\nThe priority queue should not be empty: ");
		System.out.println("\nisEmpty returns " + myPQ.isEmpty() + "\n");
		System.out.println("\nThe priority queue should have 4 entries.\n " + "size returns " + myPQ.size());

		System.out.println("\nTesting clear:\n");
		myPQ.clear();

		System.out.print("\nThe priority queue should be empty: ");
		System.out.println("isEmpty returns " + myPQ.isEmpty() + "\n\n");
		System.out.println("\nThe priority queue should have no entries.\n " + "size returns " + myPQ.size());
	} 
} 
/*
 Create a priority queue:
 
 
 isEmpty() returns true
 
 Add 9 entries in no particular order
 
 The priority queue should not be empty:
 isEmpty returns false
 
 
 The priority queue should have 9 entries.
 size returns 9
 
 
 Testing peek and remove:
 
 Entries should appear in priority order.
 
 item/priority <nine, 9> is at the front of the priority queue.
 item/priority <nine, 9> is removed from the front of the priority queue.
 
 item/priority <eight, 8> is at the front of the priority queue.
 item/priority <eight, 8> is removed from the front of the priority queue.
 
 item/priority <seven, 7> is at the front of the priority queue.
 item/priority <seven, 7> is removed from the front of the priority queue.
 
 item/priority <six, 6> is at the front of the priority queue.
 item/priority <six, 6> is removed from the front of the priority queue.
 
 item/priority <five, 5> is at the front of the priority queue.
 item/priority <five, 5> is removed from the front of the priority queue.
 
 item/priority <four, 4> is at the front of the priority queue.
 item/priority <four, 4> is removed from the front of the priority queue.
 
 item/priority <three, 3> is at the front of the priority queue.
 item/priority <three, 3> is removed from the front of the priority queue.
 
 item/priority <two, 2> is at the front of the priority queue.
 item/priority <two, 2> is removed from the front of the priority queue.
 
 item/priority <one, 1> is at the front of the priority queue.
 item/priority <one, 1> is removed from the front of the priority queue.
 
 
 The priority queue should be empty: isEmpty() returns true
 
 
 Add 4 entries:
 
 The priority queue should not be empty:
 isEmpty returns false
 
 
 The priority queue should have 4 entries.
 size returns 4
 
 Testing clear:
 
 
 The priority queue should be empty: isEmpty returns true
 
 
 
 The priority queue should have no entries.
 size returns 0
 
 
 Done.

 */
