package BagDemoPackage;

/**
 * Coins and their values
 * 
 * @author mhrybyk
 *
 */
public enum CoinName {
	PENNY(1), NICKEL(5), DIME(10), QUARTER(25), FIFTY_CENT(50), DOLLAR(100);
	
	private int coinValue = 0;
	
	CoinName(int value) {
		coinValue = value;
	}
	
	public int getValue( ) {
		return coinValue;
	}
}
