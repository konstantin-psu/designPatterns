package tree;

/**
 *  This class implements the leaves of a binary tree.
 */

public class Leaf implements BinaryTree {
    private final static Leaf leaf = new Leaf ();
    /**
     *  Tests if this binary tree is a leaf.
     *  @return true.
     */
    public boolean isLeaf () { return true; }
    /**
     *  Compute the left child of this binary tree.
     *  @return never, it throws a RuntimeException.
     */
    public BinaryTree left () {
	throw new RuntimeException ("\"left()\" of empty tree");
    }
    /**
     *  Compute the right child of this binary tree.
     *  @return never, it throws a RuntimeException.
     */
    public BinaryTree right () {
	throw new RuntimeException ("\"right()\" of empty tree");
    }
    /**
     *  Compute the root of this binary tree.
     *  @return never, it throws a RuntimeException.
     */
    public Comparable root () {
	throw new RuntimeException ("\"root()\" of empty tree");
    }
    /**
     *  Construct a new tree which is the result of inserting of an element
     *  into in this binary tree.
     *  @param x The element to insert in a tree.
     *  @return A new tree representing this object with a new element
     *               inserted into it.
     */
    public BinaryTree insert (Comparable x) {
	return new Branch (x, leaf, leaf );
    }
    /**
     *  Pretty print this tree (nothing needs to be printed).
     *  @param level The print indentation level (ignored).
     */
    public void print (int level) {}
}
