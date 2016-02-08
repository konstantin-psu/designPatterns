package expr;

import java.io.*;
 
/**
 *  This abstract class is the base of all binary expression.
 */
public abstract class Binary implements Expr {
    protected Expr left, right;
    /**
     *  Return the left operand of this expression.
     *  @return The left operand of this expression.
     */
    public Expr getLeft () { return left; }
    /**
     *  Return the right operand of this expression.
     *  @return The right operand of this expression.
     */
    public Expr getRight () { return right; }
}
