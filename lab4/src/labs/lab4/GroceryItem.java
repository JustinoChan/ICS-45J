package labs.lab4;

import java.time.LocalDate;
import java.time.DayOfWeek;
/**
 * Represents a perishable, edible item with an expiration date
 */
public class GroceryItem extends MerchandiseItem { 

	// ADD YOUR INSTANCE VARIABLES HERE
	private String expirationDate;
	/**
	 * Constructor
	 * 
	 * @param name           name of item
	 * @param price          price of item
	 * @param expirationDate expiration date of item, in the format YYYY-MM-DD
	 */
	public GroceryItem(String name, double price, String expirationDate) {
		super(name, price);
		this.expirationDate = expirationDate;
	}


	/**
	 * Returns the expiration date, in the format YYYY-MM-DD
	 * 
	 * @return the expiration date, in the format YYYY-MM-DD
	 */
	public String getExpirationDate() {
		return this.expirationDate; // FIX ME
	}


	/**
	 * Sets the expiration date
	 * 
	 * @param s new expiration date, in the format YYYY-MM-DD
	 */
	public void setExpirationDate(String s) {
		// FILL IN
		this.expirationDate = s;
	}


	@Override
	public String purchase(String purchaseDate) {
		LocalDate result = LocalDate.parse(purchaseDate);
		result = result.plusDays(1);
		while (result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY) {
			result = result.plusDays(1);
		}
		return result.toString();
	}


	@Override
	public boolean equals(Object otherObject) {
		if (this == otherObject) {return true;}
        if (!(otherObject instanceof GroceryItem)) {return false;}
        GroceryItem that = (GroceryItem) otherObject;
        return this.getExpirationDate().equals(that.getExpirationDate());
	}


	@Override
	public String toString() {
		return "id: " + super.getID() + ", name: " + super.getName() + ", price: " + super.getPrice() + ", expiration date: " + this.expirationDate;
	}

}