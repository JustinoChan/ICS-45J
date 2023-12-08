package labs.lab4;

/**
 * A class that represents a cylinder and can calculate its volume and surface
 * area.
 */
public class Cylinder {

	// ADD YOUR INSTANCE VARIABLES HERE
	private double r;
	private double h;
	/**
	 * Creates a new cylinder of given height and radius.
	 * 
	 * @param radius the radius
	 * @param height the height
	 */
	public Cylinder(double radius, double height) {
		// FILL IN
		this.r = radius;
		this.h = height;
	}


	/**
	 * Calculates the volume of a cylinder.
	 * 
	 * @return the volume of the cylinder
	 */
	public double getVolume() {
		return h * Math.PI * r * r;
	}


	/**
	 * Calculates the surface area of the cylinder.
	 * 
	 * @return the surface area of the cylinder
	 */
	public double getSurface() {
		return (2.0 * r * Math.PI * h) + (2.0 * Math.PI * r * r);
	}

}
