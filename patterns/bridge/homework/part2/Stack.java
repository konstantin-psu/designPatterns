import java.util.Enumeration;


class Stack<E> implements Cloneable {

    // Actual stack implementation
    private StackImplementationIF<E> stackImpl = new StackArray<E>();
    
    /**
     *  Use cloneable interface to get a copy of the stack.
     *  @return Return a copy of the stack.
     */
    public Stack<E> clone() {
        try { return (Stack<E>) super.clone(); }
        catch(CloneNotSupportedException ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
            return null;
        }
    }

    /**
     *  Return true if the stack is empty.
     *  @return Return true if the stack is empty, otherwise false.
     */
    public boolean isEmpty() {
        return stackImpl.isEmpty();
    }

    /**
     *  Pop an item from the stack.
     *  @return Return the generic value at the top of the stack.
     */
    public E peek() {
        return stackImpl.peek();
    }

    /**
     *  Pop an item from the stack.
     *  @return Return the generic value popped from the stack.
     */
    public E pop() {
        return stackImpl.pop();
    }

    /**
     *  Push an item onto the stack.
     *  @param item The generic value pushed onto the stack.
     *  @return Return the generic value pushed onto the stack.
     */
    public E push(E item) {
        try {
            stackImpl.push(item);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array is full. Switching to unbound implementation");
            StackImplementationIF<E> stackImplTemp = new ListStack<E>();
            for (Enumeration en = new ImplIterator<E>(this); en.hasMoreElements();) {
                E c = (E) en.nextElement();
                stackImplTemp.push(c);
            }
            stackImpl = stackImplTemp;
            stackImpl.push(item);
        }
        return item;
    }
}
