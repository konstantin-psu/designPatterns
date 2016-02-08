import java.awt.*;

/**
 *  This class implements the visual part of a board
 *  for playing the game of
 *  <A HREF="http://www.armory.com/~iioa/othguide/faq/othellorules.html">
 *  Othello</A>.
 */
public class Board extends Panel {
    /** The number of position along the side of the board. */
    public static final int size = 8;
    private Position [] [] cell = new Position [size] [size];

    private static final Color dotColor = new Color (200, 200, 100);

    // gap between positions, better be odd
    private static final int gap = 3;  
    // distance between corresponding corners of adjacent positions
    private static final int step = Position.diameter + gap;

    private static final int ins = gap / 2 + 1;
    private static final Insets insets = new Insets (ins, ins, ins, ins);

    /** Construct the board of Othello. */
    public Board () {
	setBackground (Position.colors [Position.empty]);
	setLayout (new GridLayout (size, size, gap, gap));
	for (int row = 0; row < size; row++)
	    for (int col = 0; col < size; col ++) {
		Position p = new Position ();
		p.addMouseListener (new Mediator (cell, row, col));
		cell [row] [col] = p;
		add (p);
	    }
	int center = size / 2;
	cell [center] [center-1] . setState (Position.first);
	cell [center-1] [center] . setState (Position.first);
	cell [center] [center] . setState (Position.second);
	cell [center-1] [center-1] . setState (Position.second);
    }

    /**
     *  Paint the board of Othello.
     *  @param g  The graphics context.
     */
    public void paint (Graphics g) {
	g.setColor (dotColor);
	int hw = step * size;
	for (int row = 0; row <= size; row++) {
	    int b = step * row;
	    g.drawLine (b, 0, b, hw);
	    g.drawLine (0, b, hw, b);
	}
	int p = gap - 1;
	int q = 2 * gap - 1;
	for (int row = 2; row <= 6; row += 4)
	    for (int col = 2; col <= 6; col += 4) {
		g.fillRect (step * row - p, step * col - p, q, q);
	    }
    }
    /**
     *  Define the insets of the board.
     *  @return The insets of the board.
     */
    public Insets getInsets () { return insets; }

    // Visible only from Board it encapsulates the state
    private static class Memento {
	private int [] [] cell = new int [size] [size];
	private Memento (Position [] [] cell) {
	    for (int row = 0; row < size; row++)
		for (int col = 0; col < size; col ++)
		    this.cell [row] [col] = cell [row] [col].getState ();
	}
    }

    /**
     *  Return a snapshot of this board.
     *  The type is Object, rather than Memento,
     *  to preserve information hiding.
     *  @return A snapshot of this board.
     */
    public Object getMemento () { return new Memento (cell); }

    /**
     *  Restore this board to a previous state.
     *  @param object A previous state.
     */
    public void setMemento (Object object) {
	Memento memento = (Memento) object;
	for (int row = 0; row < size; row++)
	    for (int col = 0; col < size; col ++)
		cell [row] [col].setState (memento.cell [row] [col]);
    }
}
