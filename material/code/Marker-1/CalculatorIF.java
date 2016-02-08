import java.rmi.*;

/**
 *  Interface CalculatorIF defines the methods that can be called remotely
 *  <P>
 *  Only an addition operation, <EM>add</EM>, is defined.
 *  Other plausible operations, e.g., <EM>sub</EM>, <EM>mul</EM>, etc.
 *  are nearly identical.
 */
public interface CalculatorIF extends Remote {
    /**
     * Addition method.
     * @param x Left operand.
     * @param y Right operand.
     * @return the sum of x and y.
     */
    public float add (float x, float y) throws RemoteException;
    // ... similar definitions of operations sub, times, divide, ... 
} // interface CalculatorIF

