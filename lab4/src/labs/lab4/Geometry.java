package labs.lab4;

/**
 * A class that can calculate surface area and volume of spheres, cylinders,and
 * cones.
 */
public class Geometry {

	/**
	 * Calculates the volume of a sphere.
	 * 
	 * @param r the radius of the sphere
	 * @return the volume of the sphere
	 */
	public static double sphereVolume(double r) {
		return (4.0 / 3.0) * Math.PI * r * r * r;
	}


	/**
	 * Calculates the surface area of a sphere.
	 * 
	 * @param r the radius of the sphere
	 * @return the surface area of the sphere
	 */
	public static double sphereSurface(double r) {
		return 4.0 * Math.PI * r * r;
	}


	/**
	 * Calculates the volume of a cylinder.
	 * 
	 * @param r the radius of the cylinder
	 * @param h the height of the cylinder
	 * @return the volume of the cylinder
	 */
	public static double cylinderVolume(double r, double h) {
		return h * Math.PI * r * r;
	}


	/**
	 * Calculates the surface area of a cylinder.
	 * 
	 * @param r the radius of the sphere
	 * @return the surface area of the cylinder
	 */
	public static double cylinderSurface(double r, double h) {
		return (2.0 * r * Math.PI * h) + (2.0 * Math.PI * r * r);
	}


	/**
	 * Calculates the volume of a cone.
	 * 
	 * @param r the radius of the base of the cone
	 * @param h the height of the cone
	 * @return the volume of the cone
	 */
	public static double coneVolume(double r, double h) {
		return (1.0 / 3.0) * Math.PI * r * r * h;
	}


	/**
	 * Calculates the surface area of a cone.
	 * 
	 * @param r the radius of the base of the cone
	 * @param h the height of the cone
	 * @return the surface area of the cone
	 */
	public static double coneSurface(double r, double h) {
		return Math.PI * r * (r + Math.sqrt((h * h) + (r * r)));
	}
}
