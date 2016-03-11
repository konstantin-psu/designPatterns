package pattpack.ast_vis1;

import pattpack.expr_vis1.*;
import java.io.*;

/**
 *  This class represents an output statement.
 */

public class Output implements Statement {
    private Expr expr;
    /**
     *  Constructor, instances are immutable.
     *  @param expr The expression whose value will be printed.
     */
    public Output (Expr expr) {	this.expr = expr; }
    /**
     *  Return the argument of this output statement.
     *  @return The argument of this output statement.
     */
    public Expr getExpr () { return expr; }
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
    public void interpret () { System.out.println (expr.eval ()); }
}
