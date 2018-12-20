package shape;

/**
 * @author mashe
 * simple wrapper class for points in the shape renderer
 */
public class Point {
	
	
	private double x;
	private double y;
	private double z;
	
	public Point(int x,int y, int z) {
		
		this.x = x; 
		this.y = y;
		this.z = z;
		
	}

	public Point() {
		this(0,0,0);
	}
	
	
	/**
	 * @return 2d projection of this point
	 * tidies the drawing code
	 */
	public int[] getRoundedProjection() {
		
		return new int[] {(int)Math.round(this.x),(int)Math.round(this.y)};
		
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * @return the z
	 */
	public double getZ() {
		return z;
	}

	/**
	 * @param z the z to set
	 */
	public void setZ(double z) {
		this.z = z;
	}

}
