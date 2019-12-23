package BagDemoPackage;

/**
 * A class of items for sale. Used by OnlineShopper
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 4.0
 */
public class Item {
	private String description;  // item description
	private int price; // item price

	/**
	 * Set description and price of the item only in the constructor
	 * @param productDescription
	 * @param productPrice
	 */
	public Item(String productDescription, int productPrice) {
		description = productDescription;
		price = productPrice;
	} 

	/**
	 * Description accessor
	 * @return description
	 */
	public String getDescription() {
		return description;
	} 

	/**
	 * Price accessor
	 * @return price
	 */
	public int getPrice() {
		return price;
	} 

	/**
	 * Format the item as a description and a price
	 */
	public String toString() {
		return description + "\t$" + price / 100 + "." + price % 100;
	} 
} 
