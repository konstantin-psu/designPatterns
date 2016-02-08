import products.*;
import products.low.*;
import products.high.*;

/**
 * Client (convenionally called director) of the Builder pattern.
 */

public class Director {
    /**
     * Program entry point.
     * Construct and exercise a stack.  31 elements are pushed into it.
     * @param arg Command line arguments.
     *            No arguments means high-quality builder.
     *            One argument means low-quality builder.
     *            The argument, an integer, is the size of the stack.
     */
    public static void main (String [] arg) {
	AbstractStackBuilder builder = null;
	// Select the builder from the first command line argument
	if (arg.length == 0) {
	    // High quality builder: unbounded stack, double elements
	    builder = new HighStackBuilder ();
	} else {
	    try {
		// Low quality builder: bounded stack, single elements
		builder = new LowStackBuilder (
                             new Integer (arg [0]).intValue ());
	    } catch (NumberFormatException nf) {
		System.err.println ("Bad stack size: "+arg [0]);
		System.exit (1);
	    }
	}
	tester (builder);
    }
    /**
     * Construct a stack and print it.
     * It is static so it can be directly called by main.
     */
    private static void tester (AbstractStackBuilder builder) {
	// Build the stack
	StackIF stack = AbstractStackBuilder.getStack (builder);
	System.out.println (stack);
    }
}
