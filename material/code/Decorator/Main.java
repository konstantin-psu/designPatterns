import pattpack.expr_1.*;

/**
 *  Driver for a Decorator pattern example.
 *  All the work is done by the main method.
 */

public class Main {
    /** 
     *  Usual entry point.
     *  This method 
     *  <UL>
     *  <LI> constructs a relatively large expression,
     *  <LI> uses this expression to construct a timed expression,
     *  <LI> evaluates the timed expression,
     *  <LI> prints both the computed value and the evaluation's elapsed time.
     *  </UL>
     *  @param args Ignored.
     */
    public static void main (String [] args) {
	// Constructs a plain expression
	Expr previous = new Constant (0);
	Expr current = new Constant (1);
	for (int i = 2; i < 30; i++) {
	    Expr tmp = new Add (previous, current);
	    // System.out.println ("fib("+i+")="+tmp.eval ());
	    previous = current;
	    current = tmp;
	}
	// Construct a timed expressions
	TimedExpr timed = new TimedExpr (current);
	// Print the results
	System.out.println ("value="+timed.eval ());
	System.out.println ("time="+timed.elapsed ());
    }
}
