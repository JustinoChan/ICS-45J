package labs.lab2;

/**
 * Computes the date of Easter Sunday in a given year
 */
public class Easter {
	// ADD YOUR INSTANCE VARIABLES HERE
	private int Month;
	private int Day;
	private int Year;
	/**
	 * Constructs the date of Easter Sunday.
	 */
	public Easter(int year) {
		this.Year = year;
		int a = Year % 19;
		int b = Year / 100;
		int c = Year % 100;
		int d = b / 4;
		int e = b % 4;
		int g = (8 * b + 13) / 25;
		int h = ((19 * a) + b - d - g + 15) % 30;
		int j = c / 4;
		int k = c % 4;
		int m = (a + 11 * h) / 319;
		int r = (2 * e + 2 * j - k - h + m + 32) % 7;
		int n = (h - m + r + 90) / 25;
		int p = (h - m + r + n + 19) % 32;
		this.Month = n;
		this.Day = p;
	}

	/**
	 * Gets the month of Easter Sunday
	 * 
	 * @return month of Easter Sunday
	 */
	public int getMonth() {
		return Month;
	}

	/**
	 * Gets the date of Easter Sunday
	 * 
	 * @return date of Easter Sunday
	 */
	public int getDay() {
		return Day;
	}
}
