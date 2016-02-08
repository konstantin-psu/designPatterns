import java.rmi.*;

/**
 *  This class implements a server of the remote calculator.
 */

public class Server {

    /**
     *  The name used by clients for locate the server on a network.
     */
    private static final String name = "calculator";

    /**
     *  Usual main, command line arguments are ignored.
     *  Install security manager, instantiate a calculator,
     *  bind it into the registry, print a message.
     *  @param ignore Ditto.
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
