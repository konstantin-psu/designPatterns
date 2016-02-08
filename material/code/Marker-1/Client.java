import java.rmi.*;

/**
 *  This class implements a client of the remote calculator.
 */

public class Client {

    /**
     *  The name of the server, e.g., "//graystar.cs.pdx.edu/calculator"
     *  or simply "calculator" if the client executes on the server's host.
     *  Used to lookup the server on a network.
     */
    private static final String name = "calculator";

    /**
     *  Usual main, command line arguments are ignored.
     *  Install security manager, lookup remote calculator,
     *  request an addition, and print the result.
     *  @param ignore Ditto.
     */
    public static void main (String [] ignore) {
	System.setSecurityManager (new RMISecurityManager ());
	try {
	    CalculatorIF calc = (CalculatorIF) Naming.lookup (name);
	    float result = calc.add (3.3f, 4.4f);
	    System.out.println ("Client: Calculator result: " + result);
	}
	catch (Exception e) {
	    System.err.println ("Client exception: " + e.getMessage ());
	    e.printStackTrace ();
	}
    }
}
