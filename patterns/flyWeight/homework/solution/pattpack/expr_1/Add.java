package pattpack.expr_1;

/**
 *  This class implements addition expressions.
 *  An addition expression is the representation, e.g., of "3+4".
 */

public class Add extends Binary {
    /**
     *  Construct this expression.
     *  @param left The left subexpression of this expression.
     *  @param right The right subexpression of this expression.
     */
    public Add (Expr left, Expr right) { this.left = left; this.right = right; }
    /**
     *  Evaluate this expression.
     *  @return The value of this expression.
     */
    public int eval () { return left.eval () + right.eval (); }
}
