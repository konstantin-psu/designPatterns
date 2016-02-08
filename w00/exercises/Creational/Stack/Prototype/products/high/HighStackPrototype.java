package products.high;
import products.*;

/**
 * A "high" quality implementation of the StackPrototypeFactory.
 */

public class HighStackPrototype extends StackPrototypeFactory {
    /**
     * Constructor of the stack prototype.
     */
    public HighStackPrototype () {
	super (new UnboundedStack (), new DoubleElement (0));
    }
}
