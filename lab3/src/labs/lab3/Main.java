package labs.lab3;

public class Main {

	/**
	 * Accepts a string as a parameter and returns the sum of the numbers appearing
	 * in the string, ignoring all other characters. A "number" in this case is a
	 * series of 1 or more digit characters in a row.
	 * 
	 * @param str the input String
	 * 
	 * @return the sum of all the number appearing in the string
	 */
	public static int problem1_sumNumbers(String str) {
	    int returner = 0, start = 0;
    	while (start < str.length()) {
        	if (Character.isDigit(str.charAt(start))) {
            	int end = start + 1;
            	while (end < str.length() && Character.isDigit(str.charAt(end))) {
                	end++;
            	}
            	returner += Integer.parseInt(str.substring(start, end));
            	start = end;
        	} else {
            	start++;
        	}
    	}
    	return returner;
	}


	/**
	 * Given a string, return the longest substring that appears at both the
	 * beginning and end of the string without overlapping.
	 * 
	 * @param str the input string
	 * @return the longest substring that appears at both the beginning and end of
	 *         the string without overlapping.
	 */
	public static String problem2_sameEnds(String str) {
		String returner = "";
		for (int i = 0; i < str.length() / 2; i++) {
			String temp = str.substring(0, i + 1);
			if (temp.equals(str.substring(str.length() - temp.length()))) {
				returner = temp;
			}
		}
		return returner;
	}


	/**
	 * Given a string (str) and two characters (c1 and c2), count the number of
	 * words in the string ending in c1 or c2 (not case sensitive). We will say that
	 * c1 or c2 is at the end of the word if there is not an alphabetic letter
	 * immediately following it.
	 * 
	 * @param str the string in which to count the endings
	 * @param c1  count the number of words ending in this character
	 * @param c2  count the number of words ending in this character
	 * 
	 * @return the number of words ending in c1 or c2
	 */
	public static int problem3_countEndings(String str, char c1, char c2) {
		int count = 0;
		c1 = Character.toLowerCase(c1);
		c2 = Character.toLowerCase(c2);
		if (str.length() != 0){
			for (int i = 0; i < str.length(); i++) {
				if (!(Character.isAlphabetic(str.charAt(i))) && i != 0) {
					if (Character.toLowerCase(str.charAt(i - 1)) == c1 || Character.toLowerCase(str.charAt(i - 1)) == c2) {
						count++;
					}
				}
			}
			if (Character.toLowerCase(str.charAt(str.length() - 1)) == c1 || Character.toLowerCase(str.charAt(str.length() - 1)) == c2) {
				count++;
			}
		}
		return count;
	}


	/**
	 * Say that a "clump" in an array is a series of 2 or more adjacent elements of
	 * the same value. Return the number of clumps in the given int array.
	 * 
	 * @param nums the input array
	 * 
	 * @return the number of clumps in the input array
	 */
	public static int problem6_countClumps(int[] nums) {
		int count = 0;
		boolean match = false;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1] && !match) {
				count++;
				match = true;
			} else if (nums[i] != nums[i + 1]) {
				match = false;
			}
		}
		return count;
	}


	/**
	 * Given an integer n >= 0, returns an array with the pattern {1, 1, 2, 1, 2, 3,
	 * ... 1, 2, 3 .. n} (spaces added to show the grouping). Note that the length
	 * of the array will be 1 + 2 + 3 ... + n, which is known to sun to exactly n*(n
	 * + 1)/2.
	 * 
	 * @param n input integer
	 * 
	 * @return patterned array
	 */
	public static int[] problem7_arrayPattern(int n) {
		int size = n * (n + 1) / 2;
		int[] result = new int[size];
		int index = 0;
		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= row; col++) {
				result[index++] = col;
			}
		}
		return result;
	}

}