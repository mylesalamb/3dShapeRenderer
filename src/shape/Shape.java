package shape;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Shape {

	public static int[] origin = new int[] { 250, 250, 250 };
	private Set<Point> points;
	private Collection<Point[]> connections;

	public Shape() {
		// TODO Auto-generated constructor stub
		points = new HashSet<Point>();
		connections = new HashSet<Point[]>();
		
	}

	public void addConnection(Point a, Point b) throws IllegalArgumentException {

		connections.add(new Point[] { a, b });

	}

	public void addPoint(Point point) {

		if (point == null)
			System.out.println("null pointer in shape");

		points.add(point);

	}

	/**
	 * rotate the given shape on the x axis by degrees of arguement
	 * 
	 * @param degrees
	 */
	public void rotateX(double degrees) {

		double rads = Math.toRadians(degrees);

		for (Point p : points) {
			double tempY = p.getY() - origin[1];
			double tempZ = p.getZ() - origin[2];
			p.setY(tempY * Math.cos(rads) - tempZ * Math.sin(rads) + origin[1]);
			p.setZ(tempY * Math.sin(rads) + tempZ * Math.cos(rads) + origin[2]);

		}

	}

	/**
	 * rotate the shape around the Y axis by param degrees
	 * 
	 * @param degrees
	 */
	public void rotateY(double degrees) {

		double rads = Math.toRadians(degrees);

		for (Point p : points) {
			double tempX = p.getX() - origin[0];
			double tempZ = p.getZ() - origin[2];
			p.setX(tempX * Math.cos(rads) + tempZ * Math.sin(rads) + origin[0]);
			p.setZ(tempZ * Math.cos(rads) - tempX * Math.sin(rads) + origin[2]);

		}

	}

	/**
	 * @param degrees rotates the given shape around the z axis by the given number
	 *                of degrees
	 */
	public void rotateZ(double degrees) {

		double rads = Math.toRadians(degrees);

		for (Point p : points) {
			double tempX = p.getX() - origin[0];
			double tempY = p.getY() - origin[1];
			p.setX(tempX * Math.cos(rads) - tempY * Math.sin(rads) + origin[0]);
			p.setY(tempX * Math.sin(rads) + tempY * Math.cos(rads) + origin[1]);

		}

	}

	/**
	 * @return the points
	 */
	public Set<Point> getPoints() {
		return points;
	}

	/**
	 * @return the connections
	 */
	public Collection<Point[]> getConnections() {
		return connections;
	}

}
