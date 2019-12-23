/**
 * An immutable class that represents a person's name and implements Comparable.
 * (The version in the book does not implement Comparable.)
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public final class ImmutableNameUsingComparable implements Comparable<ImmutableNameUsingComparable> {
	private String first; // First name
	private String last; // Last name

	public ImmutableNameUsingComparable(String firstName, String lastName) {
		first = firstName;
		last = lastName;
	}

	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}

	public String getName() {
		return toString();
	}

	public String toString() {
		return first + " " + last;
	}

	public boolean equals(Object other) {
		boolean result;

		if ((other == null) || (getClass() != other.getClass()))
			result = false;
		else {
			ImmutableNameUsingComparable otherName = (ImmutableNameUsingComparable) other;
			result = first.equals(otherName.first) && last.equals(otherName.last);
		}

		return result;
	}

	public int compareTo(ImmutableNameUsingComparable otherName) {
		int result = last.compareTo(otherName.last);

		// If last names are equal, check first
		if (result == 0)
			result = first.compareTo(otherName.first);

		return result;
	}
}
