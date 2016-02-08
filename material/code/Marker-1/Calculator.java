import java.rmi.*;
import java.rmi.server.*;

/**
 *  This class implements the operations of a pocket calculator.
 *  It is designed in such a way that the operations can be executed remotely.
 *  <P>
 *  The Remote interface serves to identify interfaces whose methods
 *  may be invoked from a non-local virtual machine.
 *  <P>
 *  Only an addition operation, <EM>add</EM>, is defined.
 *  Other plausible operations, e.g., <EM>sub</EM>, <EM>mul</EM>, etc.
 *  are nearly identical.
 */

public class Calculator extends UnicastRemoteObject implements CalculatorIF {

    /**
     * Default constructor defined only because it may throw an exception.
     */
    public Calculator () throws RemoteException {}

    /**
     * Addition method.
     * @param x Left operand.
     * @param y Right operand.
     * @return the sum of x and y.
     */
    public float add (float x, float y) throws RemoteException { return x+y; }

    // ... similar definitions of operations sub, times, divide, ... 
} // class Calculator
