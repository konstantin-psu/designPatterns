import java.awt.*;
import java.util.*;

/**
 *  This Applet hosts a Balking pattern.
 *  A clicks on the applet produces an animation.
 *  The animation shows a bubble that grows from the point
 *  of the click and slowly disappears.
 *  <P>
 *  A compile time constant limits the number of bubbles
 *  that can appears at any one time on the applet.
 *  When the maximum number of bubbless is reached,
 *  further clicks are ignored.  As bubbles disappear,
 *  new clicks produce new bubbles.
 */

public class Main extends java.applet.Applet {
    // Maximum number of bubbles
    private final int maxbubbles = 3;
    private final Color background = Color.lightGray;
    private final int begin = Color.black.getRed ();
    private final int end = background.getRed ();
    /** Initialize this applet. */
    public void init () { setBackground (background); }
    /**
     *  Mouse click handler.
     *  Synchronization is needed to start a new bubble only
     *  if the number of bubbles in the applet is not maximum.
     *  @param evt The mouse click event.
     *  @param x The abscissa mouse click event.
     *  @param y The ordinate mouse click event.
     */
    public synchronized boolean mouseDown (Event evt, int x, int y) {
	// Balking may take place in the next statement
	if (currents.size () < maxbubbles) (new Animate (x, y)).start ();
	return true;
    }
    // The info necessary to draw a bubble
    private class Bubble {
	private int p, q, r;
	private Color c;
    }
    // The vector holding the bubbles
    private Vector currents = new Vector ();
    /**
     *  Paint this applet.
     *  @param g  The graphic context.
     */
    public void paint (Graphics g) {
	for (int i = 0; i < currents.size (); i++) {
	    Bubble bubble = (Bubble) currents.elementAt (i);
	    g.setColor (bubble.c);
	    int r = bubble.r;
	    g.fillOval (bubble.p, bubble.q, r, r);
	}
    }
    // This thread performs the animation of a single bubble.
    // Periodically, it computes the position, size and color
    // of a bubble and calls repaint.
    private class Animate extends Thread {
	private final int loops = 20;
	private final int maxdiameter = 100;
	private final int fact = maxdiameter / loops;
	private final Color shade [] = new Color [loops];
	private int x, y;
	private Animate (int x, int y) {
	    this.x = x; this.y = y;
	    for (int i = 0; i < loops; i++) {
		int c = begin + (end - begin) * i / (loops - 1);
		shade [i] = new Color (c, c, c);
	    }
	}
	/**
	 *  Add a bubble to the applet.
	 *  Periodically compute the position, size and color
	 *  of a bubble and call repaint.
	 *  Remove the bubble from the applet.
	 */ 
	public void run () {
	    Bubble bubble = new Bubble ();
	    currents.add (bubble);
	    for (int i = 0; i < loops; i++) {
		int r2 = (bubble.r = i * fact) / 2;
		bubble.p = x - r2;
		bubble.q = y - r2;
		bubble.c = shade [i];
		repaint ();
                try { sleep (100); }
                catch (InterruptedException ie) {}
	    }
	    currents.remove (bubble);
	}
    }
}
