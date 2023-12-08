package labs.lab3;

/**
 * Holds a set of numerical data in an array and smooths the data
 */
public class ExperimentData {
	// ADD YOUR INSTANCE VARIABLES HERE
	private double[] value;
	
	/**
	 * Constructs this ExperimentData object with the given array of values. 
	 * Assume the values array will have at least 2 elements.
	 * 
	 * @param values	the array of values for this data
	 */
	public ExperimentData(double[] values) {
		this.value = values;
	}
	
	
	/**
	 * Returns the data values
	 * 
	 * @return	the data values
	 */
	public double[] getValues() {
		return this.value;
	}
	
	
	/**
	 * Smooths out an array by averaging values with its neighbors
	 */
	public void smooth() {
		int n = this.value.length;
		double curr = 0;
		for(int i = 0; i < n; i++){
			if(i == 0){
				curr = this.value[0];
				this.value[i] = (this.value[i] + this.value[i + 1]) / 2;
			}
			else if(i == n - 1){
				this.value[i] = (this.value[i] + curr) / 2;
			}
			else{
				double temp = this.value[i];
				this.value[i] = (curr + this.value[i] + this.value[i + 1]) / 3;
				curr = temp;
			}
		}
	}
}
