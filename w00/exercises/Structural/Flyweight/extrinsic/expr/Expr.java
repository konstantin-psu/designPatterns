package expr;

import java.io.*;

/**
 *  This class represents an expression of the "while" language.
 *  Currently, expressions are empty.
 */
public interface Expr {
    /**
     *  Print this expression.
     *  @param out The stream where the expression is printed.
     */
    void print (PrintStream out);
}
