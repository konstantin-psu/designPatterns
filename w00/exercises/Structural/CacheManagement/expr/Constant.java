package expr;

/**
 *  This class implements constant expressions.
 *  A constant expression is the representation of an "int".
 */

public class Constant extends Expr {
    /** The int value represented by this expression. */
    protected int value;
    /**
     *  Construct this expression.
     *  @param value The int value represented by this expression.
     */
    public Constant (int value) { this.value = value; }
    /**
     *  Evaluate this expression (directly rather than using the cache).
     *  @return The value of this expression.
     */
    public int eval () { return value; }
}
