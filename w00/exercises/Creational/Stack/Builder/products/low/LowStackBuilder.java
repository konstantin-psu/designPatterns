package products.low;
import products.*;

/**
 * A "low" quality implementation of the abstract class StackBuilder.
 */

public class LowStackBuilder extends AbstractStackBuilder {
    // The stack currently built by this builder.
    private StackIF stack;
    // The size of stacks built by this builder.
    private int size;
    /**
     * Constructor of the stack builder.
     * @param size The size of stacks built by this builder.
     */
    public LowStackBuilder (int size) { this.size = size; }
    /**
     * Build a bounded stack.
     * The size is set by this class's constructor.
     */
    public void buildStack () { stack = new BoundedStack (size); }
    /**
     * Build an element and push it on the current stack.
     * @param i An integer to differentiate elements.
     */
    public void buildElement (int i) { stack.push (new SingleElement (i)); }
    /**
     * Return the current concrete stack under construction.
     * @return The concrete build by a concrete builder.
     */
    protected StackIF current () { return stack; }
}
