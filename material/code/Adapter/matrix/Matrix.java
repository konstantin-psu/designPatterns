// Revision July 6, 2007

package matrix;

/**
 *  This class stands for matrix manipulation package for an
 *  exercise for an Adapter pattern.  Matrices are represented
 *  by a 2-dimensional array of doubles.
 *
 *  Operations are implemented by static functions.
 */
public class Matrix {
    /** Representation of the matrix entries. */
    protected double [] [] entry;
    /**
     *  Typical constructor. No check performed on the argument.
     *  @param entry The entries of the matrix.
     */
    public Matrix (double [] [] entry) { this.entry = entry; }
    /**
     *  Matrix addition.
     *  @param l  The left operand.
     *  @param r  The left operand.
     */
    public static Matrix plus (Matrix l, Matrix r) {
	double [] [] x = new double [l.entry.length] [l.entry [0].length];
	// It should check equal sizes
	// Let the compiler optimize
	for (int i = 0; i < l.entry.length; i++)
	    for (int j = 0; j < l.entry [i].length; j++)
		x [i] [j] = l.entry [i] [j] + r.entry [i] [j];
	return new Matrix (x);
    }
    /**
     *  Matrix subtraction.
     *  @param l  The left operand.
     *  @param r  The left operand.
     */
    public static Matrix minus (Matrix l, Matrix r) {
	double [] [] x = new double [l.entry.length] [l.entry [0].length];
	// It should check equal sizes
	// Let the compiler optimize
	for (int i = 0; i < l.entry.length; i++)
	    for (int j = 0; j < l.entry [i].length; j++)
		x [i] [j] = l.entry [i] [j] - r.entry [i] [j];
	return new Matrix (x);
    }
    /**
     *  Print this matrix (typically for debugging).
     */
    public void print () {
	for (int i = 0; i < entry.length; i++) {
	    for (int j = 0; j < entry [i].length; j++)
		System.out.printf ("%9.2f", entry [i] [j]);
	    System.out.println ();
	}
    }
}
