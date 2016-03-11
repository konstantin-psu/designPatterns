package pattpack.expr_vis3;

import java.io.*;
 
/**
 *  This class represents an "greater then" conditional expression.
 */
public class Gt extends Binary {
    /**
     *  Construct an "greater then" conditional expression.
     *  @param left The left operand.
     *  @param right The right operand.
     */
    public Gt (Expr left, Expr right) { this.left = left; this.right = right; }
    /**
     *  Visitor dispatcher.
     *  @param visitor The visitor to visit this object.
     *  @param data The visitor argument.
     *  @return The visitor returned value.
     */
    public Object accept (Visitor visitor, Object data) {
	return visitor.visit (this, data);
    }
}
