package labs.lab6;

/**
 * Airline seating. For Part I, complete the SeatRow class that represents a row
 * of seats. Use the following format to represent a row of seats as a string:
 * [. . . .] (first-class empty), [* * * *] (first class all full), [... ...]
 * (economy empty).
 */
public class SeatRow {

	public static final int WINDOW = 0;
	public static final int CENTER = 1;
	public static final int AISLE = 2;

	// ADD YOUR INSTANCE VARIABLES EHRE
	public boolean[] seats;
	/**
	 * Constructs a SeatingRow object.
	 * 
	 * @param numSeats the number of seats in this row;
	 */
	public SeatRow(int numSeats) {
		if(numSeats == 'E')
        {
            seats = new boolean[] {false, false, false, false};
        }
        else
        {
            seats = new boolean[] {false, false, false, false, false, false};
        }
	}


	/**
	 * Adds passenger(s)s to seat(s), based on preference.
	 * 
	 * @param numPassengers the number of passengers
	 * @param preference    where the passengers want to be seated
	 * @returns true if the passenger can be added, false otherwise
	 */
	public boolean addPassengers(int numPassengers, int preference) {
		return false; // FIX ME
	}


	/**
	 * Adds (a) passenger(s) to a seat, if possible
	 * 
	 * @param from a starting seat, inclusive
	 * @param to   an ending seat, inclusive
	 * @return true if all the seat(s) in the range can be added, false otherwise
	 */
	public boolean add(int from, int to) {
		return false; // FIX ME
	}


	/**
	 * Gets a string displaying the seating of this row
	 * 
	 * @return the seating chart
	 */
	public String toString() {
		return ""; // FIX ME
	}

}
