import searchtree.*;
import java.util.Enumeration;

/**
 *  This class is a test harness for a facade.
 */
public class Main {
    /**
     *  Standard entry point.  No argument is used.
     *  This program constructs a search tree from internal data
     *  and uses an iterator to print the tree's content.
     *  Three elements per line are printed.
     */
    public static void main (String [] arg) {
	int [] testdata = { 25, 40, 35, 30, 10, 20, 15, 50, 45, };
	SearchTree tree = new SearchTree ();
	for (int i = 0; i < testdata.length; i++)
	    tree.insert (new Integer (testdata [i]));
	// tree.print ();
	for (Enumeration e = tree.elementsInOrder (); e.hasMoreElements (); ) {
	    for (int i = 0; i < 3; i++) {
		Integer x = (Integer) e.nextElement ();
		System.out.print ("   "+x);
	    }
	    System.out.println ();
	}
    }
}
