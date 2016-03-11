package pattpack.expr_vis3;

import java.io.*;
 
/**
 *  This class represents an subtraction expression.
 */
public class Sub extends Binary {
    /**
     *  Construct an subtraction expression.
     *  @param left The left operand.
     *  @param right The right operand.
     */
    public Sub (Expr left, Expr right) { this.left = left; this.right = right; }
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
