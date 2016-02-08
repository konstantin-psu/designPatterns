package products.low;
import products.*;

import java.util.EmptyStackException;

/**
 * "Low" quality implementation of the StackIF interface.
 * The stacks provided by this class have bouned size.
 * Note that class and constructor are not public.
 */

class BoundedStack implements StackIF {
    private StackElementIF [] data;
    private int index = 0;
    BoundedStack (int size) { data = new StackElementIF [size]; }
    /**
     * Push an element on this stack.
     * @param element The element to push on this stack.
     * @exception StackOverflowError Thown when the stack is full.
     */
    public void push (StackElementIF element) throws StackOverflowError {
	try { 
	    data [index++] = element;
	} catch (IndexOutOfBoundsException ioob) {
	    throw new StackOverflowError ();
	}
    }
    /**
     * Pop this stack.
     * @exception EmptyStackException Thown when the stack is empty.
     */
    public void pop () throws EmptyStackException {
	if (index <= 0) throw new EmptyStackException ();
	else --index;
    }
    /**
     * Compute the top of this stack.
     * @return The top element of this stack.
     * @exception EmptyStackException Thown when the stack is empty.
     */
    public StackElementIF top () throws EmptyStackException {
	if (index <= 0) throw new EmptyStackException ();
	else return data [index-1];
    }
    /**
     * Printable representation of this stack element.
     * @return The printable representation of this object.
     */
    public String toString () {
	// Let the compiler optimize.
	String result = "";
	for (int i = 0; i < index; i++) result = result + data [i];
	return result;
    }
    /**
     * Clone this stack.  The result is an EMPTY stack!
     * No elements are cloned.
     * @return A clone of this stack.
     */
    public Object clone () { return new BoundedStack (data.length); }
}
