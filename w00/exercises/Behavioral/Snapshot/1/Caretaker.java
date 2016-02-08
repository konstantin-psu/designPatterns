import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  This class handles button clicks to save/restore snapshots.
 *  This class also serves as a caretaker of a snapshot of the Othello's board.
 */

public class Caretaker implements ActionListener {
    private Object snapshot = null;
    private Board board;
    /**
     *  Construct this ActionListener of the save and restore buttons
     *  and caretaker of the board snapshot.
     *  An attempt to restore a board that was never saved
     *  results in a message printed on standard error.
     *  @param board The board of the game of Othello.
     */
    public Caretaker (Board board) { this.board = board; }
    /**
     *  The action performed by the ActionListener.
     *  Either save or restore the board.
     *  @param event The action event this listener listens to.
     */
    public void actionPerformed (ActionEvent event) {
	if (event.getSource () instanceof JButton) {
	    JButton target = (JButton) event.getSource ();
	    String label = target.getText ();
	    if (label.equals (Main.save))
		snapshot = board.getMemento ();
	    else if (label.equals (Main.restore))
		if (snapshot == null)
		    // The restore button should have been disabled
		    System.err.println ("ERROR: Nothing to restore");
		else board.setMemento (snapshot);
	    else System.err.println ("Unexpected action event "+event);
	}
    }
}
