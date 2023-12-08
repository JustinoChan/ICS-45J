package labs.lab2.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import labs.lab2.*;


public class Lab2Test {
	
	private final double EPSILON = 1e-3;

	@Test
	public void problem1() {
		assertEquals("8 hours 30 minutes", Main.problem1_militaryTimeDifference(900, 1730));
		assertEquals("15 hours 30 minutes", Main.problem1_militaryTimeDifference(1730, 900));
		assertEquals("0 hours 0 minutes", Main.problem1_militaryTimeDifference(1630, 1630));
		assertEquals("1 hours 1 minutes", Main.problem1_militaryTimeDifference(630, 731));
	}
	
	
    @Test
    public void problem2() {
        assertEquals("1 6 3 8 4", Main.problem2_printDigits(16384));
        assertEquals("2 2 2 5 0", Main.problem2_printDigits(22250));
    }
    
	@Test
	public void problem3() {
		Boat boat1 = new Boat(0, 0, 0);
		boat1.move(50);
		assertEquals(50.0, boat1.getX(), EPSILON);
		assertEquals(0.0, boat1.getY(), EPSILON);
		assertEquals(0.0, boat1.getDirection(), EPSILON);

		boat1.turn(360);
		boat1.move(10);
		assertEquals(60.0, boat1.getX(), EPSILON);
		assertEquals(0.0, boat1.getY(), EPSILON);
		assertEquals(360.0, boat1.getDirection(), EPSILON);

		boat1.turn(-2);
		assertEquals(358.0, boat1.getDirection(), EPSILON);

		boat1.turn(-440);
		boat1.move(255.3);
		assertEquals(95.53089267510472, boat1.getX(), EPSILON);
		assertEquals(-252.81543794972293, boat1.getY(), EPSILON);
		assertEquals(-82.0, boat1.getDirection(), EPSILON);

		
		Boat boat2 = new Boat(0, 0, 30);
		boat2.move(50);

		assertEquals(43.301270, boat2.getX(), EPSILON);
		assertEquals(25.0, boat2.getY(), EPSILON);
		assertEquals(30.0, boat2.getDirection(), EPSILON);

		boat2.turn(30);
		boat2.move(100);
		assertEquals(93.301270, boat2.getX(), EPSILON);
		assertEquals(111.602540, boat2.getY(), EPSILON);
		assertEquals(60.0, boat2.getDirection(), EPSILON);

		boat2.turn(-60);
		boat2.move(100);
		assertEquals(193.30127018922195, boat2.getX(), EPSILON);
		assertEquals(111.60254037844386, boat2.getY(), EPSILON);
		assertEquals(0.0, boat2.getDirection(), EPSILON);
	}
	
