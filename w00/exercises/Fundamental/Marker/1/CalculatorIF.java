import java.rmi.*;

/**
 *  Interface CalculatorIF defines the methods that can be called remotely
 */
public interface CalculatorIF extends Remote {
    /**
     * Addition method.
     * @param x Left operand
     * @param x Right operand
     */
    public float add (float x, float y) throws RemoteException;
    // ... similar definitions of operations sub, times, divide, ... 
} // interface CalculatorIF

