package shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Shape {

	private Set<Point> points;
	private Collection<Collection<Point>> connections;

	public Shape() {
		// TODO Auto-generated constructor stub
		points = new HashSet<Point>();
	}

	public void addConnection(Point a, Point b) throws IllegalArgumentException {

		connections.add(Arrays.asList(a,b));

	}

	public void addPoint(Point point) {
		
		if(point == null)
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
			double tempY = p.getY();
			double tempZ = p.getZ();
			p.setY(tempY * Math.cos(rads) - tempZ * Math.sin(rads));
			p.setZ(tempY * Math.sin(rads) + tempZ * Math.cos(rads));

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
			double tempX = p.getX();
			double tempZ = p.getZ();
			p.setX(tempX * Math.cos(rads) + tempZ * Math.sin(rads));
			p.setZ(tempZ * Math.cos(rads) - tempX * Math.sin(rads));

		}

	}

	/**
	 * @param degrees rotates the given shape around the z axis by the given number
	 *                of degrees
	 */
	public void rotateZ(double degrees) {

		double rads = Math.toRadians(degrees);

		for (Point p : points) {
			double tempX = p.getX();
			double tempY = p.getY();
			p.setX(tempX * Math.cos(rads) - tempY * Math.sin(rads));
			p.setY(tempX * Math.sin(rads) + tempY * Math.cos(rads));

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
	public Collection<Collection<Point>> getConnections() {
		return connections;
	}

}
