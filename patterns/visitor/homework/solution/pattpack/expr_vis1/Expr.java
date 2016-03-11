package pattpack.expr_vis1;

import java.io.*;

/**
 *  This class represents an expression of the "while" language.
 */
public interface Expr {
    /**
     *  Print this expression.
     *  @param out The stream where the expression is printed.
     */
    void print (PrintStream out);
    /**
     *  Return the value of this expression.
     *  @return The value of this expression.
     */
    abstract int eval ();
}
