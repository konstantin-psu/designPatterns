import java.util.*;
class ListStack<E> implements StackImplementationIF<E> {
    private ListIF<E> elements = new Nil<E>();
    public E push(E c) {
        elements = new Cons<E>(c,elements);
        return c;    
    }
    public E pop() {
        E r = elements.head();
        elements = elements.tail();
        return r;
    }

    public E peek() {
        return elements.head();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
