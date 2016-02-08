import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  This class handles button clicks to save/restore snapshots.
 *  This class also serves as a caretaker of a snapshot of the Othello's board.
 */

public class Caretaker implements ActionListener {
    private String filename = "snapshot";
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
		save (board.getState ());
	    else if (label.equals (Main.restore))
		board.setState (load ());
	    else System.err.println ("Unexpected action event "+event);
	}
    }

    /**
     *  Load and return a saved snapshot of a board of Othello.
     *  @return The saved snapshot.
     */
    public Board.Snapshot load () {
	try {
	    ObjectInputStream in =
		new ObjectInputStream (
		    new FileInputStream (filename));
	    return (Board.Snapshot) in.readObject ();
	} catch (Exception e) {
	    e.printStackTrace ();
	    throw new RuntimeException (e.getMessage ());
	}
    }

    /** 
     *  Save a snapshot of a board of Othello.
     *	@param object The snapshot to be saved.
    */
    public void save (Board.Snapshot state) {
	try {
	    ObjectOutputStream out =
		new ObjectOutputStream (
		    new FileOutputStream (filename));
	    out.writeObject (state);
	    out.close ();
	} catch (Exception e) { e.printStackTrace (); }
    }

}
