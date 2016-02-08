/**
 * Instances of this class represent a 2D position on a playing field.
 * The class has regular getters but not setters. It is immutable.
 * It is intended to be subclassed into a either mutable or immutable class.
 * It includes a method to compute the distance between two positions.
 */
abstract class Position {
    protected int x;
    protected int y;

    /**
     * Constructor
     * @param x The x position associated with this object.
     * @param y The y position associated with this object.
     */
    protected Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Return the x value associated with this object.
     * @return the x value associated with this object.
     */
    public int getX() { return x; }

    /**
     * Return the y value associated with this object.
     * @return the y value associated with this object.
     */
    public int getY() { return y; }

    /**
     * Return the distance of the argument from this object.
     * @param p a position to computed the distance from.
     * @return the distance of the argument from this position.
     */
    public double distance(Position p) {
      return Math.sqrt( Math.pow(x-p.x, 2) + Math.pow(y-p.y, 2));
    }

}
    
