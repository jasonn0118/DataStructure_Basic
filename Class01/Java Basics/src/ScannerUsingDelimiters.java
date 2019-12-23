import java.util.Scanner;
public class ScannerUsingDelimiters {

	public static void main(String[] args) {
		Scanner scanner = new Scanner("Departments 1 CSIS 2 MKTG 3 FINC 4 ACCT");
		
		scanner.useDelimiter("\\s*\\d\\s*");
		
		System.out.println(scanner.next());
		System.out.println(scanner.next());
		System.out.println(scanner.next());
		System.out.println(scanner.next());
		System.out.println(scanner.next());
		
//		This will cause an exception!
//		System.out.println(scanner.next());
	}

}
