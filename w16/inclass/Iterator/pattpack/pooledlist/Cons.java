package pattpack.pooledlist;

/**
 * Implementation of a non-empty list (a cons).
 */
public class Cons<E> extends List<E> {
    private E head;
    private List<E> tail;
    /**
     *  Construct a Cons with the give arguments
     *  @param head the head of the constructed list
     *  @param tail the tail of the constructed list
     */
    public Cons (E head, List<E> tail) {
	this.head = head;
	this.tail = tail;
    }
    /**
     * Compute the length of this list.
     * @return The length of this list (always a positive value).
     */ 
    public int length () { return 1+tail.length (); }
    /**
     * Tell whether this list contains any object.
     * @return The boolean value true.
     */ 
    public boolean isEmpty () { return false; }
    /**
     * Compute the head of this list.
     * @return The head of this list.
     */ 
    public E head () { return head; }
    /**
     * Compute the tail of this list.
     * @return The tail of this list.
     */ 
    public List<E> tail () { return tail; }
    /**
     * Replace the content of the cons of this list.
     * @param head The new head of the cons. 
     * @param tail The new tail of the cons. 
     */
    void reset (E head, List<E> tail) {
	this.head = head;
	this.tail = tail;
    }
}
