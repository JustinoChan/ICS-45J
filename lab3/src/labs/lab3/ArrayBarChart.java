package labs.lab3;
import java.util.*;
/**
 * Generates a bar chart representing the contents of an int array using the
 * index value of each element and asterisks
 */
public class ArrayBarChart {

	// ADD YOUR INSTANCE VARIABLES HERE
    private ArrayList<Integer> a;
    private int size;
	/**
	 * Constructor
	 * 
	 * @param arr array represented by this chart
	 */
	public ArrayBarChart(int[] arr) {
		this.size = arr.length;
		this.a = new ArrayList<>();
		int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];
		for (int j = 0; j < this.size; j++) {
			this.a.add((int)Math.round((double) (10 * arr[j])/ max));
		}
	}


	/**
	 * Prints the bar chart to the console
	 */
	public void printBarChart() {
		for(int i = 0; i < this.a.size(); i++){
			System.out.print(i + ": ");
			for(int j = 0; j < this.a.get(i) ; j++){
				System.out.print("*");
			}
			if (i != a.size() - 1){
				System.out.println("");
			}
			else{
				break;
			}
		}
	}


	/**
	 * Returns the number of asterisks to print for the given index
	 * 
	 * @param index index
	 * 
	 * @return the number of asterisks to print for the index
	 */
	public int getNumAsterisks(int index) {
		if(index >= this.a.size() || index < 0){
            return -1;
		}
        return this.a.get(index);
	}
}

