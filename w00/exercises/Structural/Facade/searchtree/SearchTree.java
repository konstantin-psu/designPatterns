package searchtree;

import tree.*;
import iterator.*;

/** 
 *  This class is a facade for packages tree and its inorder iterator.
 *  It also enforces the "searchness" of trees, i.e., the condition that,
 *  recursively, the decorations of the left child precedes the root and
 *  the root precedes the decorations of the right child.
 *  <P>
 *  The implementation has characteristics of Delegation
 *  (the class delegates most operations to class BinaryTree),
 *  Adapter (the class modifies the signature of some methods),
 *  and Proxy (the class performs similarly to BinaryTree,
 *  but hides some of its operations).
 */

public class SearchTree {
    private BinaryTree theTree;
    /**
     *  Construct a search tree with no decorations.
     */
    public SearchTree () { theTree = new Leaf (); }
    /**
     *  Insert an element into in this search tree.
     *  Elements in a tree are unique.
     *  Inserting an element that is already in a tree has no effect.
     *  @param x The element to insert in a tree.
     */
    public void insert (Comparable x) { theTree = theTree.insert (x); }
    /**
     *  Pretty print this tree. Rotate 90 deg clockwise to look at the output.
     */
    public void print () { theTree.print (0); }
    /**
     *  Return an interator to enumerate this tree's elements in inorder.
     */
    public java.util.Enumeration elementsInOrder () { 
	return new InOrder (theTree);
    }
}

