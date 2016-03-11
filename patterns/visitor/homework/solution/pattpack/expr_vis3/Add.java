package pattpack.expr_vis3;

import java.io.*;
 
/**
 *  This class represents an addition expression.
 */
public class Add extends Binary {
    public Add (Expr left, Expr right) { this.left = left; this.right = right; }
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

