package pattpack.ast_3;

import pattpack.expr_3.*;
import java.io.*;

/**
 *  This class represents an output statement.
 */

public class Output extends Statement {
    private Expr expr;
    /**
     *  Constructor, instances are immutable.
     *  @param expr The expression whose value will be printed.
     */
    public Output (Expr expr) {	this.expr = expr; }
    /**
     *  Print this statement with indentation.
     *  @param out The stream where this statement is printed.
     *  @param indent The amount of indentation of this statement.
     */
    public void print (PrintStream out, int indent) {
	super.print (out, indent);
	out.print ("output (");
	expr.print (out);
	out.print (")");
    }
    /**
     *  Interpret this statement.
     */
    public void interpret () { System.out.println (expr.eval ()); }
}
