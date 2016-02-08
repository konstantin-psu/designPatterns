import products.*;
import products.low.*;
import products.high.*;

/**
 * Client of the AbstractFactory pattern.
 */

public class Client {
    /**
     * Program entry point.
     * @param arg Command line arguments.
     *            No arguments means high-quality factory.
     *            One argument means low-quality factory.
     *            The argument, an integer, is the size of the stack.
     */
    public static void main (String [] arg) {
	AbstractStackFactoryIF factory = null;
	// Select the factory from a command line argument
	if (arg.length == 0) {
	    // High quality factory: unbounded stack, double elements
	    factory = new HighStackFactory ();
	} else {
	    try {
		// Low quality factory: bounded stack, single elements
		factory = new LowStackFactory (
                             new Integer (arg [0]).intValue ());
	    } catch (NumberFormatException nf) {
		System.err.println ("Bad stack size: "+arg [0]);
		System.exit (1);
	    }
	}
	tester (factory);
    }
    /**
     * Construct a stack and print it.
     * It is static so it can be directly called by main.
     */
    private static void tester (AbstractStackFactoryIF factory) {
	// Build the stack
	StackIF stack = factory.createStack ();
	try {
	    // Fill the stack with up to 31 elements.
	    // A bounded stack of smaller size will overflow.
	    for (int i = 0; i < 30; i++) {
		StackElementIF element = factory.createElement (i);
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
