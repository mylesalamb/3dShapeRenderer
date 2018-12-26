package gui;

import java.awt.Dimension;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import shape.Point;
import shape.Shape;
import shape.Shapes;

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

		Shape input = Shapes.getSquare();
		board.addShape(input);
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
