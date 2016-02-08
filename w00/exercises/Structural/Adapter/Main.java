import adapter.*;
// without the adapter, it would import "matrix"

/**
 *  This class is a client (in need of adaption) of a matrix
 *  manipulation package.
 */
public class Main {
    /**
     *  Standard entry point.  No argument is used.
     *  This program constructs two small matrices,
     *  computes both their addition and subtraction,
     *  and prints the resuls.
     */
    public static void main (String [] arg) {
	double [] [] e = {{1, 0}, {0, 1}},
		     f = {{0, 1}, {20, 3}};
        Matrix a = new Matrix (e);
        Matrix b = new Matrix (f);
	Matrix c = Matrix.add (a, b);
	c.print ();
	System.out.println ();
	Matrix d = Matrix.sub (a, b);
	d.print ();
    }
}
