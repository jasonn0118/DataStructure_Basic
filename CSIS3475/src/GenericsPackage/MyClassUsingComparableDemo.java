package GenericsPackage;


public class MyClassUsingComparableDemo {

	public static void main(String[] args) {
		Integer[] integers = { 5, 10, 20, 88, 4, 6, 200 };
		
		String[] strings = { "zebra", "banana", "honey", "dandelion" };
		
		System.out.println("integers Minimum is " + MyClassUsingComparable.arrayMinimum(integers));
		
		System.out.println("strings Minimum is " + MyClassUsingComparable.arrayMinimum(strings));

	}

}
