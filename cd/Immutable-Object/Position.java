/**
 * Instances of this class represent a position on a playing field.
 *<p>
 * The lack of methods to set this x and y value of this class' instances is
 * not an oversight.  Instances of this class are intended to be immutable.
 */
class Position {
    private int x;
    private int y;

    /**
     * Constructor
     * @param x The x position associationed with this object.
     * @param y The y position associationed with this object.
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    } // Position(int, int)

    /**
     * Return the x value assolciated with this object.
     */
    public int getX() { return x; }

    /**
     * Return the y value assolciated with this object.
     */
    public int getY() { return y; }

    /**
     * Return a Position object that has x and y values that are
     * offset from the x and y values of this object by the given
     * amount.
     * @param xOffset The x offset.
     * @param yOffset The y offset.
     */
    public Position offset(int xOffset, int yOffset) {
        return new Position(x+xOffset, y+yOffset);
    } // offset(int, int)
} // classs Position
    
