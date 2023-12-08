package labs.lab1;

/**
 * A simple voting machine that records votes for two parties.
 */
public class VotingMachine {

	// ADD YOUR INSTANCE VARIABLES HERE
	private int repub_count;
	private int demo_count;

	
	/**
	 * Constructs a voting machine, with vote counts set to zero.
	 */
	public VotingMachine() {
		repub_count = 0;
		demo_count = 0;
	}


	/**
	 * Clears the vote counts.
	 */
	public void clear() {
		repub_count = 0;
		demo_count = 0;
	}


	/**
	 * Records a vote for a democrat.
	 */
	public void voteForDemocrat() {
		demo_count += 1;
	}


	/**
	 * Records a vote for a republican.
	 */
	public void voteForRepublican() {
		repub_count += 1;
	}


	/**
	 * Gets the votes cast for a democrat.
	 * 
	 * @return the vote count
	 */
	public int getDemocratVotes() {
		return demo_count;
	}


	/**
	 * Gets the votes cast for a republican.
	 * 
	 * @return the vote count
	 */
	public int getRepublicanVotes() {
		return repub_count;
	}
}
