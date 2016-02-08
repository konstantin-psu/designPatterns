package products.low;
import products.*;

/**
 * A "low" quality implementation of the StackPrototypeFactory.
 */

public class LowStackPrototype extends StackPrototypeFactory {
    /**
     * Constructor of the stack prototype.
     * @param size The size of stacks built by this prototype.
     */
    public LowStackPrototype (int size) {
	super (new BoundedStack (size), new SingleElement (0));
    }
}
