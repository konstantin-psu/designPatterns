package cmdpack;

import editor.Square;

/**
 *  Translate a square command.
 */
public class Translate extends Command {
    private int dx;
    private int dy;
    /**
     *  Construct this command.
     *  @param dx  The movement along the x axis.
     *  @param dy  The movement along the y axis.
     */
    public Translate (int dx, int dy) { this.dx = dx; this. dy = dy; }
    /**
     *  Execute this command.
     *  @param square The square target of the command.
     *  @return True
     */
    public boolean doit (Square square) {
	square.translate (dx, dy);
	return true;
    }
    /**
     *  Undo the effects of this command.
     *  @param square The square target of the command.
     *  @return True
     */
    public boolean undoit (Square square) { 
	square.translate (-dx, -dy);
	return true;
    }
    /**
     *  Return a printable representation of this command.
     *  @return A printable representation of this command.
     */
    public String toString () { return "Translate("+dx+","+dy+")"; }
}
