package products;

/**
 * This is the interface of a Factory of Stacks.
 */
public interface AbstractStackFactoryIF {
    /**
     * Build a stack.
     * @return A newly constructed stack.
     */
    public StackIF createStack ();
    /**
     * Build a stack element.
     * @param i An argument for createing the element
     * @return A newly constructed stack element.
     */
    public StackElementIF createElement (int i);
}
