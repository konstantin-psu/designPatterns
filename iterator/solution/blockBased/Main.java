import pattpack.tree_it.*;

/**
 *  This class is a test harness for a tree iteration
 *  in the style of Ruby and Python.
 *  It shows two iterarors, a simple one that prints all
 *  the values in a tree and a more complicated one that
 *  adds all the values in a tree and returns their sum.
 */
public class Main {
    /**
     *  Standard entry point.  No argument is used.
     *  This program constructs a binary search tree from internal data
     *  and exercises two iterators on the tree's content.
     */
    public static void main (String [] arg) {
	int [] testdata = { 25, 40, 35, 30, 10, 20, 15, 50, 45, };
	BinaryTree<Integer> tree = new Leaf<Integer>();
	for (int i = 0; i < testdata.length; i++)
	    tree = tree.insert (testdata [i]);
	// tree.print (0);

	tree.iterate(new Block<Integer>() {
		public void yield(Integer e) { System.out.println(e); }
            });

	// an iterartor block to add all the values in a tree
	class AdderBlock implements Block<Integer> {
	    public int sum = 0;
	    public void yield(Integer e) { sum += e; }
	}
	AdderBlock adder = new AdderBlock();
	tree.iterate(adder);
	System.out.println("The sum is: "+adder.sum);
    }
}
