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
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().add(board);
	}

	public void start() {

		shape = new Shape();
		
		List<Point> points = Arrays.asList(new Point(20,20,20),new Point(30,20,20),new Point(30,30,20),new Point(20,30,20));
		
		
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
