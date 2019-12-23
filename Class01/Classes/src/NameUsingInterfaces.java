/**
 * A mutable class that represents a person's comparable name. As given in the
 * answer to Study Question 1 in Java Interlude 5 with the addition of the
 * equals method.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class NameUsingInterfaces implements NameInterface, Comparable<NameUsingInterfaces> {
	private String first; // First name
	private String last; // Last name

	public NameUsingInterfaces() {
		this("", "");
	} 

	public NameUsingInterfaces(String firstName, String lastName) {
		first = firstName;
		last = lastName;
	} 

	public void setName(String firstName, String lastName) {
		setFirst(firstName);
		setLast(lastName);
	} 

	public String getName() {
		return toString();
	} 

	public void setFirst(String firstName) {
		first = firstName;
	} 

	public String getFirst() {
		return first;
	} 

	public void setLast(String lastName) {
		last = lastName;
	} 

	public String getLast() {
		return last;
	} 

	public void giveLastNameTo(NameInterface aName) {
		aName.setLast(last);
	} 

	public String toString() {
		return first + " " + last;
	} 

	public int compareTo(NameUsingInterfaces other) // As given in the answer to Study Question 1 in Java Interlude 5
	{
		int result = last.compareTo(other.last);

		// If last names are equal, check first names
		if (result == 0)
			result = first.compareTo(other.first);

		return result;
	} 

	public boolean equals(Object other) {
		boolean result;

		if ((other == null) || (getClass() != other.getClass()))
			result = false;
		else {
			NameUsingInterfaces otherName = (NameUsingInterfaces) other;
			result = first.equals(otherName.first) && last.equals(otherName.last);
		} 

		return result;
	} 
} 
