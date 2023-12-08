package labs.lab3.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.Test;

import labs.lab3.*;

public class Lab3Test {
	
	private final double EPSILON = 1e-3;

    @Test
    public void problem1() {
        assertEquals(123, Main.problem1_sumNumbers("abc123xyz"));
        assertEquals(44, Main.problem1_sumNumbers("aa11b33"));
        assertEquals(18, Main.problem1_sumNumbers("7 11"));
        assertEquals(0, Main.problem1_sumNumbers("Robert"));
    }

    
    @Test
    public void problem2() {
        assertEquals("ab", Main.problem2_sameEnds("abXYab"));
        assertEquals("x", Main.problem2_sameEnds("xx"));
        assertEquals("x", Main.problem2_sameEnds("xxx"));
        assertEquals("", Main.problem2_sameEnds("Robert"));
        assertEquals("", Main.problem2_sameEnds("Robertr"));
        assertEquals("R", Main.problem2_sameEnds("RobertR"));
    }
    
    
	@Test
	public void problem3() {
		assertEquals(2, Main.problem3_countEndings("Robert Navarro", 't', 'o'));
		assertEquals(2, Main.problem3_countEndings("Navarro, Robert", 'T', 'o'));
		assertEquals(1, Main.problem3_countEndings("Emily Navarro", 't', 'O'));
		assertEquals(1, Main.problem3_countEndings("Robert Navarro", 't', 't'));
		assertEquals(2, Main.problem3_countEndings("Robert Sean Navarro", 'T', 'O'));
		assertEquals(2, Main.problem3_countEndings("Robert Navarrtto", 'o', 't'));
		assertEquals(1, Main.problem3_countEndings("Robert Navarro", 'n', 't'));
		assertEquals(2, Main.problem3_countEndings("Robert:Navarro", 't', 'o'));
		assertEquals(2, Main.problem3_countEndings("!!Robert--Navarro", 'T', 'O'));
		assertEquals(0, Main.problem3_countEndings("Robert Navarro", 'R', 'n'));
		assertEquals(0, Main.problem3_countEndings("Robert Navarro", 'x', '3'));
		assertEquals(3, Main.problem3_countEndings("Robert Bobert Navarro", 'o', 't'));
		assertEquals(2, Main.problem3_countEndings("a2zb", 'a', 'b'));
		assertEquals(0, Main.problem3_countEndings("bxax", 'a', 'b'));
		assertEquals(0, Main.problem3_countEndings("", 'a', 'b'));
		assertEquals(5,
				Main.problem3_countEndings("Robert Navarro is the best dog in the whole wide world!", 'e', 'd'));
	}
	
	
    @Test
    public void problem4() {
        DataSet data = new DataSet();
        data.add(40);
        data.add(12.5);
        data.add(-280.887);
        data.add(9);

        assertEquals(-219.387, data.getSum(), EPSILON);
        assertEquals(-54.84675, data.getAverage(), EPSILON);
        assertEquals(-280.887, data.getSmallest(), EPSILON);
        assertEquals(40, data.getLargest(), EPSILON);
        assertEquals(320.887, data.getRange(), EPSILON);
        assertEquals(4, data.getCount(), EPSILON);
        assertEquals(-280.887, data.getSmallest(), EPSILON);
        assertEquals(-280.887, data.getSmallest(), EPSILON);

        data.add(10);
        assertEquals(-209.387, data.getSum(), EPSILON);
        assertEquals(5, data.getCount(), EPSILON);
    }
    
    
    @Test
    public void problem5() {
        CreditCard cc1 = new CreditCard(4012888888881881L);
        assertEquals(4012888888881881L, cc1.getNumber());
        assertEquals("4012 8888 8888 1881", cc1.getNumberWithSpaces());
        assertTrue(cc1.isValid());
        
        CreditCard cc2 = new CreditCard(1234567890123456L);
        assertEquals(1234567890123456L, cc2.getNumber());
        assertEquals("1234 5678 9012 3456", cc2.getNumberWithSpaces());
        assertFalse(cc2.isValid());
    }
    
    
    @Test
    public void problem6() {
        assertEquals(2, Main.problem6_countClumps(new int[]{1, 2, 2, 3, 4, 4}));
        assertEquals(2, Main.problem6_countClumps(new int[]{1, 1, 2, 1, 1}));
        assertEquals(1, Main.problem6_countClumps(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1}));
        assertEquals(0, Main.problem6_countClumps(new int[]{}));
        assertEquals(4, Main.problem6_countClumps(new int[] {0, 13, 13, 13, 26, -7, -7, 1, 1, 1, 1, 88, 1543, 1543}));
    }
    
    
	@Test
	public void problem7() {
		assertEquals("[1, 1, 2, 1, 2, 3]", Arrays.toString(Main.problem7_arrayPattern(3)));
		assertEquals("[1, 1, 2, 1, 2, 3, 1, 2, 3, 4]", Arrays.toString(Main.problem7_arrayPattern(4)));
		assertEquals("[1, 1, 2]", Arrays.toString(Main.problem7_arrayPattern(2)));
		assertEquals("[1]", Arrays.toString(Main.problem7_arrayPattern(1)));
		assertEquals("[]", Arrays.toString(Main.problem7_arrayPattern(0)));
		assertEquals("[1, 1, 2, 1, 2, 3, 1, 2, 3, 4, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6]", 
				Arrays.toString(Main.problem7_arrayPattern(6)));
	}
	
	
    @Test
    public void problem8() {
    	// test case 1:
        ArrayBarChart chart1 = new ArrayBarChart(new int[] {8, 8, 3, 3, 1, 0, 2, 4, 12});
        assertEquals(7, chart1.getNumAsterisks(0));
        assertEquals(3, chart1.getNumAsterisks(2));
        assertEquals(0, chart1.getNumAsterisks(5));
        
        ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		chart1.printBarChart();

		String result = output.toString();
		assertEquals("0: *******" + System.lineSeparator() + "1: *******" + System.lineSeparator() + 
				"2: ***" + System.lineSeparator() + "3: ***" + System.lineSeparator() + 
				"4: *" + System.lineSeparator() + "5: " + System.lineSeparator() + 
				"6: **" + System.lineSeparator() + "7: ***" + System.lineSeparator() + 
				"8: **********", result); 
		
		// test case 2:
		ArrayBarChart chart2 = new ArrayBarChart(new int[] {88, 14, 20, 25, 43, 100});
		assertEquals(9, chart2.getNumAsterisks(0));
        assertEquals(2, chart2.getNumAsterisks(2));
        assertEquals(10, chart2.getNumAsterisks(5));
        
        output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		chart2.printBarChart();

		result = output.toString();
		assertEquals("0: *********" + System.lineSeparator() + "1: *" + System.lineSeparator() + 
				"2: **" + System.lineSeparator() + "3: ***" + System.lineSeparator() + 
				"4: ****" + System.lineSeparator() + "5: **********", result); 
    }
    
    
    @Test
    public void problem9() {
        double[] arr1 = new double[]{3.2, 4.5, 8.0, 9.34, 10.0, 0.75};
        ExperimentData data1 = new ExperimentData(arr1);

        assertSame(arr1, data1.getValues());
        assertTrue(Arrays.equals(arr1, data1.getValues()));
        data1.smooth();

        assertSame(arr1, data1.getValues());
        assertTrue(Arrays.equals(new double[]{3.85, 5.233333333333333, 7.28, 9.113333333333333, 6.696666666666666, 5.375},
                data1.getValues()));

        double[] arr2 = new double[]{3, 6.2};
        ExperimentData data2 = new ExperimentData(arr2);
        assertSame(arr2, data2.getValues());
        data2.smooth();
        assertSame(arr2, data2.getValues());
        assertTrue(Arrays.equals(new double[]{4.6, 4.6}, data2.getValues()));
    }
    
    
    @Test
	public void problem10() {
		
		// equals:
		Sequence s1 = new Sequence(new int[] { 1, 3, 5, 7, 9 });
		Sequence s2 = new Sequence(new int[] { 1, 4, 5, 8, 9 });
		Sequence s3 = new Sequence(new int[] { 1, 3, 5, 7, 9 });
		Sequence s4 = new Sequence(new int[] { 1, 4, 9 });
		Sequence s5 = new Sequence(new int[] { 9, 4, 1 });
		Sequence s6 = new Sequence(new int[] { 9, 4, 1 });
		Sequence s7 = new Sequence(new int[] { 1, 4, 9, 11 });
		Sequence empty = new Sequence();
		Sequence empty2 = new Sequence();
		
		assertFalse(s1.equals(s2)); 
		assertTrue(s1.equals(s3)); 
		assertFalse(s4.equals(s5)); 
		assertTrue(s5.equals(s6)); 
		assertTrue(s6.equals(s5)); 
		assertFalse(s4.equals(s7)); 
		assertFalse(s7.equals(empty)); 
		assertFalse(empty.equals(s7)); 
		assertTrue(empty.equals(empty2)); 

		
		// sameValues:
		Sequence s8 = new Sequence(new int[] { 1, 4, 9, 16, 9, 7, 4, 9, 11 });
		Sequence s9 = new Sequence(new int[] { 1, 4, 5, 3, 5, 7, 9, 7 });
		Sequence s10 = new Sequence(new int[] { 11, 11, 7, 9, 16, 4, 1 });
		Sequence s11 = new Sequence(new int[] {3});
		Sequence s12 = new Sequence(new int[] {3});
		Sequence s13 = new Sequence(new int[] {3, 3, 3, 3});

		assertFalse(s8.sameValues(s9)); 
		assertTrue(s8.sameValues(s10)); 
		assertTrue(s11.sameValues(s12));
		assertTrue(s11.sameValues(s13));
		assertFalse(s8.sameValues(s12));
		assertFalse(empty.sameValues(s1)); 
		assertFalse(s3.sameValues(empty)); 


		// isPermutationOf:
		Sequence s14 = new Sequence(new int[] { 11, 1, 4, 9, 16, 9, 7, 4, 9 });
		Sequence s15 = new Sequence(new int[] { 11, 11, 7, 9, 16, 4, 1, 4, 9 });

		assertTrue(s8.isPermutationOf(s14)); 
		assertFalse(s8.isPermutationOf(s15));
		assertTrue(s1.isPermutationOf(s3));
		assertTrue(s11.isPermutationOf(s12));
		assertTrue(s11.isPermutationOf(s11));
		assertFalse(s13.isPermutationOf(s12));
		assertFalse(s11.isPermutationOf(s9));
		assertFalse(empty.isPermutationOf(s1)); 
		assertFalse(s3.isPermutationOf(empty));
		assertTrue(empty.isPermutationOf(empty2));


		// sum:
		Sequence result1 = new Sequence(new int[] { 2, 7, 10, 15, 18 });
		assertTrue(s1.sum(s2).equals(result1));
		assertFalse(s1.sum(s2).equals(s1));

		Sequence result2 = new Sequence(new int[] { 2, 7, 14, 7, 9 });
		assertTrue(s1.sum(s4).equals(result2));

		Sequence result3 = new Sequence(new int[] { 10, 8, 10, 16, 9, 7, 4, 9, 11 });
		assertTrue(s5.sum(s8).equals(result3));
		
		Sequence result4 = new Sequence(new int[] { 6 });
		assertTrue(s11.sum(s12).equals(result4));
		
		Sequence result5 = new Sequence(new int[] { 6, 3, 3, 3 });
		assertTrue(s11.sum(s13).equals(result5));
		assertTrue(s13.sum(s11).equals(result5));
		
		assertTrue(empty.sum(s4).equals(s4)); 
		assertFalse(empty.sum(s4).equals(empty)); 
		assertTrue(empty.sum(s1).equals(s1)); 
		assertFalse(empty.sum(s1).equals(empty)); 
		assertTrue(empty.sum(empty2).equals(empty)); 
		assertTrue(empty.sum(empty2).equals(empty2)); 
		assertFalse(empty.sum(empty).equals(s4)); 
	}
}
