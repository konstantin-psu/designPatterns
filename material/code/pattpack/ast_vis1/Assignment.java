package pattpack.ast_vis1;

import pattpack.expr_vis1.*;
import java.io.*;

/**
 *  This class represents an assignment statement.
 */

public class Assignment implements Statement {
    private Variable lvalue;
    private Expr rvalue;
    /**
     *  Constructor, instances are immutable.
     *  @param lvalue The left-hand side of this assignment.
     *  @param rvalue The righ-hand side of this assignment.
     */
    public Assignment (Variable lvalue, Expr rvalue) {
	this.lvalue = lvalue;
	this.rvalue = rvalue;
    }
    /**
     *  Return the left side of this assignment.
     *  @return The left side of this assignment.
     */
    public Variable getLvalue () { return lvalue; }
    /**
     *  Return the right side of this assignment.
     *  @return The right side of this assignment.
     */
    public Expr getRvalue () { return rvalue; }
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
    public void interpret () { lvalue.setValue (rvalue.eval ()); }
}
