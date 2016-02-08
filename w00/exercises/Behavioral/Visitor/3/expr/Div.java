package expr;

import java.io.*;
 
/**
 *  This class represents an division expression.
 */
public class Div extends Binary {
    /**
     *  Construct an division expression.
     *  @param left The left operand.
     *  @param right The right operand.
     */
    public Div (Expr left, Expr right) { this.left = left; this.right = right; }
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
