/**
 *  Implementation of a linked list.
 *  A linked list is either "null" or a "List" consisting
 *  of a head (an Object) and a tail (a linked list).
 */
public class List {
    private Object head;
    private List tail;
    /**
     * Compute the length of this list.
     * @return The length of this list (always a positive value).
     */ 
    public int length () { 
	if (tail == null) return 1;
	else return 1+tail.length ();
    }
    /**
     * Compute the head of this list.
     * @return The head of this list.
     */ 
    public Object head () { return head; }
    /**
     * Compute the tail of this list.
     * @return The tail of this list.
     */ 
    public List tail () { return tail; }
    /**
     * Replace the content of this list.
     * @param head The new head of this list.
     * @param tail The new tail of this list.
     */
    public void reset (Object head, List tail) {
	this.head = head;
	this.tail = tail;
    }
}
