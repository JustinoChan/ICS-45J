package labs.lab4;

/**
 * Simulates a login form you would find on many web pages
 */
public class LoginForm {

	// ADD YOUR INSTANCE VARIABLES HERE
	private String userName;
	private String password;
	private String button;
	private String inputString;
	/**
	 * Constructor
	 * 
	 * @param expectedUsername the expected username
	 * @param expectedPassword the expected password
	 */
	public LoginForm(String expectedUsername, String expectedPassword) {
		this.userName = expectedUsername;
		this.password = expectedPassword;
		this.inputString = "";
	}


	/**
	 * Adds input to the form according to the following rules: Uses the input text
	 * to fill in username if username hasn't been filled in yet Uses the input text
	 * to fill in password if password hasn't been filled in yet Ignores the input
	 * text if both username and password have been filled in
	 * 
	 * @param text the input text
	 */
	public void input(String text) {
		if (this.userName == "" || this.password == "") {
			if (this.userName == ""){
				this.userName = text;
				this.inputString += text;
			}
			else if(this.password == ""){
				this.password = text;
				this.inputString += text;
			}
		}
		else if (!this.inputString.equals(this.userName + this.password)){
			this.inputString += text;
		}
	}



	/**
	 * "Clicks" the button in the form with the given name.
	 * 
	 * If button == "Submit", this submits the form; if button == "Reset", this resets the 
	 * form (the values for username and password); If button == any other value, does 
	 * nothing.
	 * 
	 * @param button name of the button to click
	 */
	public void click(String button) {
		this.button = button;
		if (this.button.equals("Submit")) {
			isLoggedIn();}
		else if (this.button.equals("Reset")){
			this.userName = "";
			this.password = "";
			this.inputString = "";
		}
	}


	/**
	 * Returns whether or not the user is logged in
	 * 
	 * @return whether or not the user is logged in
	 */
	public boolean isLoggedIn() {
		if (this.inputString == ""){
			return false;
		}
		else if (this.inputString.equals(this.userName + this.password)){
			return true;
		}
		else{
			this.inputString = "";
			return false;
		}
	}
}