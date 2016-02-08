package expr;

/**
 *  This class implements subtraction expressions.
 *  A subtraction expression is the representation, e.g., of "3-2".
 */

public class Sub extends Binary {
    /**
     *  Construct this expression.
     *  @param left The left subexpression of this expression.
     *  @param right The right subexpression of this expression.
     */
    public Sub (Expr left, Expr right) { this.left = left; this.right = right; }
    /**
     *  Evaluate this expression.
     *  @return The value of this expression.
     */
    public int eval () { return left.eval () - right.eval (); }
}
