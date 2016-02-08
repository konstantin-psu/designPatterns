package pattpack.ast_3;

import java.io.*;

/**
 *  Base class of all statements.
 */
public abstract class Statement {
    /**
     *  Print this statement with indentation.
     *  Note that this method begins with a new line,
     *  but it does not add a new line at the end of the statement.
     *  @param out The stream where the statement is printed.
     *  @param indent The amount (# of blanks * 2) of indentation.
     */
    public void print (PrintStream out, int indent) {
	out.println ();
	for (int i = 0; i < indent; i++) out.print ("  ");
    }
    /**
     *  Interpret this statement.
     */
    abstract void interpret ();
}
