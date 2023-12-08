package labs.lab4.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import labs.lab4.*;


public class Lab4Test {
	
	private final double EPSILON = 1e-3;

	@Test
	public void problem1() {
		LoginForm login1 = new LoginForm("user", "password");
		assertFalse(login1.isLoggedIn());
		login1.input("user");
		login1.input("password");
		login1.click("Submit");
		assertTrue(login1.isLoggedIn());
		
		LoginForm login2 = new LoginForm("admin", "admin123");
		login2.input("test");
		login2.input("test123");
		login2.click("Submit");
		assertFalse(login2.isLoggedIn());
		login2.input("admin");
		login2.input("admin123");
		login2.click("Reset");
		assertFalse(login2.isLoggedIn()); 
		login2.click("Submit");
		assertFalse(login2.isLoggedIn()); 
		login2.input("admin");
		login2.input("admin123");
		login2.input("test");
		login2.input("test123");
		login2.click("Submit");
		assertTrue(login2.isLoggedIn()); 
		login2.input("test");
		login2.input("test123");
		login2.click("Submit");
		assertTrue(login2.isLoggedIn());
	}
	
	
	@Test
	public void problem3() {
		// Test case 1:
		Student robert = new Student("Robert Navarro");
		assertEquals(1, robert.getId());
		robert.setGPA(4.0);
		assertEquals(true, robert.isHonorsStudent());
		robert.setGPA(3.2);
		assertEquals(false, robert.isHonorsStudent());
		
		// Test case 2:
		Student emily = new Student("Emily Navarro");
		assertEquals(2, emily.getId());
		
		// Test case 3:
		Student george = new Student("George Glass");
		assertEquals(3, george.getId());
		
		// Test case 4:
		Student amy = new Student("Amy Krishna");
		assertEquals(4, amy.getId());
	}
	
	 
	@Test
	public void problem5() {
		double radius = 1.0;
		double height = 2.0;

		// static methods:
		assertEquals(4.1888, Geometry.sphereVolume(radius), EPSILON);
		assertEquals(12.5663, Geometry.sphereSurface(radius), EPSILON);
		assertEquals(6.283, Geometry.cylinderVolume(radius, height), EPSILON);
		assertEquals(18.8496, Geometry.cylinderSurface(radius, height), EPSILON);
		assertEquals(2.094, Geometry.coneVolume(radius, height), EPSILON);
		assertEquals(10.166, Geometry.coneSurface(radius, height), EPSILON);

		// object-oriented approach:
		Sphere sphere = new Sphere(radius);
		Cone cone = new Cone(radius, height);
		Cylinder cylinder = new Cylinder(radius, height);

		assertEquals(4.1888, sphere.getVolume(), EPSILON);
		assertEquals(12.5663, sphere.getSurface(), EPSILON);
		assertEquals(6.283, cylinder.getVolume(), EPSILON);
		assertEquals(18.8496, cylinder.getSurface(), EPSILON);
		assertEquals(2.094, cone.getVolume(), EPSILON);
		assertEquals(10.166, cone.getSurface(), EPSILON);

		radius = 15.23;
		height = 42.099;

		// static methods:
		assertEquals(14797.499, Geometry.sphereVolume(radius), EPSILON);
		assertEquals(2914.80611, Geometry.sphereSurface(radius), EPSILON);
		assertEquals(30677.60557, Geometry.cylinderVolume(radius, height), EPSILON);
		assertEquals(5485.97897, Geometry.cylinderSurface(radius, height), EPSILON);
		assertEquals(10225.86852, Geometry.coneVolume(radius, height), EPSILON);
		assertEquals(2870.74772, Geometry.coneSurface(radius, height), EPSILON);

		// object-oriented approach:
		sphere = new Sphere(radius);
		cone = new Cone(radius, height);
		cylinder = new Cylinder(radius, height);

		assertEquals(14797.499, sphere.getVolume(), EPSILON);
		assertEquals(2914.80611, sphere.getSurface(), EPSILON);
		assertEquals(30677.60557, cylinder.getVolume(), EPSILON);
		assertEquals(5485.97897, cylinder.getSurface(), EPSILON);
		assertEquals(10225.86852, cone.getVolume(), EPSILON);
		assertEquals(2870.74772, cone.getSurface(), EPSILON);
	}

	
	@Test
	public void problem6() {
		// Test case 1
		BankAccount account = new BasicAccount(100.00);
		account.withdraw(80.00);
		assertEquals(20.0, account.getBalance(), EPSILON);
		account.withdraw(50.00);
		assertEquals(-60.0, account.getBalance(), EPSILON);
		account.withdraw(50.00);
		assertEquals(-140.0, account.getBalance(), EPSILON);
		assertTrue(BankAccount.class.isAssignableFrom(BasicAccount.class));
	}
	
	
	@Test
	public void problems7Thru10() {
		MerchandiseItem item1 = new StandardItem("Running socks", 34.99, 
				"A pack of 12 white running socks, fits women's size 9-11");
		MerchandiseItem item2 = new GroceryItem("Bananas", 2.00, "2021-12-28");
		MerchandiseItem item3 = new DigitalItem("Big Java: Early Objects, 7th Edition by Cay Horstmann", 
				112.50, DigitalItem.Format.EBOOK);
		MerchandiseItem item4 = new DigitalItem("Big Java: Early Objects, 7th Edition by Cay Horstmann", 
				112.50, DigitalItem.Format.EBOOK);
		MerchandiseItem item5 = new DigitalItem("Clueless starring Alicia Silverstone", 6.99, 
				DigitalItem.Format.VIDEO);
		MerchandiseItem item6 = new DigitalItem("Under Pressure by David Bowie", 0.99, 
				DigitalItem.Format.AUDIO);
		MerchandiseItem item7 = new StandardItem("AirPod Pros", 189.98, 
				"Apple AirPods Pro wireless ear buds");
		
		assertEquals(item1, item1);
		assertNotEquals(item3, item4);
		
		MerchandiseItem[] items = {item1, item2, item3, item4, item5, item6, item7};
		
		String[] stringReps = {
				", name: Running socks, price: 34.99, description: A pack of 12 white running socks, fits women's size 9-11",
				", name: Bananas, price: 2.0, expiration date: 2021-12-28",
				", name: Big Java: Early Objects, 7th Edition by Cay Horstmann, price: 112.5, format: EBOOK",
				", name: Big Java: Early Objects, 7th Edition by Cay Horstmann, price: 112.5, format: EBOOK",
				", name: Clueless starring Alicia Silverstone, price: 6.99, format: VIDEO",
				", name: Under Pressure by David Bowie, price: 0.99, format: AUDIO",
				", name: AirPod Pros, price: 189.98, description: Apple AirPods Pro wireless ear buds" 
				};
		
		String[] shipDatesSun = {
				"2021-09-03",
				"2021-08-30",
				"2021-08-29",
				"2021-08-29",
				"2021-08-29",
				"2021-08-29",
				"2021-09-03"
				};
		
		String[] shipDatesMon = {
				"2021-09-06",
				"2021-08-31",
				"2021-08-30",
				"2021-08-30",
				"2021-08-30",
				"2021-08-30",
				"2021-09-06"
				};
		
		String[] shipDatesTues = {
				"2021-09-07",
				"2021-09-01",
				"2021-08-31",
				"2021-08-31",
				"2021-08-31",
				"2021-08-31",
				"2021-09-07"
				};
		
		String[] shipDatesWed = {
				"2021-09-08",
				"2021-09-02",
				"2021-09-01",
				"2021-09-01",
				"2021-09-01",
				"2021-09-01",
				"2021-09-08"
				};
		
		String[] shipDatesThurs = {
				"2021-09-09",
				"2021-09-03",
				"2021-09-02",
				"2021-09-02",
				"2021-09-02",
				"2021-09-02",
				"2021-09-09"
				};
		
		String[] shipDatesFri = {
				"2021-09-10",
				"2021-09-06",
				"2021-09-03",
				"2021-09-03",
				"2021-09-03",
				"2021-09-03",
				"2021-09-10"
				};
		
		String[] shipDatesSat = {
				"2021-09-10",
				"2021-09-06",
				"2021-09-04",
				"2021-09-04",
				"2021-09-04",
				"2021-09-04",
				"2021-09-10"
				};
	
		for (int i=0; i<items.length; i++) {
			assertTrue(items[i].toString().endsWith(stringReps[i]));
			
			assertEquals(shipDatesSun[i], items[i].purchase("2021-08-29")); // Sunday
			assertEquals(shipDatesMon[i], items[i].purchase("2021-08-30")); // Monday
			assertEquals(shipDatesTues[i], items[i].purchase("2021-08-31")); // Tuesday
			assertEquals(shipDatesWed[i], items[i].purchase("2021-09-01")); // Wednesday
			assertEquals(shipDatesThurs[i], items[i].purchase("2021-09-02")); // Thursday
			assertEquals(shipDatesFri[i], items[i].purchase("2021-09-03")); // Friday
			assertEquals(shipDatesSat[i], items[i].purchase("2021-09-04")); // Saturday
		}
	}
}
