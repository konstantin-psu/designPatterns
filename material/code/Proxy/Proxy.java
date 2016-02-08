import java.rmi.*;

/**
 *  This class implements a proxy of the remote calculator.
 */

class Proxy implements CalculatorIF {

    /**
     *  The name of the server, e.g., "//graystar.cs.pdx.edu/calculator"
     *  or simply "calculator" if the client executes on the server's host.
     *  Used to lookup the server on a network.
     */
    private static final String name = "calculator";
    /** The object this class proxies for. */
    private CalculatorIF calc;

    /**
     *  Constructor.
     *  Install a security manager and lookup the remote calculator.
     */
    Proxy () { 
	System.setSecurityManager (new RMISecurityManager ());
	try { calc = (CalculatorIF) Naming.lookup (name); }
	catch (Exception e) {
	    System.out.println ("Client exception: " + e.getMessage ());
	    e.printStackTrace ();
	}
    }

    /**
     * Addition method.
     * @param x Left operand.
     * @param y Right operand.
     * @return the sum of x and y.
     */
    public float add (float x, float y) {
	try { return calc.add (x, y); }
	catch (Exception e) {
	    System.out.println ("Client exception: " + e.getMessage ());
	    e.printStackTrace ();
	    return Float.NaN;
	}
    }
}
