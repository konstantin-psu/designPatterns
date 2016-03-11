package pattpack.expr_1;
/**
 *  This abstract class defines the methods available in expressions
 *  consisting of a binary operator applied to two (sub)expressions,
 *  e.g., 3+4.
 */
public abstract class Binary implements Expr {
    /** The left and right subexpressions of this expression. */
    protected Expr left, right;
    /**
     *  Compute the left subexpression of this expression.
     *  @return The left subexpression of this expression.
     */
    public Expr getLeft () { return left; }
    /**
     *  Compute the right subexpression of this expression.
     *  @return The right subexpression of this expression.
     */
    public Expr getRight () { return right; }
}
