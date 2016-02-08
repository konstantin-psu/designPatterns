import sort.*;
import java.util.*;
import java.text.*;

/**
 *  This program is a driver to experiment with sorting algorithms.
 *  It constructs a random array of java.util.Comparable objects and
 *  then it times various algorithms to sort the array.
 */
public class Main {
    // The size of benchmark arrays
    private final int size = 50000;
    private final int NUMTEST = 500;

    // We measure all times relative to the beginning of the execution
    private long elapsed = System.currentTimeMillis ();
    private long now () { return System.currentTimeMillis () - elapsed; }

    // Generation of random numbers in a certain range
    private java.util.Random random = new java.util.Random (0);
    private int random (int low, int high) {
	int tmp = Math.abs (random.nextInt ()) % (high - low) + low;
	// System.out.println (tmp);
	return tmp;
    }

    private DecimalFormat df = new DecimalFormat ("  000");
    private void print (Integer [] data) {
	for (int i = 0; i < data.length; i++) {
	    System.out.print (df.format (data [i].intValue ()));
	    if ((i+1) % 10 == 0) System.out.println ();
	}
	System.out.println ();
    }

    // Create and start the monkeys and the tree.
    private void main () {
	// Create a benchmark array
	Integer [] proto = new Integer [size];
	for (int k = 0; k < NUMTEST; k++) {
	    // sentinel
	    proto [0] = new Integer (0);
	    for (int i = 1; i < size; i++)
		proto [i] = new Integer (random (0, 400));
	    // print (proto);

	    Integer [] tmp = new Integer [size];
	    SortIF [] Sorter = {
		// new SelectionSort (),            // too slow for large arrays
		new QuickSort (),
		new Strategy (),
	    };
	    for (int i = 0; i < Sorter.length; i++) {
		System.arraycopy (proto, 0, tmp, 0, size);
		long duration = now ();
		Sorter [i].sort (tmp, 0, size-1);
		duration = now () - duration;
		System.out.println ("Elapsed time "+duration+" msec "+
				    Sorter [i].info ());
	    }
	    System.out.println ();
	    //	    print (tmp);
	}
    }

    /**
     *  Usual entry.
     *  @param ignore Ditto.
     */
    public static void main (String [] ignore) { (new Main ()).main (); }
}


