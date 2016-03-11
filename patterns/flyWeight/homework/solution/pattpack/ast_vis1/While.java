package pattpack.ast_vis1;

import pattpack.expr_vis1.*;
import java.io.*;

/**
 *  This class represents a "while" statement.
 */

public class While implements Statement {
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
     *  Return the test of this while statement.
     *  @return The test of this while statement.
     */
    public Expr getTest () { return test; }
    /**
     *  Return the body of this while.
     *  An enumeration would be more appropriate.
     *  @return The body of this while.
     */
    public Statement getBody () { return body; }
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
	while (test.eval () == 1) body.interpret ();
    }
}
