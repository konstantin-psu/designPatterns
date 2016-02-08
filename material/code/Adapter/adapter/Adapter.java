package adapter;

import matrix.*;

/**
 *  This class is an adapter for a matrix manipulation package.
 *  The package provides static functions for matrix addition and
 *  subtraction.  These functions are called "plus" and "minus".
 *  A client expects to call these operations "add" and "sub".
 *  This adapter solves the problem.
 */

public class Adapter {

    /** Constructor.  The class is a singleton. */
    private Adapter() {}

    /**
     *  Matrix addition.
     *  @param l  The left operand.
     *  @param r  The left operand.
     */
    public static Matrix add (Matrix l, Matrix r) {
	return Matrix.plus (l, r);
    }
    /**
     *  Matrix subtraction.
     *  @param l  The left operand.
     *  @param r  The left operand.
     */
    public static Matrix sub (Matrix l, Matrix r) {
	return Matrix.minus (l, r);
    }
}
