package pattpack.expr_none;

import java.io.*;
 
/**
 *  This class represents an subtraction expression.
 */
public class Sub implements Expr {
    private Expr left, right;
    /**
     *  Construct an subtraction expression.
     *  @param left The left operand.
     *  @param right The right operand.
     */
    public Sub (Expr left, Expr right) { this.left = left; this.right = right; }
    /**
     *  Print this expression.
     *  @param out The stream where the expression is printed.
     */
    public void print (PrintStream out) {
	out.print ("-(");
	left.print (out);
	out.print (",");
	right.print (out);
	out.print (")");
    }
}
