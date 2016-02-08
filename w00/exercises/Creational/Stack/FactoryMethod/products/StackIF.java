package products;

import java.util.EmptyStackException;

/**
 * Interface of a minimal stack.
 */
public interface StackIF {
    /**
     * Push an element on this stack.
     * @param element The element to push on this stack.
     */
    public void push (StackElementIF element);
    /**
     * Pop this stack.
     * @exception EmptyStackException Thown when the stack is empty.
     */
    public void pop () throws EmptyStackException;
    /**
     * Compute the top of this stack.
     * @return The top element of this stack.
     * @exception EmptyStackException Thown when the stack is empty.
     */
    public StackElementIF top () throws EmptyStackException;
}
