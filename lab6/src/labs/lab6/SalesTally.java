package labs.lab6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Reads in a sales file and calculates the total amount for each service
 * category when requested
 */
public class SalesTally {

	// ADD YOUR INSTANCE VARIABLES HERE
	String salesFileName;
	HashMap<String, Double> amountDataByCat = new HashMap<String, Double>();
	/**
	 * Constructor
	 * 
	 * @param salesFileName sales file name
	 */
	public SalesTally(String salesFileName) {
		this.salesFileName = salesFileName;
		File file = new File(salesFileName);
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] fileRowData = line.split(";");
				if (amountDataByCat.containsKey(fileRowData[1])) {
					amountDataByCat.put(fileRowData[1], amountDataByCat.get(fileRowData[1]) + Double.parseDouble(fileRowData[2]));
				} else {
					amountDataByCat.put(fileRowData[1], Double.parseDouble(fileRowData[2]));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
	}
	

	/**
	 * Returns the total amount of sales for the given category
	 * 
	 * @param category
	 * 
	 * @return total amount of sales for the given category
	 */
	public double getCategoryTotal(String category) {
		double sum = 0.0;
		if(amountDataByCat.get(category)!=null) {
			sum = amountDataByCat.get(category);
		}
		return sum;
	}

}
