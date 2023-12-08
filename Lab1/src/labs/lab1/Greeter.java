package labs.lab1;

/**
 * Produces customized greetings, based on your name
 *
 */
public class Greeter {

	// ADD YOUR INSTANCE VARIABLES HERE
	private String greetings;

	/**
	 * Creates a Greeter based on the provided name
	 * 
	 * @param name name of person to greet
	 */
	public Greeter(String name) {
		greetings = name;
	}


	/**
	 * Returns a greeting message ("Hello, [name]")
	 * 
	 * @return the greeting
	 */
	public String sayHello() {
		String hello = "Hello, " + greetings;
		return hello;
	}


	/**
	 * Returns a farewell message ("Goodbye, [name]")
	 * 
	 * @return the farewell message
	 */
	public String sayGoodbye() {
		String goodbye = "Goodbye, " + greetings;
		return goodbye;
	}
}
