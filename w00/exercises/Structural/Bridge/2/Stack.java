/**
 *  This class provides a stack that changes implementation dynamically.
 *  Initially, the implementation is an array of integers.
 *  If, during the execution of a client, the stack overflows,
 *  the array implementation is replaced by a linked list implementation.
 */
public class Stack {
    // the initial implementation of the stack
    private StackImpl stack = new FixedStack ();
    /**
     *  Push an integer onto the stack.
     *  @param val The integer value pushed onto the stack.
     */
    public void push (int val) {
	try { stack.push (val); }
	catch (ArrayIndexOutOfBoundsException ex) {
	    StackImpl unbounded = new UnboundedStack ();
	    copy (stack, unbounded);
	    stack = unbounded;
	}
    }
    /**
     *  Pop the stack.
     *  @return The integer value popped from the stack.
     */
    int pop () { return stack.pop (); }
    /**
     *  Return the number of elements contained in the stack.
     *  @return The number of elements contained in the stack.
     */
    int size () { return stack.size (); }

    // copy stack "from" into "to"; stack "from" is emptied
    // this recursive design is inefficient for large stacks
    private void copy (StackImpl from, StackImpl to) {
	int val = from.pop ();
	if (from.size () > 0) copy (from, to);
	to.push (val);
    }
}
