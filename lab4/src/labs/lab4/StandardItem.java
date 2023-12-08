package labs.lab4;
import java.time.LocalDate;
import java.time.DayOfWeek;
/**
 * Represents a non-grocery and non-digital item in the online store
 */
public class StandardItem extends MerchandiseItem { 

	// ADD YOUR INSTANCE VARIABLES HERE
	private String description;
	/**
	 * Constructor
	 * 
	 * @param name        item name
	 * @param price       item price
	 * @param description item description
	 */
	public StandardItem(String name, double price, String description) {
		super(name, price);
		// FILL IN
		this.description = description;
	}


	/**
	 * Returns item's description
	 * 
	 * @return item's description
	 */
	public String getDescription() {
		return this.description; // FIX ME
	}


	/**
	 * Sets item's description
	 * 
	 * @param s new description
	 */
	public void setDescription(String s) {
		// FILL IN
		this.description = s;
	}


	@Override
	public String purchase(String purchaseDate) {
		LocalDate result = LocalDate.parse(purchaseDate);
        int addedDays = 0;
        while (addedDays < 5) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }
        return String.valueOf(result);
    }


	@Override
	public String toString() {
		return "id: " + super.getID() + ", name: " + super.getName() + ", price: " + super.getPrice() + ", description: " + this.description;
	}


	@Override
	public boolean equals(Object otherObject) {
		if (this == otherObject) {return true;}
        if (!(otherObject instanceof StandardItem)) {return false;}
        StandardItem that = (StandardItem) otherObject;
        return this.getDescription().equals(that.getDescription());
    }
}

