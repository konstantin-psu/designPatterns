package pattpack.ast_3;

import java.io.*;

/**
 *  This class represents a compound statement.
 */

public class Compound extends Statement {
    private Statement [] body;
    /**
     *  Constructor, instances are immutable.
     *  This constructor is for a two-statements compound only.
     *  @param stmt0 The first statement of this compound.
     *  @param stmt1 The second statement of this compound.
     */
    public Compound (Statement stmt0, Statement stmt1) {
	body = new Statement [2];
	body [0] = stmt0;
	body [1] = stmt1;
    }
    /**
     *  Constructor, instances are immutable.
     *  @param body The sequence of statements of this compound.
     */
    public Compound (Statement [] body) { this.body = body; }
    /**
     *  Print this statement with indentation.
     *  @param out The stream where this statement is printed.
     *  @param indent The amount of indentation of this statement.
     */
    public void print (PrintStream out, int indent) {
	super.print (out, indent);
	out.print ("begin");
	for (int i = 0; i < body.length; i++) {
	    body [i].print (out, indent+1);
	    if (i < body.length-1)
		out.print (";");
	}
	super.print (out, indent);
	out.print ("end");
    }
    /**
     *  Interpret this statement.
     */
    public void interpret () {
	for (int i = 0; i < body.length; i++) body [i].interpret ();
    }
}
