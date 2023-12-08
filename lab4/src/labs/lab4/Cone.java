package labs.lab4;

/**
 * A class that represents a cone and can calculate its volume and surface area.
 */
public class Cone {

	// ADD YOUR INSTANCE VARIABLES HERE
	private double r;
	private double h;
	/**
	 * Creates a cone of given radius and height.
	 * 
	 * @param radius the radius
	 * @param height the height
	 */
	public Cone(double radius, double height) {
		this.r = radius;
		this.h = height;
	}


	/**
	 * Calculates the volume of the cone.
	 * 
	 * @return the volume of the cone
	 */
	public double getVolume() {
		return (1.0 / 3.0) * Math.PI * r * r * h;
	}


	/**
	 * Calculates the surface area of the cone.
	 * 
	 * @return the surface area of the cone
	 */
	public double getSurface() {
		return Math.PI * r * (r + Math.sqrt((h * h) + (r * r)));
	}

}
