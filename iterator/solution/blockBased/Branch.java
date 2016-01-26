package pattpack.tree_it;

/**
 *  This class implements the branches of a binary tree.
 */

public class Branch<E extends Comparable<E>> implements BinaryTree<E> {
    private E root;
    private BinaryTree<E> left;
    private BinaryTree<E> right;
    /**
     *  Construct a binary tree, a branch, that has the arguments
     *  as root, and left and right child respectively.
     *  @param root The root of the constructed tree.
     *  @param left The left child of the constructed tree.
     *  @param root The right child of the constructed tree.
     */
    public Branch (E root, BinaryTree<E> left, BinaryTree<E> right) {
	this.root = root;
	this.left = left;
	this.right = right;
    }
    /**
     *  Tests if this binary tree is a leaf.
     *  @return false.
     */
    public boolean isLeaf () { return false; }
    /**
     *  Compute the left child of this binary tree.
     *  @return the left child.
     */
    public BinaryTree<E> left () { return left; }
    /**
     *  Compute the right child of this binary tree.
     *  @return the right child.
     */
    public BinaryTree<E> right () { return right; }
    /**
     *  Compute the root of this binary tree.
     *  @return the root of this binary tree.
     */
    public E root () { return root; }
    /**
     *  Construct a new tree which is the result of inserting of an element
     *  into in this binary tree.
     *  @param x The element to insert in a tree.
     *  @return A new tree representing this object with a new element
     *               inserted into it.
     */
    public BinaryTree<E> insert (E x) {
	int tmp = x.compareTo (root);
	if (tmp < 0) return new Branch<E> (root, left.insert (x), right);
	else if (tmp == 0) return this;
	else return new Branch<E> (root, left, right.insert (x));
    }
    /**
     *  Pretty print this tree. Rotate 90 deg clockwise to look at the output.
     *  @param level The print indentation level of this branch's decoration.
     *               The user calls this method with level=0.
     */
    public void print (int level) {
	right.print (level+1);
	for (int i = 0; i < level; i++) System.out.print ("- ");
	System.out.println (root);
	left.print (level+1);
    }


    /**
     * Iterate over the decorations of the tree.
     * The decorations are produced in inorder.
     * @param block The consumer of a decoration being iterated over.
     */
    public void iterate(Block<E> block) {
	left.iterate(block);
	block.yield(root);
	right.iterate(block);
    }


}
