package labs.lab2;

import java.util.Scanner;

public class Main {

	/**
	 * Returns a string representing the number of hours and minutes between two
	 * military times (from time1 to time2).
	 * 
	 * Assume inputs will always be valid military times.
	 * 
	 * @param time1 first time in military format
	 * @param time2 second time in military format
	 * 
	 * @return	a string representing the hours and minutes from time1 to time 2
	 */
	public static String problem1_militaryTimeDifference(int time1, int time2) {
		Integer hold, hour, min = 0;
		String Returner = "";
		if(time1 < time2){
			hold = time2 - time1;
			if(hold % 100 > 60){
				min = (hold % 100) - 40;
			}
			else{
				min = (hold % 100);
			}
			hour = hold / 100;
			Returner += hour.toString() + " hours " + min.toString() + " minutes";
		}
		else if (time1 > time2){
			if((2400 - time1 % 100)!= 0){
				hold = ((((2400 - time1) / 100) + 1) * 100) + (time1 - time2);
			} 
			else{
				hold = (((2400 - time1) / 100) * 100) + (time1 - time2);
			}
			if(hold % 100 > 60){
				min = (hold % 100) - 40;
			}
			else{
				min = (hold % 100);
			}
			hour = hold / 100;
			Returner += hour.toString() + " hours " + min.toString() + " minutes";
		}
		else if (time1 == time2){
			hour = 0;
			min = 0;
			Returner += hour.toString() + " hours " + min.toString() + " minutes";
		}
		return Returner;
	}
	
	
	/**
	 * Accepts an int as a parameter and returns a String that contains the sequence
	 * of individual digits, each separated by one space. 
	 * 
	 * Assume that the input always has exactly five digits and is not negative.
	 * 
	 * @param number	input number
	 * 
	 * @return	sequence of individual digits, each separated by one space
	 */
	public static String problem2_printDigits(int number) {
		Integer a,b,c,d,e,f = 0;
		String returner = "";
		a = number;
		b = a / 10000;
		c = a / 1000 % 10;
		d = a / 100 % 10;
		e = a / 10 % 10;
		f = a % 10;
		returner += b.toString() + " " + c.toString() + " " + d.toString() + " " + e.toString() + " " + f.toString();
		return returner;
	}
	
	
	/**
	 * A method that directs a cashier how to give change. Asks user for amount due and
	 * amount received from the customer, and prints the dollars, quarters, dimes, nickels,
	 * and pennies that the customer should receive in return.
	 * 
	 * Assume every input is a non-negative integer and amount due is always <= amount
	 * received.
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem4_giveChange(new Scanner(System.in));
	 */
	public static void problem4_giveChange(Scanner in) {
		Integer change, dollars, quarters, dimes, nickels, pennies = 0;
		String returner = "";
		System.out.print("Enter amount due in cents: ");
		Integer due = in.nextInt();
		System.out.print("Enter amount received in cents: ");
		Integer paid = in.nextInt();
		change = paid - due;
		if (change >= 0){
			dollars = change / 100;
			change = change % 100;
			quarters = change / 25;
			change = change % 25;
			dimes = change / 10;
			change = change % 10;
			nickels = change / 5;
			pennies = change % 5;
			returner = String.format("Change: %d dollars, %d quarters, %d dimes, %d nickels, %d pennies", dollars, quarters, dimes, nickels, pennies);
			System.out.print(returner);
		}
	}
	
	
	/**
	 * A method that prompts for a first name, last name, zip code, and student ID. Ensure
	 * that the input is valid according to these rules:
	 * 
	 * 1. The first name must be filled in. If not, generate the message "First name must be filled in."
	 * 2. The last name must be filled in. If not, generate the message "Last name must be filled in."
	 * 3. The first and last names must be at least two characters long. If either one is only one character
	 * long, generate the message ""[FIRST_NAME/LAST_NAME]" is not a valid first/last name. It is too short."
	 * 4. The zip code must be a 5-digit string in which each digit is an integer. If not, generate the 
	 * message "Zip code must be a 5-digit integer."
	 * 5. A student ID must be in the format AA-1234. So, two uppercase letters, a hyphen, and four digits. 
	 * If not, generate the message "[ID] is not a valid ID."
	 * 
	 * After the user is done entering all the input, print the validation result (all the messages appended
	 * together with a single space between each one) to the screen using System.out.print. If there are no
	 * errors, print "There were no errors found."
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem6_validateInput(new Scanner(System.in));
	 */
	public static void problem6_validateInput(Scanner in) {
		Integer zip = 0;
		String returner = "";
		System.out.print("Enter the first name: ");
		String fname = in.nextLine();
		System.out.print("Enter the last name: ");
		String lname = in.nextLine();
		System.out.print("Enter the zip code: ");
		try{
			zip = Integer.parseInt(in.nextLine());
		}
		catch(Exception e){
			zip = 0;
		}
		System.out.print("Enter the student ID: ");
		String sid = in.nextLine();
		if (fname.length() < 2){
			if (returner.length() == 0 && fname.length() == 0){
				returner += "First name must be filled in.";
			}
			else if (fname.length() != 0 && returner.length() == 0){
				returner += String.format("\"%s\" is not a valid frist name. It is too short.", fname);
			}
		}
		if (lname.length() < 2){
			if (returner.length() == 0 && lname.length() == 0){
				returner += "Last name must be filled in.";
			}
			else if (returner.length() != 0 && lname.length() == 0){
				returner += " Last name must be filled in.";
			}
			else if (returner.length() == 0){
				returner += String.format("\"%s\" is not a valid last name. It is too short.", lname);
			}
			else{
				returner += String.format(" \"%s\" is not a valid last name. It is too short.", lname);
			}
		}
		if (zip < 10000){
			returner += " Zip code must be a 5-digit integer.";
		}
		if (sid.length() != 7 || !(Character.isLetter(sid.charAt(0))) || !(Character.isLetter(sid.charAt(1))) || sid.charAt(2) != '-' || !(Character.isDigit(sid.charAt(3))) || 
			!(Character.isDigit(sid.charAt(4))) || !(Character.isDigit(sid.charAt(5))) || !(Character.isDigit(sid.charAt(6)))){
				if (returner.length() == 0){
					returner += String.format("%s is not a valid ID.", sid);
				}
				else{
					returner += String.format(" %s is not a valid ID.", sid);
				}
		}
		if(returner.length() == 0){
			returner += "There were no errors found.";
		}
		System.out.print(returner);
	}
	
	
	/**
	 * 
	 * @param a first number
	 * @param b second number
	 * @param c third number
	 * @return true if one of b or c is "close" (differing from a by at most 1),
	 *         while the other is "far", differing from both other values by 2 or
	 *         more.
	 */
	public static boolean problem8_nearAndFar(int a, int b, int c) {
		if (Math.abs(a - b) <= 1 && Math.abs(a - c) >= 2 && Math.abs(b - c) >= 2){
			return true;
		} 
		else if (Math.abs(a - c) <= 1 && Math.abs(a - b) >= 2 && Math.abs(b - c) >= 2){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	/**
	 * Given 2 integer values greater than 0, return whichever value is nearest to
	 * 21 without going over. If they both go over, return 0.
	 * 
	 * @param a the first value
	 * @param b the second value
	 * 
	 * @return whichever value is nearest to 21 without going over; if they both go
	 *         over, return 0
	 */
	public static int problem9_playBlackjack(int a, int b) {
		if(a > 21 && b > 21){
        	return 0;
		}
		if(a > 21){
			return b;	
		}	
		if(b > 21){
			return a;
		}			
		return a > b ? a : b;
	}
}
