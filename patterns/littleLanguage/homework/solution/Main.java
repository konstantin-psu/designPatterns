import pattpack.expr_3.*;
import java.io.*;

/**
 *  This class is a driver for the Little Language pattern
 *  (some authors include this part in the Interpreter pattern).
 *  It is a driver for building expressions from strings
 *  and printing and/or evaluating these expressions.
 */

public class Main {
    /**
     *  Build, print and/or evaluate an expression.
     *  Read a string from the command line.
     *  Depending on TokenFactory the string is either an expression
     *  or the name of a file containing an expression.
     *  <P>
     *  This driver re-uses the expression classes of the
     *  Interpreter pattern example, though simple expressions
     *  classes are needed.
     *  @param arg Exactly one argument required.
     */
    public static void main (String [] arg) {
        if (arg.length != 1) {
	    System.err.println ("Exactly one argument required");
	    System.exit (1);
	} else 
	    try {
		Expr expr = (new ExprFactory ()).createExpr (arg [0]);
		expr.print (System.out);
		System.out.println ();
		System.out.println (expr.eval ());
	    } catch (RuntimeException re) {
		System.err.println ("Parse error: "+re.getMessage ());
	    }
    }
}
