/**
 * A mutable class that represents a person's name. This class is a companion to
 * the class ImmutableName.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public final class MutableName {
	private String first; // First name
	private String last; // Last name

	public MutableName() {
		this("", "");
	}

	public MutableName(String firstName, String lastName) {
		first = firstName;
		last = lastName;
	}

	public MutableName(ImmutableName aName) {
		first = aName.getFirst();
		last = aName.getLast();
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

	public void giveLastNameTo(MutableName aName) {
		aName.setLast(last);
	}

	public String toString() {
		return first + " " + last;
	}

	public boolean equals(Object other) {
		boolean result;

		if ((other == null) || (getClass() != other.getClass()))
			result = false;
		else {
			MutableName otherName = (MutableName) other;
			result = first.equals(otherName.first) && last.equals(otherName.last);
		}

		return result;
	}

	public ImmutableName getImmutable() {
		return new ImmutableName(first, last);
	}
}
