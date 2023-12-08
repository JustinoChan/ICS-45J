package labs.lab2;

/**
 * This class determines if a year is a leap year or not.
 */
public class Year {
	// ADD YOUR INSTANCE VARIABLES HERE
	private int Year;
	/**
	 * Creates a Year object to test whether a particular year is a leap year.
	 * 
	 * @param aYear is the year to be tested
	 */
	public Year(int aYear) {
		this.Year = aYear;
	}

	/**
	 * Method to determine if a year is a leap year.
	 * 
	 * @return true if year is a leap year
	 */
	public boolean isLeapYear() {
		if (Year < 1582){
			return (((Year % 4 == 0) && (Year % 100 == 0)));
		}
		else{
			return (((Year % 4 == 0) && (Year % 100 != 0)) || (Year % 400 == 0));
		}
	}
}

