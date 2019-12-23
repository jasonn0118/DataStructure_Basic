/**
 * A class that represents a person's name. The class in Listing B-1 in Segment
 * B.16 of Appendix B, but modified to use an interface. NOTE the change to the
 * parameter in the method giveLastNameTo.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class Name implements NameInterface {
	private String first; // First name
	private String last; // Last name

	public Name() {
	}

	public Name(String firstName, String lastName) {
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
}
