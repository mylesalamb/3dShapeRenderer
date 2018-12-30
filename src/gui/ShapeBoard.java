package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import shape.Point;
import shape.Shape;

/**
 * a class to graphically represent shape objects
 * 
 * @author mashe
 *
 */
public class ShapeBoard extends JPanel implements MouseListener, MouseMotionListener {

	// the shapes to represent and the frame cap for which they should be rendered
	// at
	public static final int FRAME_CAP = 60;
	public static final int INTERVAL = 1_000_000_000 / FRAME_CAP;
	private List<Shape> shapes;

	public ShapeBoard() {

		// for dragging to alter shapes position
		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		this.setBackground(Color.black);
		this.setIgnoreRepaint(true);
		shapes = new ArrayList<>();

	}

	/**
	 * scheduler for calculating for when the view and the model should change
	 */
	public void start() {

		// prevent blocking of the main thread and event handlers
		Thread schedule = new Thread(new Runnable() {
			@Override
			public void run() {
				scheduler();
			}
		});
		schedule.start();

	}

	private void scheduler() {

		// setup vars for calculation
		long frameDelta = 0;
		long lastTime = System.nanoTime();

		while (true) {

			long currTime = System.nanoTime();
			frameDelta = (currTime - lastTime);

			if (frameDelta >= INTERVAL) {
				renderLoop();
				lastTime = currTime;
				frameDelta = 0;
				shapes.get(0).rotateZ(Math.PI/180.00);
			}

		}

	}

	/**
	 * active rendering loop so we can control when paint events are called
	 */
	public void renderLoop() {

		Graphics pen = this.getGraphics();

		// clear panel for next frame
		pen.setColor(this.getBackground());
		pen.fillRect(0, 0, getWidth(), getHeight());
		pen.setColor(Color.red);

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

	/**
	 * adds a shape to the container such that it is to be rendered
	 * 
	 * @param arg the shape to be added to the render loop
	 */

	private int currX, currY, prevX, prevY;

	public void addShape(Shape arg) {

		this.shapes.add(arg);

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {

		currX = arg0.getX();
		currY = arg0.getY();
		double ySpin = Math.asin((currX - prevX) / 125.00);
		this.shapes.get(0).rotateY(ySpin);

		double xSpin = -Math.atan((currY - prevY) / 125.00);
		this.shapes.get(0).rotateX(xSpin);

		prevY = currY;
		prevX = currX;
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * reset the state when the user begins to click
	 * 
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		currX = arg0.getX();
		prevX = arg0.getX();
		currY = arg0.getY();
		prevY = arg0.getY();

	}

}
