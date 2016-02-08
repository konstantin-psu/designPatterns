package products.low;
import products.*;

/**
 * A "low" quality implementation of the AbstractStackFactoryIF interface.
 */

public class LowStackFactory implements AbstractStackFactoryIF {
    private int size;
    /**
     * Constructor of the stack createer.
     * @param size The size of stacks built by this createer.
     */
    public LowStackFactory (int size) { this.size = size; }
    /**
     * Build a bounded stack.
     * The size is set by this class's constructor.
     * @return The newly constructed stack.
     */
    public StackIF createStack () { return new BoundedStack (size); }
    /**
     * Build an element to push on a stack.
     * @param i An integer to differentiate elements.
     */
    public StackElementIF createElement (int i) { return new SingleElement (i); }
}
