import java.util.*;
class ListStack<E> implements StackImplementationIF<E> {
    LinkedList<E> elements = new LinkedList<E>();
    public E push(E c) {
        elements.addFirst(c);
        return c;    
    }
    public E peek() {
        return elements.peek();    
    }
    public E pop() {
        E t = elements.poll();
        if (t == null) { throw new IllegalStateException("Empty List"); }
        return t;
    }
    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
