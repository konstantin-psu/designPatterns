/**
 * Instances of this class represent a position on a playing field.
 * The class has regular getters and setters. It is mutable.
 */
class Position implements MutablePosition, ImmutablePosition {
    private int x;
    private int y;

    /**
     * Constructor
     * @param x The x position associated with this object.
     * @param y The y position associated with this object.
     */
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    } // Position(int, int)

    /**
     * Return the x value associated with this object.
     * @return the x value associated with this object.
     */
    public int getX() { return x; }

    /**
     * Set the x value associated with this object.
     * @param x The value to set the x coordinate to.
     */
    public void setX (int x) { this.x = x; }

    /**
     * Return the y value associated with this object.
     * @return the y value associated with this object.
     */
    public int getY() { return y; }

    /**
     * Set the y value associated with this object.
     * @param y The value to set the y coordinate to.
     */
    public void setY (int y) { this.y = y; }

} // class Position
    