	@Test
	public void problem4() {
		// Test case 1:
		String input = "174\n300";

		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem4_giveChange(new Scanner(System.in));
		String change = output.toString();
		assertEquals("Enter amount due in cents: " + "Enter amount received in cents: " 
				+ "Change: 1 dollars, 1 quarters, 0 dimes, 0 nickels, 1 pennies", change); 

		// Test case 2:
		input = "382998\n998778";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem4_giveChange(new Scanner(System.in));
		change = output.toString();
		assertEquals("Enter amount due in cents: " + "Enter amount received in cents: " 
				+ "Change: 6157 dollars, 3 quarters, 0 dimes, 1 nickels, 0 pennies", change); 
		
		// Test case 3:
		input = "92\n92";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem4_giveChange(new Scanner(System.in));
		change = output.toString();
		assertEquals("Enter amount due in cents: " + "Enter amount received in cents: " 
				+ "Change: 0 dollars, 0 quarters, 0 dimes, 0 nickels, 0 pennies", change); 
	}
	
	
    @Test
    public void problem5() {
        Easter easter = new Easter(2001);
        assertEquals(4, easter.getMonth());
        assertEquals(15, easter.getDay());
        
        easter = new Easter(2022);
        assertEquals(4, easter.getMonth());
        assertEquals(17, easter.getDay());
        
        easter = new Easter(2016);
        assertEquals(3, easter.getMonth());
        assertEquals(27, easter.getDay());
    }
    
     
    @Test
    public void problem6() {
		// Test case 1 (all blank):
		String input = "\n\n\n\n";

		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem6_validateInput(new Scanner(System.in));
		String result = output.toString();
		assertEquals("Enter the first name: " + "Enter the last name: " 
				+ "Enter the zip code: " + "Enter the student ID: " + 
				"First name must be filled in. Last name must be filled in. Zip code must be a 5-digit integer.  is not a valid ID.", 
				result); 
		
		
		// Test case 2 (no errors):
		input = "Robert\nNavarro\n12345\nRN-4211\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem6_validateInput(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter the first name: " + "Enter the last name: " 
				+ "Enter the zip code: " + "Enter the student ID: " + 
				"There were no errors found.", 
				result); 
		
		
		// Test case 3 (blank first name):
		input = "\nNavarro\n12345\nRN-4211\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem6_validateInput(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter the first name: " + "Enter the last name: " 
				+ "Enter the zip code: " + "Enter the student ID: " + 
				"First name must be filled in.", 
				result); 
		
		
		// Test case 4 (short last name, blank zip code and invalid ID):
		input = "Robert Sean\nN\n\n123--4OP211\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem6_validateInput(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter the first name: " + "Enter the last name: " 
				+ "Enter the zip code: " + "Enter the student ID: " + 
				"\"N\" is not a valid last name. It is too short. Zip code must be a 5-digit integer. 123--4OP211 is not a valid ID.", 
				result); 
    }
    
    
	@Test
	public void problem7() {
		TaxBill bill1 = new TaxBill(false, 65536);
		TaxBill bill2 = new TaxBill(true, 13553);
		TaxBill bill3 = new TaxBill(false, 28001.22);
		// Test case 1
		assertEquals(12784.00, bill1.getAmountDue(), EPSILON);
		// Test case 2
		assertEquals(1355.30, bill2.getAmountDue(), EPSILON);
		// Test case 3
		assertEquals(3800.183, bill3.getAmountDue(), EPSILON);
	}
	
	
	@Test
	public void problem8() {
		assertTrue(Main.problem8_nearAndFar(1, 2, 10)); 
		assertFalse(Main.problem8_nearAndFar(1, 2, 3)); 
		assertTrue(Main.problem8_nearAndFar(4, 1, 3)); 
		assertFalse(Main.problem8_nearAndFar(4, 5, 3)); 
		assertFalse(Main.problem8_nearAndFar(4, 3, 5)); 
		assertTrue(Main.problem8_nearAndFar(-1, 10, 0)); 
		assertTrue(Main.problem8_nearAndFar(0, -1, 10)); 
		assertTrue(Main.problem8_nearAndFar(10, 10, 8)); 
		assertFalse(Main.problem8_nearAndFar(10, 8, 9)); 
		assertFalse(Main.problem8_nearAndFar(8, 9, 10)); 
		assertFalse(Main.problem8_nearAndFar(8, 9, 7)); 
		assertTrue(Main.problem8_nearAndFar(8, 6, 9)); 
	}
	
	@Test
	public void problem9() {
		assertEquals(21, Main.problem9_playBlackjack(19, 21)); 
		assertEquals(21, Main.problem9_playBlackjack(21, 19));
		assertEquals(19, Main.problem9_playBlackjack(19, 22));
		assertEquals(19, Main.problem9_playBlackjack(19, 19));
		assertEquals(0, Main.problem9_playBlackjack(22, 22));
		assertEquals(1, Main.problem9_playBlackjack(1, 1));
		assertEquals(19, Main.problem9_playBlackjack(19, 1));
		assertEquals(19, Main.problem9_playBlackjack(1, 19));
		assertEquals(19, Main.problem9_playBlackjack(19, 220));
	}
	
    @Test
    public void problem10() {
        assertTrue((new Year(1980)).isLeapYear());
        assertFalse((new Year(1900)).isLeapYear());
        assertTrue((new Year(1500)).isLeapYear());
        assertFalse((new Year(1501)).isLeapYear());
	}
}
