package pattpack.expr_3;

import java.io.*;
 
/**
 *  This class represents an multiplication expression.
 */
public class Mul implements Expr {
    private Expr left, right;
    /**
     *  Construct an multiplication expression.
     *  @param left The left operand.
     *  @param right The right operand.
     */
    public Mul (Expr left, Expr right) { this.left = left; this.right = right; }
    /**
     *  Print this expression.
     *  @param out The stream where the expression is printed.
     */
    public void print (PrintStream out) {
	out.print ("*(");
	left.print (out);
	out.print (",");
	right.print (out);
	out.print (")");
    }
    /**
     *  Return the value of this expression.
     *  @return The value of this expression.
     */
    public int eval () { return left.eval () * right.eval (); }
}
