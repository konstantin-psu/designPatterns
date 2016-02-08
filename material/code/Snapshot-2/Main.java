import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  This is a driver to host a board to play the game of 
 *  <A HREF="http://www.armory.com/~iioa/othguide/faq/othellorules.html">
 *  Othello</A>.
 */
public class Main extends Frame {
    
    /** Define the label of the save button. */
    public static final String save = "Save";
    /** Define the label of the restore button. */
    public static final String restore = "Restore";

    /**
     *  Construct the main frame.
     *  @param title  The title of the frame.
     */
    public Main (String title) {
	super (title);

	Board board = new Board ();
	JPanel fixsize = new JPanel (false);
	fixsize.add (board);

	JPanel main = new JPanel (new BorderLayout (0, 4), false);
	main.add ("North", fixsize);

	Caretaker caretaker = new Caretaker (board);
	JButton bsave = new JButton (save);
	bsave.addActionListener (caretaker);
	JButton brestore = new JButton (restore);	
	brestore.addActionListener (caretaker);

	JPanel buttons = new JPanel (new GridLayout (1, 2, 5, 5), false);
	buttons.add (bsave);
	buttons.add (brestore);
	main.add ("South", buttons);

	add (main);
	pack ();
    }

    /**
     *  Program entry point.
     *  @param args Unused.
     */
    public static void main (String [] args) {
	Main frame = new Main ("Othello");
	frame.addWindowListener (new WindowAdapter () {
	    public void windowClosing (WindowEvent e) { System.exit (0); }
	});
	frame.show ();
    }
}
