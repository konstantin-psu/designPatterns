import java.awt.*;
import java.awt.event.*;

/**
 *  This class handles mouse clicks on a position.
 *  A position must know the state of other positions
 *  in order to know whether it can be occupied.
 *  This class serves as a mediator among positions.
 *  <P>
 *  There is a mediator for each position, which seems to defy
 *  the spirit of the pattern.  However, the logic of the
 *  mediator is in the methods and static variables only.
 *  There is a mediator object for each position so that
 *  the row and column of the position is bound to its
 *  event handler when the event handler is constructed.
 *  This simplifies moving information around.
 *  <P>
 *  To have a single mediator, store the row and column
 *  of a position in the position itself.  Have a single
 *  meditor (event handler).  In the mediator, retrieve the
 *  row and column of a position from the event.
 */

public class Mediator extends MouseAdapter {
    private static Position [] [] cell;
    private int row, col;
    /**
     *  Construct a position.
     *  @param cell The array of positions of the board.
     *  @param row The row of the position this listenet listen to.
     *  @param col The col of the position this listenet listen to.
     */
    public Mediator (Position [] [] cell, int row, int col) {
	this.cell = cell;
	this.row  = row;
	this.col  = col;
    }

    // directions                            E SE  S SW  W NW  N NE
    private static final int [] dx_array = { 1, 1, 0,-1,-1,-1, 0, 1};
    private static final int [] dy_array = { 0, 1, 1, 1, 0,-1,-1,-1};

    private static Position [] toFlip = new Position [Board.size * Board.size];

    /**
     *  Event Handler.
     *  If the clicked position is empty and can be occupied,
     *  the position is occupied and all other positions involved
     *  in the move are flipped.
     *  @param evt The mouse click event of the position
     *             this listener is listening to.
     */
    public void mouseClicked (MouseEvent evt) {
	if (cell [row] [col].getState () != Position.empty) return;
	int player = 0;
	for (int r = 0; r < Board.size; r++)
	    for (int c = 0; c < Board.size; c ++)
		if (cell [r] [c].getState () != Position.empty)
		    player++;
	player = player % 2 == 0 ? Position.first : Position.second;
	int opponent = player == Position.first ? Position.second : Position.first;
	int flipCounter = 0;
	// for each direction, record position to be flipped
	for (int i = 0; i < dx_array.length; i++) {
	    int dx = dx_array [i];
	    int dy = dy_array [i];
	    try {
		if (cell [row+dx] [col+dy].getState() == opponent) {
		    for (int k = 2; ;k++) {
			int state = cell [row+k*dx] [col+k*dy].getState();
			if (state == player) {
			    for (k--; k >= 1; k--)
				toFlip [flipCounter++] = cell [row+k*dx] [col+k*dy];
			    break;
			}
			else if (state == Position.empty) break;
			else continue;
		    }
		}
	    } catch (ArrayIndexOutOfBoundsException aioobe) { continue; }
	}
	if (flipCounter > 0) {
	    for (int i = 0; i < flipCounter; i++)
		toFlip [i].setState (player);
	    cell [row] [col].setState (player);
	    cell [row] [col].repaint ();
	}
    }
}
