import java.util.*;
class ListStack2<E> implements StackImplementationIF<E> {
    ListIF<E> elements = new Nil<E>();
    public E push(E c) {
        elements = new Cons(c,elements);
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
