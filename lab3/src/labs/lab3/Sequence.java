package labs.lab3;

import java.util.ArrayList;
import java.util.*;

/**
 * Represents a sequence of integer values
 */
public class Sequence {

	private ArrayList<Integer> values;

	/**
	 * Creates a new empty Sequence
	 */
	public Sequence() {
		this.values = new ArrayList<Integer>();
	}
	/**
	 * creates a new Sequence with values from the input array
	 * 
	 * @param arr array from which to create this new Sequence
	 */
	public Sequence(int[] arr) {
		this.values = new ArrayList<Integer>();
		for (int i : arr) {
			this.values.add(i);
		}
	}
	/**
	 * Returns true if two sequences have the same values in the same order
	 * 
	 * @param other the sequence to compare to this one
	 * 
	 * @return whether the two sequences have the same values in the same order
	 */
	public boolean equals(Sequence other) {
		if (this == other) {
			return true;
		}
		if (other == null || this.values.size() != other.values.size()) {
			return false;
		}
		for (int i = 0; i < this.values.size(); i++) {
			Object a = this.values.get(i);
			Object b = other.values.get(i);
			if (a == null) {
				if (b != null) {
					return false;
				}
			} 
			else if (!a.equals(b)) {
				return false;
			}
		}
		return true;
	}
	/**
	 * Returns true if two sequences have the same values in any order, ignoring
	 * duplicates
	 * 
	 * @param other the sequence to compare to this one
	 * 
	 * @return true if the two sequences have the same values in any order, ignoring
	 *         duplicates
	 */
	public boolean sameValues(Sequence other) {
		if (other == null || this.values.size() == 0 && other.values.size() != 0) {
            return false;
        }
        for (int i = 0; i < this.values.size(); i++) {
            if (!(other.values.contains(values.get(i)))) {
                return false;
            }
        }
        return true;
    }
	/**
	 * Returns true if one sequence is a permutation of another
	 * 
	 * @param other the sequence to compare to this one
	 * 
	 * @return true if one sequence is a permutation of another
	 */
	public boolean isPermutationOf(Sequence other) {
		if (other == null || this.values.size() != other.values.size()) {
			return false;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int value : this.values) {
			map.put(value, map.getOrDefault(value, 0) + 1);
		}
		for (int value : other.values) {
			if (!map.containsKey(value) || map.get(value) <= 0) {
				return false;
			}
			map.put(value, map.get(value) - 1);
		}
		return true;
	}
	/**
	 * Returns the sum of two sequences
	 * 
	 * @param other the sequence to add to this one
	 * 
	 * @return the sum of two sequences
	 */
	public Sequence sum(Sequence other) {
        if (other == null) {
            return this;
        }
        int length = Math.max(this.values.size(), other.values.size());
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            int temp1 = 0, temp2 = 0;
            if (i < this.values.size()) {
                temp1 = values.get(i);
            }
            if (i < other.values.size()) {
                temp2 = other.values.get(i);
            }
            arr[i] = temp1 + temp2;
        }
        return new Sequence(arr);
    }
}