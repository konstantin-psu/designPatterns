import java.util.Enumeration;
import java.util.NoSuchElementException;

/**
 * Instances of this class are nodes of a linked list.
 *<p>
 * A linked list is a chain of objects that have two object references
 * associated with them.  One is the head of the list, which is another
 * data object.  The other is the tail of the list, which is either null
 * or another linked list.
 */
public class LinkedList implements Cloneable, java.io.Serializable {
    private Object head;
    private LinkedList tail;
    private boolean traversed = false; // true when this noed is being
                                       // traversed 

    /**
     * This constructor creates a LinkedList with a null head and a null
     * tail. 
     */
    public LinkedList() {
        this(null, null);
    } // constructor()

    /**
     * This constructor creates a LinkedList with the given head and a
     * null tail.
     * @param head The object that will be the head of this list
     */
    public LinkedList(Object head) {
        this(head, null);
    } // constructor(LinkedList)
    
    /**
     * This constructor creates a LinkedList with the given head and
     * tail.
     * @param head The object that will be the head of this list
     * @param tail null or the rest of this linked list.
     */
    public LinkedList(Object head, LinkedList tail) {
        this.head = head;
        this.tail = tail;
    } // constructor(LinkedList)

    /**
     * Return the head of this linked list.
     */
    public Object getHead() {
        return head;
    } // getHead()

    /**
     * Return the tail of this linked list.
     */
    public LinkedList getTail() {
        return tail;
    } // getTail()

    /**
     * Return the number of nodes in this linked list
     */
    synchronized public int size() {
        if (tail == null)
          return 1;
        try {
            traversed = true;
            if (tail.traversed)
              return 1;
            return 1 + tail.size();
        } finally {
            traversed = false;
        } // try
    } // size()

    /**
     * Return an Enumeration of the data in this linked list (the
     * heads).
     */
    public Enumeration elements() {
        return new ListEnumeration();
    } // elements()

    /**
     * private class to enumerate data of a linked list.
     */
    private class ListEnumeration implements Enumeration {
        private LinkedList thisNode = LinkedList.this;

        /**
         * Tests if this enumeration contains more elements.
         * @return  <code>true</code> if this enumeration contains more
         *          elements; 
         */
        public boolean hasMoreElements() {
            return thisNode != null;
        } // hasMoreElements()

        /**
         * Returns the next element of this enumeration.
         * @return     the next element of this enumeration. 
         * @exception  NoSuchElementException  if no more elements exist.
         */
        public Object nextElement() {
            if (thisNode == null)
              throw new NoSuchElementException();
            Object next = thisNode.head;
            thisNode = thisNode.tail;
            return next;
        } // nextElement()
    } // class ListEnumeration

    /**
     * Find an object in a linked list that is equal to the given
     * object. Equality is normally determined by calling the given
     * object's equals method.  However, if the given object implements
     * the EqualByIdentity interface, then equality will be determined
     * by the ==  operator.
     * @params target The object to search for.
     * @return a LinkedList whose head is equal to the given object or
     *         null if the target is not found.
     */
    public LinkedList find(Object target) {
        if (target == null || target instanceof EqualByIdentity)
          return findEq(target);
        else
          return findEquals(target);
    } // find(Object)

    /**
     * Find an object in a linked list that is equal to the given
     * object. Equality is determined by the == operator.
     * @params target The object to search for.
     * @return a LinkedList whose head is equal to the given object.
     */
    private synchronized LinkedList findEq(Object target) {
        if (head == target)
          return this;
        if (tail == null)
          return null;
        try {
            traversed = true;
            if (tail.traversed)
              return null;
            return tail.findEq(target);
        } finally {
            traversed = false;
        } // try
    } // find(Object)

    /**
     * Find an object in a linked list that is equal to the given
     * object. Equality is determined by calling the given
     * object's equals method.
     * @params target The object to search for.
     * @return a LinkedList whose head is equal to the given object.
     */
    private synchronized LinkedList findEquals(Object target) {
        if (head.equals(target))
          return this;
        if (tail == null)
          return null;
        try {
            traversed = true;
            if (tail.traversed)
              return null;
            return tail.findEquals(target);
        } finally {
            traversed = false;
        } // try
    } // find(Object)
} // class LinkedList
