package cmdpack;

import editor.Square;

/**
 *  Rotate the square by a specified number of degrees.
 */
public class Rotate extends Command {
    private int degrees;
    private double radiants;
    /**
     *  Construct this command.
     *  @param degrees  The amount of degrees of the rotation.
     */
    public Rotate (int degrees) { 
	this.degrees = degrees;
	radiants = Math.toRadians (degrees);
    }
    /**
     *  Execute this command.
     *  @param square The square target of the command.
     *  @return True
     */
    public boolean doit (Square square) {
	square.rotate (radiants);
	return true;
    }
    /**
     *  Undo the effects of this command.
     *  @param square The square target of the command.
     *  @return True
     */
    public boolean undoit (Square square) { 
	square.rotate (-radiants);
	return true;
    }
    /**
     *  Return a printable representation of this command.
     *  @return A printable representation of this command.
     */
    public String toString () { return "Rotate("+degrees+")"; }
}
