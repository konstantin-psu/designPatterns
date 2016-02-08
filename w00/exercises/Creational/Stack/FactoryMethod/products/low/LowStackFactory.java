package products.low;
import products.*;

/**
 * A "low" quality extension of the StackFactoryMethod class.
 */

public class LowStackFactory extends StackFactoryMethod {
    private int size;
    /**
     * Constructor of the stack makeer.
     * @param size The size of stacks built by this makeer.
     */
    public LowStackFactory (int size) { this.size = size; }
    /**
     * Build a bounded stack.
     * The size is set by this class's constructor.
     * @return The newly constructed stack.
     */
    public StackIF makeStack () { return new BoundedStack (size); }
    /**
     * Build an element to push on a stack.
     * @param i An integer to differentiate elements.
     */
    public StackElementIF makeElement (int i) { return new SingleElement (i); }
}
