package pattpack.ast_3;

import pattpack.expr_3.*;
import java.io.*;

/**
 *  This class represents an if-then-else statement.
 */

public class Conditional extends Statement {
    private Expr test;
    private Statement thenClause;
    private Statement elseClause;
    /**
     *  Constructor, instances are immutable.
     *  @param test The test expression of this if-then-else statement.
     *  @param thenClause The "then" clause of this statement.
     *  @param elseClause The "else" clause of this statement.
     */
    public Conditional (Expr test, Statement thenClause, Statement elseClause) {
	this.test = test;
	this.thenClause = thenClause;
	this.elseClause = elseClause;
    }
    /**
     *  Print this statement with indentation.
     *  @param out The stream where this statement is printed.
     *  @param indent The amount of indentation of this statement.
     */
    public void print (PrintStream out, int indent) {
	super.print (out, indent);
	out.print ("if ");
	test.print (out);
	super.print (out, indent+1);
	out.print ("then");
	thenClause.print (out, indent+2);
	super.print (out, indent+1);
	out.print ("else");
	elseClause.print (out, indent+2);
    }
    /**
     *  Interpret this statement.
     */
    public void interpret () {
	if (test.eval () == 1) thenClause.interpret ();
	else elseClause.interpret ();
    }
}
