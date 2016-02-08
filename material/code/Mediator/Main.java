import java.awt.*;
import java.applet.*;

/**
 *  This is a trivial applet that hosts a board to play the game of 
 *  <A HREF="http://www.armory.com/~iioa/othguide/faq/othellorules.html">
 *  Othello</A>.
 */
public class Main extends Applet {
    /**  Initialize the applet. */
    public void init () { 
	add (new Board ());
	add (new Label ("Black moves first"));
    }

    public static void main (String [] args) { 
	Frame frame = new Frame ("Othello");
	frame.add ("North", new Board ());
	frame.add ("South", new Label ("Black moves first"));
	frame.pack ();
	frame.show ();
	frame.setResizable (false);
    }
}

