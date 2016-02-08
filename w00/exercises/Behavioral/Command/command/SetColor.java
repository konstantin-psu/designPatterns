package command;

import java.awt.Color;
import editor.Square;

/**
 *  Change color of a square command.
 */
public class SetColor extends Command {
    // the color the square had before executing this command
    private Color previousColor;
    // the color to assign to the square
    private Color currentColor;
    /**
     *  Construct this command.
     *  @param color  The color to assign to the square.
     */
    public SetColor (Color color) { currentColor = color; }
    /**
     *  Execute this command.
     *  @param square The square target of the command.
     *  @return True
     */
    public boolean doit (Square square) {
	// save square's color for undo
	previousColor = square.getColor ();
	square.setColor (currentColor);
	return true;
    }
    /**
     *  Undo the effects of this command.
     *  @param square The square target of the command.
     *  @return True
     */
    public boolean undoit (Square square) { 
	square.setColor (previousColor);
	return true;
    }
    /**
     *  Return a printable representation of this command.
     *  @return A printable representation of this command.
     */
    public String toString () { return "SetColor("+currentColor+")"; }
}
