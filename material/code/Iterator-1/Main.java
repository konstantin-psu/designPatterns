import pattpack.tree.*;
import iterator.*;
import java.util.Enumeration;

/**
 *  This class is a test harness for a tree iterator.
 */
public class Main {
    /**
     *  Standard entry point.  No argument is used.
     *  This program constructs a binary search tree from internal data
     *  and uses an iterator to print the tree's content.
     *  Three elements per line are printed.
     */
    public static void main (String [] arg) {
	int [] testdata = { 25, 40, 35, 30, 10, 20, 15, 50, 45, };
	BinaryTree<Integer> tree = new Leaf<Integer>();
	for (int i = 0; i < testdata.length; i++)
	    tree = tree.insert (testdata [i]);
	//	tree.print (0);
	for (Enumeration<Integer> e = new InOrder<Integer> (tree); e.hasMoreElements (); ) {
	    for (int i = 0; i < 3; i++) {
		int x = e.nextElement ();
		System.out.printf ("%5d", x);
	    }
	    System.out.println ();
	}
    }
}
