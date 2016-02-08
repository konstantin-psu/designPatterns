import java.awt.*;
import editor.*;
import cmdpack.*;

/**
 *  This applet schedules the execution of a predetermined sequence
 *  of commands for a trivial graphics editor. It hosts the editor,
 *  the command manager, and a thread to space commands in time. 
 */
public class Main extends java.applet.Applet implements Runnable {
    private Command [] command = {
	new Translate (30, 30),
	new SetColor (Color.pink),
	new Rotate (30),
	new SetColor (Color.blue),
	new Undo (),
	new Redo (),
	new Translate (30, 0),
	new History (),
    };
    private Editor editor = new Editor ();
    private CommandManager manager = new CommandManager (editor);
    private Thread thread;
    /** Initialize this applet. */
    public void init () { 
	add (editor);
	thread = new Thread (this);
	thread.start ();
    }
    /** Execute the predetermined commands. */
    public void run () {
	for (int i = 0; i < command.length; i++) {
	    manager.execute (command [i]);
	    try { thread.sleep (2500); }
	    catch (InterruptedException ok) {}
	}
    }
}
