/**
 * Instances of this class represent a position on a playing field.
 * The class has regular getters and setters. It is mutable.
 * <P>
 * The ImmutablePositionIF interface is used to make the position immutable.
 */
class Position {
    private int x;
    private int y;

    /**
     * Constructor
     * @param x The x position associated with this object.
     * @param y The y position associated with this object.
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    } // Position(int, int)

    /**
     * Return the x value associated with this object.
     */
    public int getX() { return x; }

    /**
     * Set the x value associated with this object.
     */
    public void setX (int x) { this.x = x; }

    /**
     * Return the y value associated with this object.
     */
    public int getY() { return y; }

    /**
     * Set the y value associated with this object.
     */
    public void setY (int y) { this.y = y; }

} // class Position
    
