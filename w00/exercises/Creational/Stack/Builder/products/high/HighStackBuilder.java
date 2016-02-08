package products.high;
import products.*;

/**
 * A "high" quality implementation of the abstract class StackBuilder.
 */

public class HighStackBuilder extends AbstractStackBuilder {
    // The stack currently built by this builder.
    private StackIF stack;
    //    public HighStackBuilder () {}
    /**
     * Build an unbounded stack.
     */
    public void buildStack () { stack = new UnboundedStack (); }
    /**
     * Build an element to push on a stack.
     * @param i An integer to differentiate elements.
     */
    public void buildElement (int i) { stack.push (new DoubleElement (i)); }
    /**
     * Return the current concrete stack under construction.
     * @return The concrete build by a concrete builder.
     */
    protected StackIF current () { return stack; }
}
