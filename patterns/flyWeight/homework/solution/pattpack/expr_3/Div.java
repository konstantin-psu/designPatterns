package pattpack.expr_3;

import java.io.*;
 
/**
 *  This class represents an division expression.
 */
public class Div implements Expr {
    private Expr left, right;
    /**
     *  Construct an division expression.
     *  @param left The left operand.
     *  @param right The right operand.
     */
    public Div (Expr left, Expr right) { this.left = left; this.right = right; }
    /**
     *  Print this expression.
     *  @param out The stream where the expression is printed.
     */
    public void print (PrintStream out) {
	out.print ("/(");
	left.print (out);
	out.print (",");
	right.print (out);
	out.print (")");
    }
    /**
     *  Return the value of this expression.
     *  @return The value of this expression.
     */
    public int eval () { return left.eval () / right.eval (); }
}
