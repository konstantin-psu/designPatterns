import java.rmi.*;

/**
 *  Interface CalculatorIF defines the methods that can be called remotely
 */
interface CalculatorIF extends Remote {

    /**
     * Addition method.
     * @param x Left operand.
     * @param y Right operand.
     * @return the sum of x and y.
     */
    float add (float x, float y) throws RemoteException;
    // ... similar definitions of operations sub, times, divide, ... 
} // interface CalculatorIF

