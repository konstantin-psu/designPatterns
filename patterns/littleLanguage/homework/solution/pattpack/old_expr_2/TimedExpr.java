package pattpack.expr_2;

/**
 *  This class decorates an expression.
 *  The decoration provides the capability to measure
 *  the elapsed time required for the expression's evaluation.
 */

public class TimedExpr extends Expr {
    // The expression being decorated.
    private Expr expr;
    // The elapsed time for the evaluation.
    private long elapsed = -1;
    /**
     *  Construct a decorated expression.
     *  @param expr The expression being decorated.
     */
    public TimedExpr (Expr expr) { this.expr = expr; }
    /**
     *  Evaluate this expression.
     *  @return The value of this expression.
     */
    public int eval () { 
	long start = System.currentTimeMillis (); 
	int value = expr.eval ();
	elapsed = System.currentTimeMillis () - start;
	return value;
    }
    /**
     *  Provide the elapsed time for this expression's evaluation.
     *  If the expression has not been evaluated, -1 is returned.
     *  @return The elapsed time for this expression's evaluation, or -1.
     */
    public long elapsed () { return elapsed; }
}
