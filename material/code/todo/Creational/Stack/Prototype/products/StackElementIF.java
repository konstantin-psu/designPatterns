package products;

/**
 * Interface defining stack elements.
 */

public interface StackElementIF extends Cloneable {
    /**
     * Initialize this stack element.
     * @param i An initializer to differentiate elements.
     */
    public void initialize (int i);
    /**
     * Clone this stack element.
     * @return A clone of this stack element.
     */
    public Object clone ();
}

