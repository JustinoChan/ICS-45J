package labs.lab3;

/**
 * Represents a credit card
 *
 */
public class CreditCard {
	// ADD YOUR INSTANCE VARIABLES HERE
	private long number;
	/**
	 * Constructs a credit card object with the given number
	 * 
	 * Assume the number passed in will always have 16 digits and will not
	 * start with 0. 
	 * 
	 * @param number	the credit card number
	 */
	public CreditCard(long number) {
		this.number = number;
	}

	
	/**
	 * Returns the credit card number
	 * 
	 * @return	the credit card number
	 */
	public long getNumber() {
		return this.number;
	}

	
	/**
	 * Returns a string containing the card number, with a space inserted
	 * between every 4 digits
	 * 
	 * @return	the card number, with a space inserted between every 4 digits
	 */
	public String getNumberWithSpaces() {
		String s = Long.toString(this.number);
		String number = s.substring(0,4) + " " + s.substring(4,8) + " " + s.substring(8, 12) + " " + s.substring(12);
		return number;
	}

	
	/**
	 * Returns true if the card number is valid, false otherwise
	 * 
	 * @return	whether card is valid
	 */
	public boolean isValid() {
		int l = Long.toString(this.number).length();
		int sum = 0, b = 0, count = 0;
		for (int i = 0; i < l; i++) {
		  	int p = (int) (this.number % 10);
		  	sum = sum + p;
		  	if (i % 2 != 0) {
				b = b + p;
					if (p > 4) {
			  			count++;
					}
		  	}
		  	this.number = this.number / 10;
		}
		int total = sum + b + count;
		return total % 10 == 0;
	  	}
}