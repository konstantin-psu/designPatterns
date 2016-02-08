package products;

/**
 * This is primordial class of a Prototype Factory of Stacks.
 */
public class StackPrototypeFactory {
    private StackIF stack;
    private StackElementIF element;
    /**
     *  The constructor stores internally prototypes
     *  of a product's components.
     *  @param stack The stack prototype.
     *  @param element The stack's element prototype.
     */
    public StackPrototypeFactory (StackIF stack, StackElementIF element) {
	this.stack = stack;
	this.element = element;
    }
    /**
     * Build a stack.
     * @return A newly constructed stack.
     */
    public StackIF createStack () { return (StackIF) stack.clone (); }
    /**
     * Build a stack element.
     * @param i An argument for createing the element
     * @return A newly constructed stack element.
     */
    public StackElementIF createElement (int i) {
	StackElementIF element = (StackElementIF) this.element.clone ();
	element.initialize (i);
	return element;
    }
}
