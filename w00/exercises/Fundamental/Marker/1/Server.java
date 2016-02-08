import java.rmi.*;

/**
 *  This class implements a server of the remote calculator.
 */

public class Server {

    // meant to run on the server's host
    // syntax for other hosts is, e.g., "//graystar.cs.pdx.edu/calculator"
    private static final String name = "calculator";

    /**
     *  Usual main, no arguments accepted.
     *  Install security manager, instantiate a calculator,
     *  bind it into the registry, print a message.
     */
    public static void main (String args[]) {
	if (System.getSecurityManager () == null) {
	    System.setSecurityManager (new RMISecurityManager ());
	}
	try {
	    Calculator calc = new Calculator ();
	    Naming.rebind (name, calc);
	    System.out.println ("Server: Calculator bound");
	} catch (Exception e) {
	    System.err.println ("Server exception: " + e.getMessage ());
	    e.printStackTrace ();
	}
    }
}    
