package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import shape.Point;
import shape.Shape;

public class ShapeBoard extends JPanel {

	public static final int FRAME_CAP = 60;
	private List<Shape> shapes;

	public ShapeBoard() {
		this.setBackground(Color.black);
		this.setIgnoreRepaint(true);
		shapes = new ArrayList<>();
	}

	public void start() {

		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			renderLoop();
			
			shapes.get(0).rotateZ(10);
		}

	}
	
	/**
	 * active rendering loop so we cna control
	 * when paint events are called
	 */
	public void renderLoop() {

		Graphics pen = this.getGraphics();
		
		//clear panel for next frame
		pen.setColor(this.getBackground());
		System.out.print(this.getBackground().toString());
		pen.fillRect(0, 0, getWidth(), getHeight());
		pen.setColor(Color.white);

		for (Shape shape : shapes) {
			for (Point point : shape.getPoints()) {

				double[] args = point.get2dProjection();

				pen.drawOval((int) Math.round(args[0]), (int) Math.round(args[1]), 5, 5);

			}

		}

		pen.dispose();
	
	}

	public void addShape(Shape arg) {

		if (arg == null)
			return;

		this.shapes.add(arg);

	}

}
