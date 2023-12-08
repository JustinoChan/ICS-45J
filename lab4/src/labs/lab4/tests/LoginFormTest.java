package labs.lab4.tests;

import static org.junit.Assert.*;
import labs.lab4.*;

import org.junit.Test;

public class LoginFormTest {

	/**
	 * Tests that a correct username + an incorrect password does not allow the user
	 * to log in
	 */
	@Test
	public void testCorrectUsernameIncorrectPassword() {
		LoginForm login1 = new LoginForm("user", "password");
		login1.input("user");
		login1.input("pass");
		login1.click("Submit");
		assertFalse(login1.isLoggedIn());
	}


	/**
	 * Tests that an incorrect username + a correct password does not allow the user
	 * to log in
	 */
	@Test
	public void testIncorrectUsernameCorrectPassword() {
		LoginForm login1 = new LoginForm("user", "password");
		login1.input("use");
		login1.input("password");
		login1.click("Submit");
		assertFalse(login1.isLoggedIn());
	}


	/**
	 * Tests that providing correct username and password on first try allows the
	 * user to log in
	 */
	@Test
	public void testCorrectCredentialsFirstTry() {
		LoginForm login1 = new LoginForm("user", "password");
		login1.input("user");
		login1.input("password");
		login1.click("Submit");
		assertTrue(login1.isLoggedIn());
	}


	/**
	 * Tests that the following steps allow the user to log in: 1) Provide incorrect
	 * credentials, 2) Submit 3) Provide correct credentials 4) Submit
	 */
	@Test
	public void testIncorrectFirstCorrectSecond() {
		LoginForm login1 = new LoginForm("user", "password");
		login1.input("use");
		login1.input("pass");
		login1.click("Submit");
		assertFalse(login1.isLoggedIn());
		login1.input("user");
		login1.input("password");
		login1.click("Submit");
		assertTrue(login1.isLoggedIn());
	}


	/**
	 * Tests that the user stays logged in after correct credentials are submitted,
	 * even if incorrect credentials are then submitted: 1) Provide correct
	 * credentials, 2) Submit 3) Provide incorrect credentials 4) Submit
	 */
	@Test
	public void testCorrectFirstIncorrectSecond() {
		LoginForm login1 = new LoginForm("user", "password");
		login1.input("user");
		login1.input("password");
		login1.click("Submit");
		assertTrue(login1.isLoggedIn());
		login1.input("use");
		login1.input("pass");
		login1.click("Submit");
		assertTrue(login1.isLoggedIn());
	}

}
