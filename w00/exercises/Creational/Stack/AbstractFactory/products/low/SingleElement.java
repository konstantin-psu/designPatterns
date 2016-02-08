package products.low;
import products.*;

/**
 * Implementation of a stack element.
 * Elements are objects holding an integer.
 * Note that class and constructor are not public.
 */
class SingleElement implements StackElementIF {
    private int value;
    SingleElement (int i) { value = i; }
    /**
     * Printable representation of this stack element.
     * @return The printable representation of this object.
     */
    public String toString () { return "" + value; }
}
