package iterator;

import tree.*;
import java.util.*;

/**
 *  This class provides an enumerator of the elements of a tree.
 *  The elements are enumerated in "in-order": first all the elements
 *  of the tree's left child are (recursively) enumerated, then
 *  the root of the tree is returned; finally all the elements
 *  of the tree's right child are (recursively) enumerated.
 */

public class InOrder implements Enumeration {
    private class Tagger {
	private boolean goLeft = true;
	private BinaryTree tree;
	private Tagger (BinaryTree tree) { this.tree = tree; }
    }
    private Stack stack = new Stack ();
    private Object current;
    private boolean more;
    /**
     *  Constructs an enumerator of the argument's elements.
     *  @param tree The tree whose elements will be enumerated.
     */
    public InOrder (BinaryTree tree) {
	stack.push (new Tagger (tree));
	doit ();
    }
    /**
     *  Tests if this enumeration contains more elements.
     *  @return true if and only if this enumeration object
     *          contains at least one more element to provide;
     *          false otherwise.
     */
    public boolean hasMoreElements () { return more; }
    /**
     *  Returns the next element of this enumeration if
     *  this enumeration object has at least one more element to provide.
     *  @return the next element of this enumeration.
     *  @exception NoSuchElementException if no more elements exist.
     */
    public Object nextElement() { 
	if (more) {
	    Object tmp = current;
	    doit ();
	    return tmp;
	} else throw new NoSuchElementException ();
    }
    // This method maintains the values that the interface methods return.
    // It should be called by the constructor and after an element of the
    // iteration is returned.
    //
    // Get the first branch on the stack.  If there are none, the
    // enumeration is over.  If the branch's left child has not yet
    // been enumerated, push its left child on the stack and mark
    // the branch that the left child has been enumrarated, then
    // repeat for the left child. If the branch's left child has been
    // enumerated, replace the branch with its right child and
    // set the branch's root to be the next element.
    private void doit () {
	while (! stack.isEmpty ()) {
	    Tagger tagger = (Tagger) stack.peek ();
	    if (tagger.tree.isLeaf ()) {
		stack.pop ();
	    } else if (tagger.goLeft) {
		tagger.goLeft = false;
		stack.push (new Tagger (tagger.tree.left ()));
	    } else {
		stack.pop ();
		stack.push (new Tagger (tagger.tree.right ()));
		more = true;
		current = tagger.tree.root ();
		return;
	    }
	}
	more = false;
    }
}
