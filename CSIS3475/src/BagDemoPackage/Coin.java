package BagDemoPackage;

/**
 * A class that represents a coin.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 4.0
 * 
 * @author mhrybyk
 * 
 *         Eliminated value, since it is in the CoinName enum
 */
public class Coin {
	private enum CoinSide {
		HEADS, TAILS
	}

	private CoinName myName; // set to null if illegal
	private int year; // mint year
	private CoinSide sideUp; // HEADS or TAILS

	/**
	 * Constructs an object for the coin having a given value and mint year. The
	 * visible side of the new coin is set at random.
	 * 
	 * If the coin value is not a legal CoinName value, the internal coin name is
	 * set to null.
	 * 
	 * @param coinValue value in cents for the coin
	 * @param mintYear  year made
	 */
	public Coin(int coinValue, int mintYear) {
		switch (coinValue) {
		case 1:
			myName = CoinName.PENNY;
			break;
		case 5:
			myName = CoinName.NICKEL;
			break;
		case 10:
			myName = CoinName.DIME;
			break;
		case 25:
			myName = CoinName.QUARTER;
			break;
		case 50:
			myName = CoinName.FIFTY_CENT;
			break;
		case 100:
			myName = CoinName.DOLLAR;
			break;
		default:
			myName = null; // bad coin value, set it to null
			break;
		}

		year = mintYear;
		sideUp = getToss();
	}

	/**
	 * Constructs an object for the coin having a given name and mint year. The
	 * visible side of the new coin is set at random.
	 * 
	 * @param name     type of coin
	 * @param mintYear year the coin was made
	 */
	public Coin(CoinName name, int mintYear) {
		myName = name;
		year = mintYear;
		sideUp = getToss();
	}

	/**
	 * Returns name of the coin
	 * 
	 * @return
	 */
	public CoinName getCoinName() {
		return myName;
	}

	/**
	 * Returns the value of the coin in cents
	 * 
	 * @return
	 */
	public int getValue() {
		return myName.getValue();
	}

	/** Returns the coin's mint year as an integer. */
	public int getYear() {
		return year;
	} // end getYear

	/**
	 * Returns "HEADS" or "TAILS"
	 * 
	 * @return
	 */
	public String getSideUp() {
		/*
		 * String result = "Tails"; if (sideUp == CoinSide.HEADS) result = "Heads";
		 * return result;
		 */
		return sideUp.toString();
	}

	/**
	 * Returns true if the coin is heads-side up.
	 * 
	 * @return
	 */
	public boolean isHeads() {
		return sideUp == CoinSide.HEADS;
	}

	/**
	 * Returns true if the coin is tails-side up.
	 * 
	 * @return
	 */
	public boolean isTails() {
		return sideUp == CoinSide.TAILS;
	}

	/**
	 * Tosses the coin; sideUp will be either HEADS or TAILS at random.
	 */
	public void toss() {
		sideUp = getToss();
	}

	@Override
	public String toString() {
		if (myName == null)
			return "[null coin]";
		return myName + " [" + myName.getValue() + ", " + year + ", " + sideUp + "]";
	}

	/**
	 * Returns a random value of either HEADS or TAILS.
	 * 
	 * @return
	 */
	private CoinSide getToss() {
		CoinSide result;
		if (Math.random() < 0.5)
			result = CoinSide.HEADS;
		else
			result = CoinSide.TAILS;

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Coin other = (Coin) obj;

		if (myName != other.myName)
			return false;
		// let's not worry about the side up
//		if (sideUp != other.sideUp)
//			return false;

		if (year != other.year)
			return false;
		return true;
	}
}