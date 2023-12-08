package labs.lab1;

import java.awt.Point;
import java.awt.geom.Line2D;
import java.util.Random;

public class Main {
	public static String problem1_removeFront(String str) {
		int len = str.length();
		String new_string = "";
		for (int i = 0; i < len; i++){
			if (i == 0 && str.charAt(i) == 'a'){
				new_string += str.charAt(i);
			}
			else if (i == 1 && str.charAt(i) == 'b'){
				new_string += str.charAt(i);
			}
			else if (i > 1){
				new_string += str.charAt(i);
			}
		}
		return new_string;
	}

	public static String problem2_withoutR2(String str) {
		int len = str.length();
		String new_string = "";
		if (len == 0){
			return str;
		}
		for (int i = 0; i < len; i++){
			if (i == 0 && str.charAt(i) == 'r'){
				continue;
			}
            else if (i == 1 && str.charAt(i) == 'r'){
				continue;
            }
			else{
				new_string += str.charAt(i);
			}
		}
		return new_string;
	}
	
	public static String problem3_drawNumbers() {
		String return_str = "The winning numbers are ";
		Random num = new Random();
		for (int i = 0; i < 6; i++){
			int value = (num.nextInt(99) + 1);
			Integer y = value;
			return_str += y.toString();
			if (i == 6){
				continue;
			}
			else{
				return_str += ' ';
			}
		}
        return return_str;
	}

	public static String problem4_reverseAndInsert(String str, int num) {
		StringBuilder new_string = new StringBuilder(str);
        new_string.reverse();
        Integer insert = num;
        new_string.insert(1, insert.toString());
        return new_string.toString();
	}
	
	public static double problem5_getLineDistance(Point p) {
        return Line2D.ptSegDist(100, 100, 200, 200, p.getX(), p.getY());
	}

    public static void main(String[] args) {
    }
}