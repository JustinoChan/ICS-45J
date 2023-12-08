package labs.lab3;
import java.util.ArrayList;
import java.util.Collections;
/**
 * This class is used to calculate the average, smallest, largest and range of
 * the values.
 */
public class DataSet {
	// ADD YOUR INSTANCE VARIABLES HERE
	private ArrayList<Double> values;
	private int count;
	/**
	 * Constructs a DataSet object to hold the number of items, the extreme values
	 * and the sum.
	 */
	public DataSet() {
		this.values = new ArrayList<Double>();
	}

	/**
	 * Adds a value to this data set.
	 * 
	 * @param x the input value
	 */
	public void add(double x) {
		this.values.add(x);
		this.count++;
	}
	
	/**
	 * Method used to calculate the sum of the data set.
	 * 
	 * @return sum the sum of the data set
	 */
	public double getSum() {
		double sum = 0;
		for(int i = 0; i < this.values.size(); i++)
    		sum += this.values.get(i);
		return sum;
	}

	/**
	 * Method used to calculate the average of the data set.
	 * 
	 * @return average the average of the data set
	 */
	public double getAverage() {
		// Because sum is a double, sum / n will not throw an
		// exception.
		double sum = 0;
		for(int i = 0; i < this.values.size(); i++)
    		sum += this.values.get(i);
		return sum / this.values.size();
	}

	/**
	 * The smallest value contained in the data set.
	 * 
	 * @return the smallest value in the data set
	 */
	public double getSmallest() {
		return Collections.min(this.values);
	}

	/**
	 * The largest value contained in the data set.
	 * 
	 * @return the largest value in the data set
	 */
	public double getLargest() {
		return Collections.max(this.values);
	}

	/**
	 * The range of values in the data set.
	 * 
	 * @return the range of values in the data set
	 */
	public double getRange() {
		return Collections.max(this.values) - Collections.min(this.values);
	}

	/**
	 * Gets the total number of input values.
	 * 
	 * @return n the total number of inputs
	 */
	public int getCount() {
		return this.count;
	}
}
