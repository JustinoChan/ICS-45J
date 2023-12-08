package labs.lab4;

/**
 * A class that represents a sphere and can calculate its volume and surface
 * area.
 */
public class Sphere {

	// ADD YOUR INSTANCE VARIABLES HERE
	private double r;
	/**
	 * Creates a sphere of a given radius.
	 * 
	 * @param radius the radius
	 */
	public Sphere(double radius) {
		// FILL IN
		this.r = radius;
	}


	/**
	 * Calculates the volume of the sphere.
	 * 
	 * @return the volume of the sphere.
	 */
	public double getVolume() {
		return (4.0 / 3.0) * Math.PI * r * r * r;
	}


	/**
	 * Calculates the surface area of the sphere.
	 * 
	 * @return the volume of the sphere.
	 */
	public double getSurface() {
		return 4.0 * Math.PI * r * r;
	}
}
