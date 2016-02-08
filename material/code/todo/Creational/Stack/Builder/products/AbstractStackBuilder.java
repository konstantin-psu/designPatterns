package products;

/**
 * This is the abstract definition of a Builder of Stacks.
 */
public abstract class AbstractStackBuilder {
    /**
     * Build a stack.
     */
    public abstract void buildStack ();
    /**
     * Build a stack element.
     * @param i An argument for building the element.
     */
    public abstract void buildElement (int i);
    /**
     * Return the current concrete stack under construction.
     * @return The concrete build by a concrete builder.
     */
    protected abstract StackIF current ();
    /**
     * Build a concrete stack using a concrete builder
     * @param stackBuilder The concrete builder to build the stack.
     */
    public static StackIF getStack (AbstractStackBuilder builder) {
	builder.buildStack ();
	try {
	    for (int i = 0; i < 30; i++) builder.buildElement (i);
	} catch (Exception e) {
	    System.err.println ("Exception: "+e.getMessage());
	    e.printStackTrace ();
	}
	return builder.current ();
    }
}
