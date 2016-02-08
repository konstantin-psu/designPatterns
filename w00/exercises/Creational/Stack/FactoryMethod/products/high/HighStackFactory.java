package products.high;
import products.*;

/**
 * A "high" quality extension of the StackFactoryMethod class.
 */

public class HighStackFactory extends StackFactoryMethod {
    //    public HighStackFactory () {}
    /**
     * Build an unbounded stack.
     * @return The newly constructed stack.
     */
    public StackIF makeStack () { return new UnboundedStack (); }
    /**
     * Build an element to push on a stack.
     * @param i An integer to differentiate elements.
     */
    public StackElementIF makeElement (int i) { return new DoubleElement (i); }
}
