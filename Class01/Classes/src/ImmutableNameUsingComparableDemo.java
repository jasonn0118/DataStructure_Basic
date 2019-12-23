/**
 * A driver that demonstrates the class ImmutableNameUsingComparable.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class ImmutableNameUsingComparableDemo {
	public static void main(String[] args) {
		
		ImmutableNameUsingComparable lila = new ImmutableNameUsingComparable("Lila", "Bleu");

		System.out.println(lila.getFirst() + " " + lila.getLast());
		System.out.println(lila.getName());
		System.out.println(lila);

		ImmutableNameUsingComparable lila2 = new ImmutableNameUsingComparable("Lila", "Bleu");

		if (lila.equals(lila2))
			System.out.println(lila + " is equal to a second " + lila2);
		else
			System.out.println(lila + " is not equal to a second " + lila2 + " ERROR!");

		ImmutableNameUsingComparable derek = new ImmutableNameUsingComparable("Derek", "Bleu");

		if (derek.compareTo(lila) < 0)
			System.out.println(derek + " is before " + lila);
		else
			System.out.println(derek + " is after " + lila);

		ImmutableNameUsingComparable lilaG = new ImmutableNameUsingComparable("Lila", "Greene");
		if (lilaG.compareTo(lila) < 0)
			System.out.println(lilaG + " is before " + lila);
		else
			System.out.println(lilaG + " is after " + lila);
	}

}

/*
Lila Bleu
Lila Bleu
Lila Bleu
Lila Bleu is equal to a second Lila Bleu
Derek Bleu is before Lila Bleu
Lila Greene is after Lila Bleu
*/
