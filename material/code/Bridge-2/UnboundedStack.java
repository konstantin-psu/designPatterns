/**
 *  This class implements interface StackImpl
 *  with a stack represented by a linked list.
 */
public class UnboundedStack implements StackImpl {
    // nodes of the linked list
    private class Node { 
	private final int val; 
	private final Node next;
	private Node (int val, Node next) { this.val = val; this.next = next; }
    }
    // the linked list containing the stack elements
    private Node data;
    // the number of elements contained in the stack
    private int count = 0;
    /**
     *  Push an integer onto the stack.
     *  @param val The integer value pushed onto the stack.
     */
    public void push (int val) { 
	data = new Node (val, data);
	count++;
    }
    /**
     *  Pop the stack.
     *  @return The integer value popped from the stack.
     */
    public int pop () { 
	int val = data.val;
	data = data.next;
	--count;
	return val;
    }
    /**
     *  Return the number of elements contained in the stack.
     *  @return The number of elements contained in the stack.
     */
    public int size () { return count; }
}
