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

		// this.addComponentListener(new);
	}

	/**
	 * scheduler for calclulating for when the view and
	 * the model should change
	 */
	public void start() {
		
		//setup vars for calculation
		int frameDelta = 0;
		int tickDelta = 0;
		long lastFrame = System.nanoTime();
		long lastTick = System.nanoTime();

		while (true) {

			long currTime = System.nanoTime();
			frameDelta += (int) ((currTime - lastFrame) / 1000000);

			if (frameDelta > 1000000 * 8) {
				renderLoop();
				lastFrame = currTime;
				frameDelta = 0;

				shapes.get(0).rotateZ(1);
				shapes.get(0).rotateY(2);
				shapes.get(0).rotateX(1);
			}

		}

	}

	/**
	 * active rendering loop so we cna control when paint events are called
	 */
	public void renderLoop() {

		Graphics pen = this.getGraphics();

		// clear panel for next frame
		pen.setColor(this.getBackground());
		pen.fillRect(0, 0, getWidth(), getHeight());
		pen.setColor(Color.white);

		for (Shape shape : shapes) {
			for (Point point : shape.getPoints()) {
				int[] args = point.getRoundedProjection();
				pen.fillOval(args[0], args[1], 5, 5);
			}

			for (Point[] connection : shape.getConnections()) {
				int[] from = connection[0].getRoundedProjection();
				int[] to = connection[1].getRoundedProjection();
				pen.drawLine(from[0], from[1], to[0], to[1]);
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
