/**
 * Classes implementing this interface represent a Mutable Position.
 */
class MutablePosition extends Position {

    /**
     * Constructor
     * @param x The x position associated with this object.
     * @param y The y position associated with this object.
     */
    public MutablePosition(int x, int y) { super(x, y); }

    /**
     * Set the x value associated with this object.
     * @param x The value to set the x coordinate to.
     */
    public void setX (int x) { this.x = x; }

    /**
     * Set the y value associated with this object.
     * @param y The value to set the y coordinate to.
     */
    public void setY (int y) { this.y = y; }

}
    
