package products.high;
import products.*;

import java.util.EmptyStackException;

/**
 * "High" quality implementation of the StackIF interface.
 * The stacks provided by this class are unbounded.
 * Note that class and constructor are not public.
 */

class UnboundedStack implements StackIF {
    private static final int defaultSize = 10;
    private StackElementIF [] data = new StackElementIF [defaultSize];
    private int index = 0;
    /**
     * Push an element on this stack.
     * @param element The element to push on this stack.
     */
    public void push (StackElementIF element) {
	try { 
	    data [index] = element;
	} catch (IndexOutOfBoundsException ioob) {
	    StackElementIF [] tmp = new StackElementIF [2*data.length];
	    System.arraycopy (data, 0, tmp, 0, data.length);
	    data = tmp;
	    data [index] = element;
	}
	index++;
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
    public Object clone () { return new UnboundedStack (); }
}
