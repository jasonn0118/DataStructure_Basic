/**
 * A class that represents a college student.
 * 
 * Could really just use NameInterface throughout here instead of the class! (mwh)
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class CollegeStudent extends Student {

	private int year; // Year of graduation
	private String degree; // Degree sought

	public CollegeStudent() {
		super(); // Must be first statement in constructor
		year = 0;
		degree = "";
		// Or replace the previous three statements with
		// this(studentName, studentId, 0, ""); (see Segment C.10)
	} 

	public CollegeStudent(NameUsingInterfaces studentName, String studentId, int graduationYear, String degreeSought) {
		super(studentName, studentId); // Must be first
		year = graduationYear;
		degree = degreeSought;
	} 

	// this can be generated automatically by eclipse
	public CollegeStudent(int year, String degree) {
		super();
		this.year = year;
		this.degree = degree;
	}

	public void setStudent(NameUsingInterfaces studentName, String studentId, int graduationYear, String degreeSought) {
		setName(studentName); // NOT fullName = studentName;
		setId(studentId); // NOT id = studentId;
		// Or setStudent(studentName, studentId); (see Segment C.16)

		year = graduationYear;
		degree = degreeSought;
	} 

	/*
	 * The methods setYear, getYear, setDegree, and getDegree go here. . . .
	 */

	public String toString() {
		return super.toString() + ", " + degree + ", " + year;
	} 

	// get and set methods can be generated automatically by eclipse
	public int getYear() {
		return year;
	}

	public String getDegree() {
		return degree;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}
} 
