import java.rmi.*;
import java.rmi.server.*;

/**
 *  This class implements the operations of a pocket calculator.
 *  It is designed in such a way that the operations can be executed remotely.
 *  <P>
 *  The Remote interface serves to identify interfaces whose methods
 *  may be invoked from a non-local virtual machine.
 */

public class Calculator extends UnicastRemoteObject implements CalculatorIF {

    // memory store --- outside the CalculatorIF interface
    private float store = 0.0f;

    /**
     * Default constructor defined only because it may throw an exception.
     */
    Calculator () throws RemoteException {}

    /**
     * Addition method.
     * The modifier must be public, since it implements an interface method.
     * @param x Left operand
     * @param x Right operand
     */
    public float add (float x, float y) throws RemoteException { return x+y; }

    // ... similar definitions of operations sub, times, divide, ... 
} // class Calculator
