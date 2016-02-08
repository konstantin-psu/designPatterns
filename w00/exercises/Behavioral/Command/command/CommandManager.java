package command;

import editor.*;

/**
 *  This class is a command manager for a set of commands.
 *  It looks manages metacommands such as "undo", "redo"
 *  and "history" and it dispatches the execution of regular
 *  commands.
 *  <P>
 *  This implementation limits the history (number of undoable
 *  commands) to 10, but it would be easy to make the history
 *  unbounded.
 */

public class CommandManager {
    private Editor editor;
    private static final int maxUndo = 10;
    private Command [] history = new Command [maxUndo];
    private int fillIndex = 0;
    /**
     *  Construct a CommandManager.
     *  @param editor The editor to which commands are applied.
     */
    public CommandManager (Editor editor) { this.editor = editor; }
    /**
     *  Execute a command.
     *  @param command The command to execute.
     *  @return True if the command is normally executed; false otherwise.
     */
    public boolean execute (Command command) {
	// for debugging/tracing
	System.out.println ("Execute "+command);
	// Used by most commands, let's have it
	Square square = editor.getSquare ();
	// Check for special command
	// Special commands are not saved in the history storage
	if (command instanceof Undo) {
	    if (fillIndex == 0) return false;
	    else // call the last command's undoit method and junk it
		return execRepaintable (history [--fillIndex].undoit (square));
        } else if (command instanceof Redo) {
	    if (fillIndex == 0) return false;
	    else // command is last command
		command = (Command) history [fillIndex-1].clone ();
	} else if (command instanceof History) {
	    for (int i = 0; i < fillIndex; i++)
		System.out.println (i+": "+history [i]);
	    return true;
	}
	// Save command in history
	// A circular queue would have be more efficient and abstract
	if (fillIndex == maxUndo) {
	    for (int i = 0; i < maxUndo-1; i++)
		history [i] = history [i+1];
	    history [fillIndex-1] = command;
	} else {
	    history [fillIndex++] = command;
	}
	// This is a normal command
	return execRepaintable (command.doit (square));
    }
    // This is a small factor of execute
    private boolean execRepaintable (boolean outcome) {
	editor.repaint ();
	return outcome;
    }
    // There should be a better history abstraction with methods:
    //   store command
    //   retrieve last command
    //   junk last command
    //   are there commands?
    // A stack would work well.
}
