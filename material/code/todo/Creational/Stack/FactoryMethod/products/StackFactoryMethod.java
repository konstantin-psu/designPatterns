package products;

/**
 * This is the simplest class implementing a Stack factory method.
 */
public class StackFactoryMethod {
    /**
     * Build a stack.
     * @return A newly constructed null stack.
     */
    public StackIF makeStack () { return null; }
    /**
     * Build a stack element.
     * @param i An argument for makeing the element
     * @return A newly constructed null stack element.
     */
    public StackElementIF makeElement (int i) { return null; }
    /**
     * Tester.
     */
    public final void tester () {
	StackIF stack = makeStack ();
	try {
	    // Fill the stack with up to 31 elements.
	    // A bounded stack of smaller size will overflow.
	    for (int i = 0; i < 30; i++) {
		StackElementIF element = makeElement (i);
		stack.push (element);
		stack.push (element);
		System.out.println (stack.top ());
		stack.pop ();
	    }
	} catch (Exception e) {
	    System.err.println ("Exception: "+e.getMessage());
	    e.printStackTrace ();
	}
    }
}
