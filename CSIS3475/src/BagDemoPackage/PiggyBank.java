package BagDemoPackage;

import BagPackage.*;
/**
 * A class that implements a piggy bank by using a bag.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * Modified to use ListBag
 * Can be used with any class that implements BagInterface
 */
public class PiggyBank {
		
	private BagInterface<Coin> coins; // bag to be used to hold the coins in the bank
	private int savings;

	public PiggyBank() {
		coins = new ListBag<>();
//		coins = new CompletedLinkedBag<Coin>();
		savings = 0;
	} 

	/**
	 * Add a coin the the bank
	 * 
	 * @param coin
	 * @return true if the coin was added
	 */
	public boolean add(Coin coin) {
		if(coin == null)
			return false;
		if(coin.getCoinName() == null)
			return false;
		savings += coin.getValue();
		return coins.add(coin);
	} 

	/**
	 * Remove a coin from the bank
	 * @return coin that was removed, or null if it does not exist
	 */
	public Coin remove() {
		Coin removed = coins.remove();
		
		if(removed != null)
			savings -= removed.getValue();
		if(savings < 0)
			savings = 0;
		return removed;
	} 

	/**
	 * Test to see if the bank is empty
	 * @return true if empty
	 */
	public boolean isEmpty() {
		return coins.isEmpty();
	} 
	
	/**
	 * Get the number of coins of a certain type in the bank.
	 * 
	 * @param coin coin of a certain value and year
	 * @return number of coins found
	 */
	public int getFrequency(Coin coin) {
		return coins.getFrequencyOf(coin);
	}
	
	/**
	 * Get the number of coins in the bank
	 * @return
	 */
	public int getNumberOfCoins() {
		return coins.size();
	}
	
	/**
	 * Get the total value of the coins in the bank.
	 * @return
	 */
	public int getSavings() {
		return savings;
	}
}
