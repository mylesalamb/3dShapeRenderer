package shape;

import java.util.Arrays;
import java.util.List;

import shape.Shape;

/**
 * static helper class for Shape in this package
 * @author mashe
 *
 */
public final class Shapes {

	/**
	 * returns an instantiated square of type shape
	 * @return a square shape
	 */
	public static Shape getSquare() {
		Shape shape = new Shape();

		// hard coded 3d cube
		List<Point> points = Arrays.asList(new Point(200, 200, 200), new Point(300, 200, 200), new Point(300, 300, 200),
				new Point(200, 300, 200), new Point(200, 200, 300), new Point(300, 200, 300), new Point(300, 300, 300),
				new Point(200, 300, 300));

		shape.addConnection(points.get(0), points.get(1));
		shape.addConnection(points.get(0), points.get(3));
		shape.addConnection(points.get(0), points.get(4));
		shape.addConnection(points.get(0), points.get(3));
		shape.addConnection(points.get(1), points.get(2));
		shape.addConnection(points.get(1), points.get(5));
		shape.addConnection(points.get(2), points.get(3));
		shape.addConnection(points.get(2), points.get(6));
		shape.addConnection(points.get(3), points.get(7));
		shape.addConnection(points.get(4), points.get(7));
		shape.addConnection(points.get(4), points.get(5));
		shape.addConnection(points.get(5), points.get(6));
		shape.addConnection(points.get(6), points.get(7));
		
		points.forEach(shape::addPoint);

		return shape;

	}

}
