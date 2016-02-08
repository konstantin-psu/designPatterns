import java.rmi.*;

/**
 *  This class implements a client of the remote calculator.
 */

public class Client {

    // meant to run on the server's host
    // syntax for other hosts is, e.g., "//graystar.cs.pdx.edu/calculator"
    private static final String name = "calculator";

    /**
     *  Usual main, no arguments accepted.
     *  Install security manager, lookup remote calculator,
     *  request an addition, and print the result.
     */
    public static void main (String args[]) {
	System.setSecurityManager (new RMISecurityManager ());
	try {
	    CalculatorIF calc = (CalculatorIF) Naming.lookup (name);
	    float result = calc.add (3.3f, 4.4f);
	    System.out.println ("Client: Calculator result: " + result);
	}
	catch (Exception e) {
	    System.out.println ("Client exception: " + e.getMessage ());
	    e.printStackTrace ();
	}
    }
}
