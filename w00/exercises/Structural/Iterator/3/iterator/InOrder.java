package iterator;

import tree.*;
import java.util.*;

/**
 *  This class provides an enumerator of the elements of a tree.
 *  The elements are enumerated in "in-order": first all the elements
 *  of the tree's left child are (recursively) enumerated, then
 *  the root of the tree is returned; finally all the elements
 *  of the tree's right child are (recursively) enumerated.
 *  <P>
 *  This class implements the iterator using a thread, see the description
 *  of the run method.  If the thread is interrupted, there is no
 *  way to return meaningful values from methods hasMoreElements
 *  and nextElement.  In this case, exception IllegalStateException
 *  is thrown.
 */

public class InOrder implements Enumeration, Runnable {

    private static final IllegalStateException bad
	= new IllegalStateException ("Interrupted when waiting");
    private Object current;
    private boolean more;
    private BinaryTree tree;
    private Thread thread;

    // Variables "more" and "current" are initialized by method "traverse".
    // Method "traverse" is called by method "run".
    // One cannot know when or even if method run executes,
    // since method "start" does not make any guarantees
    // that method "run" will execute shortly or ever.
    // 
    // Thus calling this iterator's methods "hasMoreElements" and
    // "nextElement" would produce incorrect results if method 
    // "traverse" has not begun execution.
    // 
    // Variable "initialized" is set in method "run" which
    // cannot be held until method "traverse" initializes
    // both variables "more" and "current".

    private boolean initialized = false;

    /**
     *  Constructs an enumerator of the argument's elements.
     *  @param tree The tree whose elements will be enumerated.
     */
    public InOrder (BinaryTree tree) {
	this.tree = tree;
	// the constructor is an initializer, so I use "this"
	thread = new Thread (this);
	thread.setPriority (Thread.MAX_PRIORITY);
	thread.start ();
    }

    /**
     *  Tests if this enumeration contains more elements.
     *  @return true if and only if this enumeration object
     *          contains at least one more element to provide;
     *          false otherwise.
     */
    public synchronized boolean hasMoreElements () {
	try { while (! initialized) wait (); }
        catch (InterruptedException e) { throw bad; }
	return more;
    }

    /**
     *  Returns the next element of this enumeration if
     *  this enumeration object has at least one more element to provide.
     *  @return the next element of this enumeration.
     *  @exception NoSuchElementException if no more elements exist.
     */
    public synchronized Object nextElement () { 
	try { while (! initialized) wait (); }
	catch (InterruptedException e) { throw bad; }
	if (more) {
	    Object tmp = current;
	    notify ();
	    return tmp;
	} else throw new NoSuchElementException ();
    }

    /**
     *  This iterator is based on a thread.  The thread <EM>run</EM>
     *  method executes a tree (inorder) traversal.  After the traversal
     *  produces an element, the thread waits for a consumer
     *  to call <EM>nextElement</EM>, which in turn notifies that 
     *  another element may be produced.
     */
    public synchronized void run () {
	initialized = true;
	notify ();             // some thread may be waiting on "initialized"
	more = true;           // tentative
	traverse (tree);
	more = false;
    }

    private void traverse (BinaryTree tree) {
	if (tree.isLeaf ()) return;
	else {
	    traverse (tree.left ());
	    current = tree.root ();
	    try { wait (); }
	    catch (InterruptedException e) { throw bad; }
	    traverse (tree.right ());
	}
    }
}
