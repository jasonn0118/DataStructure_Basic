/**
 * A class that represents a student.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class Student {
//	private NameUsingInterfaces fullName;
	private NameInterface fullName;
	private String id; // Identification number

	public Student() {
//		fullName = new NameUsingInterfaces();
		fullName = new Name();
		id = "";
	}

	public Student(NameUsingInterfaces studentName, String studentId) {
		fullName = studentName;
		id = studentId;
	}
	
	public Student(NameInterface studentName, String studentId) {
		fullName = studentName;
		id = studentId;
	}

	public void setStudent(NameUsingInterfaces studentName, String studentId) {
		setName(studentName); // Or fullName = studentName;
		setId(studentId); // Or id = studentId;
	}

	public void setName(NameUsingInterfaces studentName) {
		fullName = studentName;
	}
	
	public void setStudent(NameInterface studentName, String studentId) {
		setName(studentName);
		setId(studentId);
	}
	
	public void setName(NameInterface studentName) {
		fullName = studentName;
	}

//	public NameUsingInterfaces getName() {
//		return fullName;
//	}
	
	public NameInterface getName() {
		return fullName;
	}

	public void setId(String studentId) {
		id = studentId;
	}

	public String getId() {
		return id;
	}

	public String toString() {
		return id + " " + fullName.toString();
	}
}
