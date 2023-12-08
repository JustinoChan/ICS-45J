package labs.lab1;

/**
 * This class models a simple letter.
 */
public class Letter {
	// ADD YOUR INSTANCE VARIABLES HERE
	private String sender;
	private String recipient;
	private String start;
	private String end;
	private String message;
	/**
	 * Constructs a letter with a given sender and recipient.
	 * 
	 * @param from the sender
	 * @param to   the recipient
	 */
	public Letter(String from, String to) {
		sender = from;
		recipient = to;
		start = "Dear " + recipient + ":" + "\n" + "\n";
		end = "Sincerely," + "\n" + "\n" + sender;
		message = start;
	}

	/**
	 * Adds a line to the end of the body of this letter
	 * 
	 * @param	line	line to add
	 */
	public void addLine(String line) {
		message += line + "\n";
	}

	/**
	 * Gets the entire text of this letter
	 * 
	 * @return	the entire text of this letter
	 */
	public String getText() {
		message += "\n" + end;
		return message;
	}
}
