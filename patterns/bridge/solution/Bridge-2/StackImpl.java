/**
 *  Interface implemented by all stacks.
 */
public interface StackImpl {
    /**
     *  Push an integer onto the stack.
     *  @param val The integer value pushed onto the stack.
     */
    void push (int val);
    /**
     *  Pop the stack.
     *  @return The integer value popped from the stack.
     */
    int pop ();
    /**
     *  Return the number of elements contained in the stack.
     *  @return The number of elements contained in the stack.
     */
    int size ();
}
