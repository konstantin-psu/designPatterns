package command;

import editor.Square;

/**
 *  Base class of all commands.
 */
public abstract class Command implements Cloneable {
    /**
     *  Execution method of this command.
     *  In the base class, this method throws an exception.
     *  Perhaps this method should be abstract, but certain metacommands,
     *  such as "undo" or "history", do not have any meaningfull
     *  implementation of this method.
     *  @param square  The square the command applies to.
     *  @return Never.  It throws an exception.
     */
    public boolean doit (Square square) {
	throw new IllegalStateException (getClass().getName()+" doit called!");
    }
    /**
     *  Reverse execution method of this command.
     *  In the base class, this method throws an exception.
     *  Perhaps this method should be abstract, but certain metacommands,
     *  such as "undo" or "history", do not have any meaningfull
     *  implementation of this method.
     *  @param square  The square the command applies to.
     *  @return Never.  It throws an exception.
     */
    public boolean undoit (Square square) {
	throw new IllegalStateException (getClass().getName()+" undoit called!");
    }
    /**
     *  Standard shallow cloning method.
     *  @return A clone of this object.
     */
    public Object clone () { 
	Object o = null;
	try { o = super.clone (); }
	catch (CloneNotSupportedException cns) {
	    throw new IllegalStateException (
                "Can't clone "+getClass().getName());
	}
	return o;
    }
}
