package labs.lab1.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import labs.lab1.*;


public class Lab1Test {

	private final double EPSILON = 1e-3;

	@Test
	public void problem1() {
		assertEquals("llo", Main.problem1_removeFront("Hello"));
		assertEquals("va", Main.problem1_removeFront("java"));
		assertEquals("aay", Main.problem1_removeFront("away"));
		assertEquals("ay", Main.problem1_removeFront("axy"));
		assertEquals("abc", Main.problem1_removeFront("abc"));
		assertEquals("by", Main.problem1_removeFront("xby"));
		assertEquals("ab", Main.problem1_removeFront("ab"));
		assertEquals("a", Main.problem1_removeFront("ax"));
		assertEquals("ab", Main.problem1_removeFront("axb"));
		assertEquals("aa", Main.problem1_removeFront("aaa"));
		assertEquals("bc", Main.problem1_removeFront("xbc"));
		assertEquals("bb", Main.problem1_removeFront("bbb"));
		assertEquals("zz", Main.problem1_removeFront("bazz"));
		assertEquals("", Main.problem1_removeFront("ba"));
		assertEquals("abxyz", Main.problem1_removeFront("abxyz"));
		assertEquals("", Main.problem1_removeFront("hi"));
		assertEquals("s", Main.problem1_removeFront("his"));
		assertEquals("", Main.problem1_removeFront("xz"));
		assertEquals("z", Main.problem1_removeFront("zzz"));
	}
	
	
	@Test
	public void problem2() {
		assertEquals("Hi", Main.problem2_withoutR2("rHi"));
		assertEquals("Hi", Main.problem2_withoutR2("Hri"));
		assertEquals("Hi", Main.problem2_withoutR2("Hi"));
		assertEquals("Hi", Main.problem2_withoutR2("rrHi"));
		assertEquals("Hir", Main.problem2_withoutR2("Hir"));
		assertEquals("RRHi", Main.problem2_withoutR2("RRHi"));
		assertEquals("HiR", Main.problem2_withoutR2("HiR"));
		assertEquals("arb", Main.problem2_withoutR2("rarb"));
		assertEquals("", Main.problem2_withoutR2("rr"));
		assertEquals("", Main.problem2_withoutR2("r"));
		assertEquals("", Main.problem2_withoutR2(""));
		assertEquals("Hello", Main.problem2_withoutR2("Hello"));
		assertEquals("Herllo", Main.problem2_withoutR2("Herllo"));
		assertEquals("Hrllo", Main.problem2_withoutR2("rHrllo"));
	}
	
	
	@Test
	public void problem3() {
		String result1 = Main.problem3_drawNumbers(); 
		boolean correct = true;
		
		if (!(result1.startsWith("The winning numbers are "))) {
			correct = false;
		}
		
		// All numbers must be integers between 1 and 99, inclusive
		result1 = result1.replaceAll("The winning numbers are ", "");
		Scanner scanner = new Scanner(result1);
		while (scanner.hasNext()) {
			try {
				int num = scanner.nextInt();
				if (num < 1 || num > 99) {
					correct = false;
				}
			} catch (Exception e) {
				correct = false; // conversation from string to int fails
			}
		}		
		assertTrue(correct);
		scanner.close();
		
		
		String result2 = Main.problem3_drawNumbers(); 
		correct = true;
		
		if (!(result2.startsWith("The winning numbers are "))) {
			correct = false;
		}
		
		// All numbers must be integers between 1 and 99, inclusive
		result2 = result2.replaceAll("The winning numbers are ", "");
		scanner = new Scanner(result2);
		while (scanner.hasNext()) {
			try {
				int num = scanner.nextInt();
				if (num < 1 || num > 99) {
					correct = false;
				}
			} catch (Exception e) {
				correct = false; // conversation from string to int fails
			}
		}		
		assertTrue(correct);
		assertFalse(result2.equals(result1)); // should generate different numbers each time
		scanner.close();
		
		
		String result3 = Main.problem3_drawNumbers(); 
		correct = true;
		
		if (!(result3.startsWith("The winning numbers are "))) {
			correct = false;
		}
		
		// All numbers must be integers between 1 and 99, inclusive
		result3 = result3.replaceAll("The winning numbers are ", "");
		scanner = new Scanner(result3);
		while (scanner.hasNext()) {
			try {
				int num = scanner.nextInt();
				if (num < 1 || num > 99) {
					correct = false;
				}
			} catch (Exception e) {
				correct = false; // conversation from string to int fails
			}
		}		
		assertTrue(correct);
		assertFalse(result3.equals(result1)); // should generate different numbers each time
		assertFalse(result3.equals(result2)); // should generate different numbers each time
		scanner.close();
	}
	
	
	@Test
	public void problem4() {
		assertEquals("t3reboR", Main.problem4_reverseAndInsert("Robert", 3));
		assertEquals("H899", Main.problem4_reverseAndInsert("H", 899));
		assertEquals("i-45h",Main.problem4_reverseAndInsert("hi", -45));
	}
	
	
	@Test
	public void problem5() {
		assertEquals(70.711, Main.problem5_getLineDistance(new Point(100, 200)), EPSILON);
		assertEquals(0, Main.problem5_getLineDistance(new Point(150, 150)), EPSILON);
		assertEquals(141.421, Main.problem5_getLineDistance(new Point(250, 50)), EPSILON);
	}
	
	
	@Test
	public void problem6() {
		Car myHybrid = new Car(50.0);
		myHybrid.addGas(20.0);
		myHybrid.drive(100.0);
		assertEquals(18.0, myHybrid.getGasInTank(), EPSILON);
		
		Car myGasGuzzler = new Car(10.5);
		myGasGuzzler.addGas(65.9);
		myGasGuzzler.drive(125.2);
		assertEquals(53.976, myGasGuzzler.getGasInTank(), EPSILON);
		
		myGasGuzzler.drive(64.3);
		assertEquals(47.852, myGasGuzzler.getGasInTank(), EPSILON);	
	}
	
	
	@Test
	public void problem7() {	
		AntPopulation ants = new AntPopulation(10);
		ants.breed();
		ants.spray(10.0);
		assertEquals(18, ants.getAnts());
		ants.breed();
		ants.spray(5.0);
		assertEquals(34, ants.getAnts());
	}
	
	
	@Test
	public void problem8() {
		VotingMachine machine = new VotingMachine();

		machine.voteForRepublican();
		machine.voteForDemocrat();
		machine.voteForRepublican();
		machine.voteForDemocrat();
		machine.voteForRepublican();
		machine.voteForDemocrat();

		assertEquals(3, machine.getDemocratVotes());
		assertEquals(3, machine.getRepublicanVotes());

		machine.clear();
		assertEquals(0, machine.getDemocratVotes());
		assertEquals(0, machine.getRepublicanVotes());

		machine.voteForDemocrat();
		machine.voteForDemocrat();
		machine.voteForDemocrat();
		machine.voteForDemocrat();
		machine.voteForDemocrat();
		assertEquals(5, machine.getDemocratVotes());
		assertEquals(0, machine.getRepublicanVotes());

		machine.voteForRepublican();
		machine.voteForRepublican();
		machine.voteForRepublican();
		machine.voteForRepublican();
		machine.voteForRepublican();
		assertEquals(5, machine.getDemocratVotes());
		assertEquals(5, machine.getRepublicanVotes());
	}
	
	
	@Test
	public void problem9() {
		Greeter greeter1 = new Greeter("World");
		assertEquals("Hello, World", greeter1.sayHello());
		assertEquals("Goodbye, World", greeter1.sayGoodbye());

		Greeter greeter2 = new Greeter("Robert");
		assertEquals("Hello, Robert", greeter2.sayHello());
		assertEquals("Goodbye, Robert", greeter2.sayGoodbye());
		
		Greeter greeter3 = new Greeter("");
		assertEquals("Hello, ", greeter3.sayHello());
		assertEquals("Goodbye, ", greeter3.sayGoodbye());
	}
	
	
	@Test
	public void problem10() {
		Letter dearJohnLetter = new Letter("Mary", "John");
		dearJohnLetter.addLine("I am sorry we must part.");
		dearJohnLetter.addLine("I wish you all the best.");
		
		String message = dearJohnLetter.getText();
		Scanner scanner = new Scanner(message);
		List<String> letter = new ArrayList<>();
		
	    while (scanner.hasNextLine()) {
			String line = scanner.nextLine();	  
			letter.add(line);
		}			
	    scanner.close();
	    
	    assertEquals(8, letter.size());
	    
	    if(letter.size()==8){ // The size depends on the number of body lines we add to the letter. 
	    	assertEquals("DearJohn:", letter.get(0).replaceAll("\\s",""));
	    	assertEquals("Iamsorrywemustpart.", letter.get(2).replaceAll("\\s",""));
	    	assertEquals("Iwishyouallthebest.", letter.get(3).replaceAll("\\s",""));
	    	assertEquals("Mary", letter.get(7).replaceAll("\\s",""));	    	
	    }
	    /*
	     * 
	     	Dear John:

			I am sorry we must part. //body line 1
			I wish you all the best. //body line 2
			
			Sincerely,
			
			Mary
	     * 
	     * */
	
	}
}