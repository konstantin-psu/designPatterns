import java.awt.*;

/**
 *  This class implements a position of the game of Othello.
 *  A position can be in either of 3 states: empty or occupied
 *  by either player.  When occupied, a position is rendered as
 *  a circle either black or white.
 */
public class Position extends Canvas {
    /** Diameter in pixels of a position. */
    public static final int diameter = 32;
    private static final int diamSub1 = diameter - 1;
    private static final Dimension dimension
	= new Dimension (diameter, diameter);
    /**
     *  Define the preferred size of a position.
     *  @return The preferred size of a position.
     */
    public Dimension getPreferredSize () { return dimension; }

    /**  Define the colors of background, and either player. */
    public static final Color [] colors = {
	new Color (112, 138, 112),
	new Color (55, 55, 55),
	new Color (225, 225, 225),
    };

    /** Symbolic representation of an empty position. */
    public static final int empty = 0;
    /** Symbolic representation of the first player. */
    public static final int first = 1;
    /** Symbolic representation of the second player. */
    public static final int second = 2;

    private int state = empty;
    /**
     *  Set the state of this position.
     *  Then, repaint accordingly.
     *  @param state The state this position is set to.
     */
    public void setState (int state) {
	this.state = state;
	repaint();
    }
    /**
     *  Get the state of this position.
     *  @return The state of this position.
     */
    public int getState () { return state; }

    /**
     *  Paint this position according to its state.
     *  @param g The graphic context.
     */
    public void paint (Graphics g) {
	Color color = colors [state];
	g.setColor (color);
	g.fillOval (0, 0, diamSub1, diamSub1);
      	g.drawOval (0, 0, diamSub1, diamSub1);
      }
}
