/**
 * A driver that demonstrates the classes Student and CollegeStudent.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class CollegeStudentDemo {
	public static void main(String[] args) {
		
		// Test Student
		System.out.println("Test Student");
		Student bob = new Student();
		
		// Student class methods can either use the NameUsingInterfaces object OR 
		// a class that implements NameInterface. Change the following to Name and it will still work!
		
		bob.setStudent(new NameUsingInterfaces("Bob", "Bean"), "555-55");
		System.out.println(bob);

		Student friend = new Student(new NameUsingInterfaces("Kris", "Smythe"), "111-22");
		System.out.println(friend);

		Student kyle = new Student();
		kyle.setName(new Name("Kyle", "Skye"));
		kyle.setId("345-01");
		System.out.println(kyle);
		System.out.println(kyle.getId() + " " + kyle.getName());
		System.out.println();

		// Test CollegeStudent
		System.out.println("Test CollegeStudent");
		CollegeStudent joe = new CollegeStudent();
		joe.setStudent(new NameUsingInterfaces("Joe", "Student"), "000-09", 2024, "B.A.");
		System.out.println(joe);
		System.out.println(joe.toString());

		CollegeStudent jill = new CollegeStudent(new NameUsingInterfaces("Jill", "Student"), "543-21", 2023, "B.S.");
		System.out.println(jill);

		CollegeStudent kristen = new CollegeStudent();
		kristen.setName(new NameUsingInterfaces("Kristen", "Student"));
		kristen.setId("678-02");
		kristen.setYear(2022);
		kristen.setDegree("M.A.");
		System.out.println(kristen);
		System.out.println(kristen.getYear() + " " + kristen.getDegree());

		System.out.println("\nDone!");
	}
}

/*
 Test Student
 555-55 Bob Bean
 111-22 Kris Smythe
 345-01 Kyle Skye
 345-01 Kyle Skye
 
 Test CollegeStudent
 000-09 Joe Student, B.A., 2024
 000-09 Joe Student, B.A., 2024
 543-21 Jill Student, B.S., 2023
 678-02 Kristen Student, M.A., 2022
 2022 M.A.
 
 Done!
*/
