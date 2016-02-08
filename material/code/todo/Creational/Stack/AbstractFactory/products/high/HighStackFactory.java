package products.high;
import products.*;

/**
 * A "high" quality implementation of the AbstractStackFactoryIF interface.
 */

public class HighStackFactory implements AbstractStackFactoryIF {
    //    public HighStackFactory () {}
    /**
     * Build an unbounded stack.
     * @return The newly constructed stack.
     */
    public StackIF createStack () { return new UnboundedStack (); }
    /**
     * Build an element to push on a stack.
     * @param i An integer to differentiate elements.
     */
    public StackElementIF createElement (int i) { return new DoubleElement (i); }
}
