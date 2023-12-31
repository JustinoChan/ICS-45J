package labs.lab2;

/**
 * A boat that floats in a 2D ocean
 */
public class Boat {

	// ADD YOUR INSTANCE VARIABLES HERE
	private double X;
	private double Y;
	private double Direction;
	/**
	 * Creates a boat with an initial position and direction angle.
	 * 
	 * @param x     the x coordinate of the boat's initial position.
	 * @param y     the y coordinate of the boat's initial position.
	 * @param angle angle of the boat's direction (in degrees from x axis)
	 */
	public Boat(double x, double y, double angle) {
		this.X = x;
		this.Y = y;
		this.Direction = angle;
	}


	/**
	 * Retrieves the x coordinate of the boat's current position.
	 * 
	 * @return the x coordinate of the boat's position
	 */
	public double getX() {
		return this.X;
	}


	/**
	 * Retrieves the y coordinate of the boat's current position.
	 * 
	 * @return the y coordinate of the boat's position
	 */
	public double getY() {
		return this.Y;
	}


	/**
	 * Retrieves the direction in which the boat is heading
	 * 
	 * @return the angle in which the boat is heading (in degrees)
	 */
	public double getDirection() {
		return this.Direction;
	}


	/**
	 * Turns the boat by a specified angle.
	 * 
	 * @param degrees the number of degrees of the turn (positive angles are
	 *                counter-clockwise, negative ones are clockwise)
	 */
	public void turn(double degrees) {
		if (degrees == 360 && this.Direction == 0){
			this.Direction = 360;
		}
		else{
			this.Direction = (this.Direction + degrees) % 360;
		}
	}


	/**
	 * Moves the boat a specified distance in the direction it is heading.
	 * Assume all inputs are > 0.
	 * 
	 * @param distance the distance being traveled by the boat
	 */
	public void move(double distance) {
		this.X += distance * Math.cos(Math.toRadians(this.Direction));
		this.Y += distance * Math.sin(Math.toRadians(this.Direction));
	}
}
