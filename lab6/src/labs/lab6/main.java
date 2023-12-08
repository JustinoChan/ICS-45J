package labs.lab6;

public class main {
    public static void main(String[] args){
		WordFrequencyCounter counter1 = new WordFrequencyCounter("res/words1.txt");
		String expected2 = "robert: ******\n" + "java: ***\n" + "fun: **\n" + "is: **\n" + "agrees: *\n" + "so: *\n"
				+ "that: *\n";
		System.out.println(expected2.equals(counter1.getFrequencyGraph()));
	}
}
