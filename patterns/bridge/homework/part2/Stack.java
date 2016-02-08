import java.util.Enumeration;
class Stack<E> implements Cloneable {
    StackImplementationIF<E> stackImpl = new StackArray<E>();
    
    Stack() {
    }
    public Stack clone() {
    try { return (Stack) super.clone(); }
    catch(CloneNotSupportedException ex) {
        System.out.println(ex.getMessage());
        System.exit(1);
        return null;
    }
    }
    boolean isEmpty() {
        return stackImpl.isEmpty();
    }
    E peek() {
        return stackImpl.peek();
    }
    E pop() {
        return stackImpl.pop();
    }
    E push(E item) {
        try {
            stackImpl.push(item);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Switching to unbound implementation");
            StackImplementationIF<E> stackImplTemp = new ListStack2<E>();
            for (Enumeration en = new ImplIterator(this); en.hasMoreElements();) {
                E c = (E) en.nextElement();
                stackImplTemp.push(c);
            }
            stackImpl = stackImplTemp;
            stackImpl.push(item);
        }
        return item;
    }
}
