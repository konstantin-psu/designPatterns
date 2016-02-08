package expr;

import java.io.*;
 
/**
 *  This class represents an "less then" conditional expression.
 */
public class Lt extends Binary {
    /**
     *  Construct an "less then" conditional expression.
     *  @param left The left operand.
     *  @param right The right operand.
     */
    public Lt (Expr left, Expr right) { this.left = left; this.right = right; }
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
