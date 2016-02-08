package products.high;
import products.*;

/**
 * Implementation of a stack element.
 * Elements are objects holding two integers.
 * Note that class and constructor are not public.
 */
class DoubleElement implements StackElementIF {
    private int first, second;
    DoubleElement (int i) { initialize (i); }
    /**
     * Printable representation of this stack element.
     * @return The printable representation of this object.
     */
    public String toString () { return "["+first+","+second+"]"; }
    /**
     * Initialize this stack element.
     * @param i An initializer to differentiate elements.
     */
    public void initialize (int i) { first = i; second = i*2+1; }
    /**
     * Clone this stack element.
     * @return A clone of this stack element.
     */
    public Object clone () { return new DoubleElement (first); }
}
