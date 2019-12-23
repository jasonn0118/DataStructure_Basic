package BagDemoPackage;

/**
 * A class that demonstrates the class PiggyBank.
 * 
 * @author Frank M. Carrano, Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * Modified to use improved CoinName enum
 */
public class PiggyBankExample {
	public static void main(String[] args) {
		PiggyBank myBank = new PiggyBank();
		
		System.out.println(">>> Adding coins to the bank");

		addCoin(new Coin(1, 2010), myBank);
		addCoin(new Coin(5, 2011), myBank);
		addCoin(new Coin(10, 2000), myBank);
		addCoin(new Coin(25, 2012), myBank);
		addCoin(new Coin(25, 2012), myBank);
		addCoin(new Coin(-1, 2000), myBank);  // this is illegal, so should fail

		System.out.println("Number of quarters should be 2, is: " 
				+ myBank.getFrequency(new Coin(25, 2012)));
		System.out.println("Bank should have 5 coins, value of 66, has: " 
				+ myBank.getNumberOfCoins()
				+ " value: " + myBank.getSavings());
		
		System.out.println(">>> Removing all the coins from the bank:");
		
		int amountRemoved = 0;

		while (!myBank.isEmpty()) {
			Coin removedCoin = myBank.remove();
			System.out.println("Removed a " + removedCoin.getCoinName() + ".");
			amountRemoved = amountRemoved + removedCoin.getValue();
		} // end while

		System.out.println(">>> All done. Removed " + amountRemoved + " cents.");
	} // end main

	private static void addCoin(Coin aCoin, PiggyBank aBank) {
		if (aBank.add(aCoin))
			System.out.println("Added a " + aCoin + ".");
		else
			System.out.println("Tried to add a " + aCoin + ", but couldn't");
	} 
} 

/*
>>> Adding coins to the bank
Added a PENNY [1, 2010, TAILS].
Added a NICKEL [5, 2011, TAILS].
Added a DIME [10, 2000, TAILS].
Added a QUARTER [25, 2012, TAILS].
Added a QUARTER [25, 2012, HEADS].
Tried to add a [null coin], but couldn't
Number of quarters should be 2, is: 2
Bank should have 5 coins, value of 66, has: 5 value: 66
>>> Removing all the coins from the bank:
Removed a QUARTER.
Removed a QUARTER.
Removed a DIME.
Removed a NICKEL.
Removed a PENNY.
>>> All done. Removed 66 cents.


 */
