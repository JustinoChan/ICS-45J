package labs.lab6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Counts the frequencies of words in a file and generates a frequency graph
 */
public class WordFrequencyCounter {
    // ADD YOUR INSTANCE VARIABLES HERE
    private Map<String, Integer> wordFrequencies;
    private List<String> sortedWords;
    
    /**
     * Constructor
     *
     * @param fileName name of file from which to count word frequencies
     */
    public WordFrequencyCounter(String fileName) {
        wordFrequencies = new HashMap<>();
        sortedWords = new ArrayList<>();
        
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().toLowerCase();
                String[] words = line.split("[^a-zA-Z']+");

                for (String word : words) {
                    if (word.length() > 0) {
                        // Remove apostrophes and combine into a single word
                        word = word.replaceAll("'", "");
                        if (!wordFrequencies.containsKey(word)) {
                            wordFrequencies.put(word, 0);
                        }
                        wordFrequencies.put(word, wordFrequencies.get(word) + 1);
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File: " + fileName + " not found");
        }

        sortedWords.addAll(wordFrequencies.keySet());
        Collections.sort(sortedWords, (a, b) -> {
            int freqCompare = wordFrequencies.get(b).compareTo(wordFrequencies.get(a));
            if (freqCompare == 0) {
                return a.compareTo(b);
            } else {
                return freqCompare;
            }
        });
    }
    
    /**
     * Returns a word frequency graph based on the input file. Words are sorted
     * based on frequency (more frequent words appear first) and then by name
     * (lexicographically).
     *
     * Convert all words into lower case for the analysis and graph generation.
     *
     * @return a word frequency graph based on the input file
     */
    public String getFrequencyGraph() {
        StringBuilder sb = new StringBuilder();
        for (String word : sortedWords) {
            int frequency = wordFrequencies.get(word);
            sb.append(word).append(": ");
            for (int i = 0; i < frequency; i++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
