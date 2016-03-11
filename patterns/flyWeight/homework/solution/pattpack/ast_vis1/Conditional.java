package pattpack.ast_vis1;

import pattpack.expr_vis1.*;
import java.io.*;

/**
 *  This class represents an if-then-else statement.
 */

public class Conditional implements Statement {
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
     *  Return the test of this conditional statement.
     *  @return The test of this conditional statement.
     */
    public Expr getTest () { return test; }
    /**
     *  Return the then clause of this conditional statement.
     *  @return The then clause of this conditional statement.
     */
    public Statement getThenClause () { return thenClause; }
    /**
     *  Return the else clause of this conditional statement.
     *  @return The else clause of this conditional statement.
     */
    public Statement getElseClause () { return elseClause; }
    /**
     *  Visitor dispatcher.
     *  @param visitor The visitor to visit this object.
     *  @param data The visitor argument.
     *  @return The visitor returned value.
     */
    public Object accept (Visitor visitor, Object data) {
	return visitor.visit (this, data);
    }
    /**
     *  Interpret this statement.
     */
    public void interpret () {
	if (test.eval () == 1) thenClause.interpret ();
	else elseClause.interpret ();
    }
}
