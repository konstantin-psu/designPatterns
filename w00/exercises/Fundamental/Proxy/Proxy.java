import java.rmi.*;

/**
 *  This class implements a proxy of the remote calculator.
 */

class Proxy implements CalculatorIF {

    // meant to run on the server's host
    // syntax for other hosts is, e.g., "//graystar.cs.pdx.edu/calculator"
    private static final String name = "calculator";
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
     * The modifier must be public, since it implements an interface method.
     * @param x Left operand
     * @param x Right operand
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
