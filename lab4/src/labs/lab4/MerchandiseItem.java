package labs.lab4;

import java.util.UUID;

/**
 * Represents an abstract item in an online store
 */
public abstract class MerchandiseItem {

	/* 
	 * Note: UUID is a Java utility class that represents an immutable universally unique identifier
	 * See the Javadocs for more info
	 */
	private UUID id;
	private String name;
	private double price;

	
	/**
	 * Constructor
	 * 
	 * @param name	name of item
	 * @param price	price of item
	 */
	public MerchandiseItem(String name, double price) {
		id = UUID.randomUUID();
		this.name = name;
		this.price = price;
	}


	/**
	 * Returns the ID of the item
	 * 
	 * @return	the ID of the item
	 */
	public UUID getID() {
		return id;
	}


	/**
	 * Returns the name of the item
	 * 
	 * @return	the name of the item
	 */
	public String getName() {
		return name;
	}


	/**
	 * Sets the name of the item
	 * 
	 * @param s	new name
	 */
	public void setName(String s) {
		name = s;
	}


	/**
	 * Returns the price of the item
	 * 
	 * @return	price of the item
	 */
	public double getPrice() {
		return price;
	}


	/**
	 * Sets the price of the item
	 * 
	 * @param d	price of the item
	 */
	public void setPrice(double d) {
		price = d;
	}


	/**
	 * Causes this item to be purchased
	 * 
	 * @param purchaseDate	date of purchase, in the format YYYY-MM-DD
	 * 
	 * @return	a string containing the date you will get your item in the format YYYY-MM-DD
	 */
	public abstract String purchase(String purchaseDate);

	  // main method
	  public static void main(String[] args) {
		MerchandiseItem item1 = new StandardItem("Running socks", 34.99, 
				"A pack of 12 white running socks, fits women's size 9-11");
		MerchandiseItem item2 = new GroceryItem("Bananas", 2.00, "2021-12-28");
		MerchandiseItem item3 = new DigitalItem("Big Java: Early Objects, 7th Edition by Cay Horstmann", 
				112.50, DigitalItem.Format.EBOOK);
		MerchandiseItem item4 = new DigitalItem("Big Java: Early Objects, 7th Edition by Cay Horstmann", 
				112.50, DigitalItem.Format.EBOOK);
		MerchandiseItem item5 = new DigitalItem("Clueless starring Alicia Silverstone", 6.99, 
				DigitalItem.Format.VIDEO);
		MerchandiseItem item6 = new DigitalItem("Under Pressure by David Bowie", 0.99, 
				DigitalItem.Format.AUDIO);
		MerchandiseItem item7 = new StandardItem("AirPod Pros", 189.98, 
				"Apple AirPods Pro wireless ear buds");
		
		
		MerchandiseItem[] items = {item1, item2, item3, item4, item5, item6, item7};
		
		for (MerchandiseItem item : items) {
		   System.out.println(item);
		   System.out.println(item.purchase("2021-09-01"));
		}
		String[] stringReps = {
			", name: Running socks, price: 34.99, description: A pack of 12 white running socks, fits women's size 9-11",
			", name: Bananas, price: 2.0, expiration date: 2021-12-28",
			", name: Big Java: Early Objects, 7th Edition by Cay Horstmann, price: 112.5, format: EBOOK",
			", name: Big Java: Early Objects, 7th Edition by Cay Horstmann, price: 112.5, format: EBOOK",
			", name: Clueless starring Alicia Silverstone, price: 6.99, format: VIDEO",
			", name: Under Pressure by David Bowie, price: 0.99, format: AUDIO",
			", name: AirPod Pros, price: 189.98, description: Apple AirPods Pro wireless ear buds" 
			};

		System.out.println(items[2].toString().endsWith(stringReps[2]));
    }
}
