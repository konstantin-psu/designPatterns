package products.low;
import products.*;

/**
 * Implementation of a stack element.
 * Elements are objects holding an integer.
 * Note that class and constructor are not public.
 */
class SingleElement implements StackElementIF {
    private int value;
    SingleElement (int i) { initialize (i); }
    /**
     * Printable representation of this stack element.
     * @return The printable representation of this object.
     */
    public String toString () { return "" + value; }
    /**
     * Initialize this stack element.
     * @param i An initializer to differentiate elements.
     */
    public void initialize (int i) { value = i; }
    /**
     * Clone this stack element.
     * @return A clone of this stack element.
     */
    public Object clone () { return new SingleElement (value); }
}
