/**
 *  This class implements interface StackImpl
 *  with a stack represented by an array.
 *  Obviously, the stack has a fixed size
 *  and may overflow.
 */
public class FixedStack implements StackImpl {
    // the size of the array representing the stack
    private final int size = 10;
    // the array containing the stack elements
    private int [] data = new int [size];
    // the number of elements contained in the stack
    private int pnt = 0;
    /**
     *  Push an integer onto the stack.
     *  @param val The integer value pushed onto the stack.
     */
    public void push (int val) { data [pnt] = val; pnt++; }
    /**
     *  Pop the stack.
     *  @return The integer value popped from the stack.
     */
    public int pop () { --pnt; return data [pnt]; }
    /**
     *  Return the number of elements contained in the stack.
     *  @return The number of elements contained in the stack.
     */
    public int size () { return pnt; }
}
