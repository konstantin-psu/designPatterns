package adapter;

import matrix.*;

/**
 *  This class is an adapter for a matrix manipulation package.
 *  The package provides static functions for matrix addition and
 *  subtraction.  These functions are called "plus" and "minus".
 *  A client expects to call these operations "add" and "sub".
 *  This adapter solves the problem.
 */

public class Matrix extends matrix.Matrix {
    /**
     *  Typical constructor. No check performed on the argument.
     *  @param entry The entries of the matrix to copy.
     */
    public Matrix (double [] [] entry) { super (entry); }
    /**
     *  Althought this is a constructor, it works as a conversion
     *  function from type matrix.Matrix to its subtype adapter.Matrix.
     *  @param m The matrix to convert.
     */
    private Matrix (matrix.Matrix m) { super (m); }
    /**
     *  Matrix addition.
     *  @param l  The left operand.
     *  @param r  The left operand.
     */
    public static Matrix add (Matrix l, Matrix r) {
	return new Matrix (Matrix.plus (l, r));
    }
    /**
     *  Matrix subtraction.
     *  @param l  The left operand.
     *  @param r  The left operand.
     */
    public static Matrix sub (Matrix l, Matrix r) {
	return new Matrix (Matrix.minus (l, r));
    }
}
