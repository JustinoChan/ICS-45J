package labs.lab4.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import labs.lab4.*;

public class StudentTest {
	
	/**
	 * Tests that the constructor behaves as specified
	 */
	@Test
    public void testConstructor() {
		Student robert = new Student("Robert Navarro");
		assertEquals("Robert Navarro", robert.getName());
		assertEquals(1, robert.getId());
		assertEquals(0.0, robert.getGPA(), 0.0);
		assertEquals(false, robert.isHonorsStudent());
    }

	
	/**
	 * Tests the getting and setting of the name field
	 */
	@Test
    public void testName() {
		Student robert = new Student("Robert Navarro");
		assertEquals("Robert Navarro", robert.getName());
		robert.setName("Eli");
		assertEquals("Eli", robert.getName());
    }
	
	
	/**
	 * Tests the id generation/setting and getting the id
	 */
	@Test
    public void testId() {
		Student george = new Student("George Glass");
		assertEquals(1, george.getId());
		Student james = new Student("James Glass");
		assertEquals(2, james.getId());
    }
	
	
	/**
	 * Tests the getting and setting of the GPA field
	 */
	@Test
    public void testGPA() {
		Student amy = new Student("Amy Krishna");
		assertEquals(0.0, amy.getGPA(), 0.0);
		amy.setGPA(4.0);
		assertEquals(4.0, amy.getGPA(), 0.0);
    }
	
	
	/**
	 * Tests the getting and setting of the honors status
	 */
	@Test
    public void testHonors() {
		Student Dave = new Student("Dave Krishna");
		assertEquals(false, Dave.isHonorsStudent());
		Dave.setGPA(4.0);
		assertEquals(true, Dave.isHonorsStudent());
    }
}
