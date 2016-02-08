package products.high;
import products.*;

/**
 * Implementation of a stack element.
 * Elements are objects holding two integers.
 * Note that class and constructor are not public.
 */
class DoubleElement implements StackElementIF {
    private int first, second;
    DoubleElement (int i) { first = i; second = i*2+1; }
    /**
     * Printable representation of this stack element.
     * @return The printable representation of this object.
     */
    public String toString () { return "["+first+","+second+"]"; }
}
