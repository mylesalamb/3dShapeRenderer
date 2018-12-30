package shape;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Shape {

	public static int[] origin = new int[] { 250, 250, 250 };
	private Set<Point> points;
	private Collection<Point[]> connections;

	public Shape() {
		points = new HashSet<Point>();
		connections = new HashSet<Point[]>();
		
	}

	/**
	 * associates a given two points with a connection on the shape
	 * @param a one of the points assocaited with the connection
	 * @param b
	 */
	public void addConnection(Point a, Point b) {
		connections.add(new Point[] { a, b });

	}

	/**
	 * Associates a given point object with the shape
	 * @param point the point to be added to the shape
	 */
	public void addPoint(Point point) {

		points.add(point);

	}

	/**
	 * rotate the given shape on the x axis by degrees of arguement
	 * 
	 * @param rads the number of radians to rotate the shape by
	 */
	public void rotateX(double rads) {
		System.out.println(rads);

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
	 * @param rads the number of radians to rotate the shape by
	 */
	public void rotateY(double rads) {
		
		System.out.println("in rot y: "+rads);

		for (Point p : points) {
			double tempX = p.getX() - origin[0];
			double tempZ = p.getZ() - origin[2];
			p.setX(tempX * Math.cos(rads) + tempZ * Math.sin(rads) + origin[0]);
			p.setZ(tempZ * Math.cos(rads) - tempX * Math.sin(rads) + origin[2]);

		}

	}

	/**
	 * @param rads the number of radians to rotate the shape by
	 */
	public void rotateZ(double rads) {

		

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
