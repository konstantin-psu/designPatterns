import products.*;
import products.low.*;
import products.high.*;

/**
 * Client of the Prototype pattern.
 */

public class Client {
    /**
     * Program entry point.
     * @param arg Command line arguments.
     *            No arguments means high-quality prototype.
     *            One argument means low-quality prototype.
     *            The argument, an integer, is the size of the stack.
     */
    public static void main (String [] arg) {
	StackPrototypeFactory prototype = null;
	// Select the prototype from a command line argument
	if (arg.length == 0) {
	    // High quality prototype: unbounded stack, double elements
	    prototype = new HighStackPrototype ();
	} else {
	    try {
		// Low quality prototype: bounded stack, single elements
		prototype = new LowStackPrototype (
                             new Integer (arg [0]).intValue ());
	    } catch (NumberFormatException nf) {
		System.err.println ("Bad stack size: "+arg [0]);
		System.exit (1);
	    }
	}
	tester (prototype);
    }
    /**
     * Construct a stack and print it.
     * It is static so it can be directly called by main.
     */
    private static void tester (StackPrototypeFactory prototype) {
	// Build the stack
	StackIF stack = prototype.createStack ();
	try {
	    // Fill the stack with up to 31 elements.
	    // A bounded stack of smaller size will overflow.
	    for (int i = 0; i < 30; i++) {
		StackElementIF element = prototype.createElement (i);
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
