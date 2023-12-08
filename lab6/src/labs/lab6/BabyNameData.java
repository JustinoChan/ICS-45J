package labs.lab6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * A set of baby name data ranking the most popular baby names in the U.S. in a
 * particular year
 */
public class BabyNameData {

	// ADD YOUR INSTANCE VARIABLES HERE
	private List<BabyName> boyNames;
    private List<BabyName> girlNames;
	/**
	 * Constructor that creates this object with data from a file
	 * 
	 * @param babyNamesFileName name of input file
	 */
	public BabyNameData(String babyNamesFileName) {
		boyNames = new ArrayList<>();
        girlNames = new ArrayList<>();
        
        try (Scanner scanner = new Scanner(new File(babyNamesFileName))) {
			scanner.useDelimiter("\\s+");
		
			while (scanner.hasNext()) {
				int rank = scanner.nextInt();
				String boyName = scanner.next();
				int boyCount = scanner.nextInt();
				double boyPercent = scanner.nextDouble();
				String girlName = scanner.next();
				int girlCount = scanner.nextInt();
				double girlPercent = scanner.nextDouble();
		
				BabyName boy = new BabyName(boyName, rank, boyCount, boyPercent);
				BabyName girl = new BabyName(girlName, rank, girlCount, girlPercent);
				boyNames.add(boy);
				girlNames.add(girl);
			}
		}
		catch (FileNotFoundException e) {
			System.err.println("File: " + babyNamesFileName + " not found");
		}
	}		


	/**
	 * 
	 * @return all girl names (in a non-specific order)
	 */
	public List<String> getAllGirlNames() {
		List<String> result = new ArrayList<>();
        for (BabyName name : girlNames) {
            result.add(name.getName());
        }
        return result;
	}


	/**
	 * 
	 * @return all boy names (in a non-specific order)
	 */
	public List<String> getAllBoyNames() {
		List<String> result = new ArrayList<>();
        for (BabyName name : boyNames) {
            result.add(name.getName());
        }
        return result;
	}


	/**
	 * 
	 * @return all names that appear in the data for both boys and girls (in a
	 *         non-specific order)
	 */
	public List<String> getAllNonGenderSpecificNames() {
		return boyNames.stream()
			.map(BabyName::getName)
			.filter(name -> girlNames.stream().noneMatch(girl -> girl.getName().equalsIgnoreCase(name)))
			.collect(Collectors.toList());
	}
	


	/**
	 * 
	 * @param rank
	 * @return the girl name at the rank specified
	 * 
	 *         If rank is out of the range of data, throw an
	 *         IllegalArgumentException with the message "Rank [rank] out of range
	 *         of data"
	 */
	public String getGirlNameAtRank(int rank) throws IllegalArgumentException {
		if (rank < 1 || rank > girlNames.size()) {
            throw new IllegalArgumentException("Rank " + rank + " out of range of data");
        }
        BabyName name = girlNames.get(rank - 1);
        return name.getName();
	}


	/**
	 * 
	 * @param rank
	 * @return the boy name at the rank specified
	 * 
	 *         If rank is out of the range of data, throw an
	 *         IllegalArgumentException with the message "Rank [rank] out of range
	 *         of data"
	 */
	public String getBoyNameAtRank(int rank) {
		if (rank < 1 || rank > boyNames.size()) {
            throw new IllegalArgumentException("Rank " + rank + " out of range of data");
        }
        BabyName name = boyNames.get(rank - 1);
        return name.getName();
	}
}
