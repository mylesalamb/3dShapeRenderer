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
 * a class to grpahically represent shape objects
 * 
 * @author mashe
 *
 */
public class ShapeBoard extends JPanel implements MouseListener, MouseMotionListener {

	public static final int FRAME_CAP = 60;
	public static final int TICK_RATE = 60;
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
	 * scheduler for calclulating for when the view and the model should change
	 */
	public void start() {

		Thread schedule = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("run called");
				runs();
				// should proabably rename the methods here
				System.out.println("run finished");
			}
		});
		schedule.start();

	}

	private void runs() {

		// setup vars for calculation
		int frameDelta = 0;
		int tickDelta = 0;
		long lastFrame = System.nanoTime();
		long lastTick = System.nanoTime();

		while (true) {

			long currTime = System.nanoTime();
			frameDelta += (int) ((currTime - lastFrame) / 1000000);

			if (frameDelta > 1000000 * 5) {
				renderLoop();
				lastFrame = currTime;
				frameDelta = 0;
				//shapes.get(0).rotateX(1);
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
	
	private int currX,currY,prevX,prevY;
	
	
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
		this.shapes.get(0).rotateY(Math.toDegrees(Math.asin((currX-prevX)/250.00)));
		prevX=currX;
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

	@Override
	public void mousePressed(MouseEvent arg0) {
		currX = arg0.getX();
		prevX = arg0.getX();
		currY = arg0.getY();
		prevY = arg0.getY();
		
	}

}
