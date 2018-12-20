package gui;

import java.awt.Dimension;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import shape.Point;
import shape.Shape;

public class window extends JFrame {
	
	private ShapeBoard board;
	private Shape shape;

	public window() {
		
		this.board = new ShapeBoard();
		setTitle("Shape renderer");
		setSize(new Dimension(500, 500));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().add(board);
	}

	public void start() {

		shape = new Shape();
		
		//hard coded 3d cube
		List<Point> points = Arrays.asList(
				new Point(200,200,200),
				new Point(300,200,200),
				new Point(300,300,200),
				new Point(200,300,200),
				new Point(200,200,300),
				new Point(300,200,300),
				new Point(300,300,300),
				new Point(200,300,300)
				);
		
		shape.addConnection(points.get(0), points.get(1));
		shape.addConnection(points.get(0), points.get(3));
		shape.addConnection(points.get(0), points.get(4));
		shape.addConnection(points.get(0), points.get(3));
		shape.addConnection(points.get(1), points.get(2));
		shape.addConnection(points.get(1), points.get(5));
		shape.addConnection(points.get(0), points.get(3));
		shape.addConnection(points.get(2), points.get(6));
		points.forEach(shape::addPoint);
		
		board.addShape(shape);
		setVisible(true);
		board.start();
		
		

	}

	public static void main(String[] args) {

		final window app = new window();

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				app.start();

			}

		});

	}

}
