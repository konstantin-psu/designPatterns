package pattpack.ast_3;

import pattpack.expr_3.*;
import java.io.*;

/**
 *  This class represents a "while" statement.
 */

public class While extends Statement {
    private Expr test;
    private Statement body;
    /**
     *  Constructor, instances are immutable.
     *  @param test The test expression of the while statement.
     *  @param body The body of the while statement.
     */
    public While (Expr test, Statement body) {
	this.test = test;
	this.body = body;
    }
    /**
     *  Print this statement with indentation.
     *  @param out The stream where this statement is printed.
     *  @param indent The amount of indentation of this statement.
     */
    public void print (PrintStream out, int indent) {
	super.print (out, indent);
	out.print ("while ");
	test.print (out);
	out.print (" do");
	body.print (out, indent+1);
    }
    /**
     *  Interpret this statement.
     */
    public void interpret () {
	while (test.eval () == 1) body.interpret ();
    }
}
