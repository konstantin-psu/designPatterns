package tree;
/** 
 *  This interface defines simple-minded binary (search) trees.
 *  Only the most elementary methods are defined.
 *  The interface exists for the implementation of an exercise
 *  about an Iterator pattern.
 *  <P>
 *  A binary tree is either a Leaf or Branch.
 *  Branches are decorated by an Object,
 *  and have a left and right child, that are binary trees.
 *  Leaves have no decorations or children. 
 */

public interface BinaryTree {
    /**
     *  Tests if this binary tree is a leaf.
     *  @return true if this object is a leaf.
     */
    boolean isLeaf ();
    /**
     *  Compute the left child of this binary tree.
     *  @return true the left child of this binary tree.
     */
    BinaryTree left ();
    /**
     *  Compute the right child of this binary tree.
     *  @return true the right child of this binary tree.
     */
    BinaryTree right ();
    /**
     *  Compute the decoration of this binary tree.
     *  @return true the decoration, if any, of this binary tree.
     */
    Comparable root ();
    /**
     *  Construct a new tree which is the result of inserting of an element
     *  into in this binary tree.
     *  Elements are inserted in such a way that:
     *  <UL>
     *  <LI> Elements in a tree are unique.
     *       Inserting an element that is already in a tree has no effect.
     *  <LI> Every element in the left child of a branch precedes the branch's decoration.
     *  <LI> Every element in the right child of a branch follows the branch's decoration.
     *  </UL>
     *  @param x The element to insert in a tree.
     *  @return A new tree representing this object with a new element
     *               inserted into it.
     */
    BinaryTree insert (Comparable x);
    /**
     *  Pretty print this tree. Rotate 90 deg clockwise to look at the output.
     *  @param level The print indentation level of this branch's decoration.
     *               The user calls this method with level=0.
     */
    void print (int level);
}

