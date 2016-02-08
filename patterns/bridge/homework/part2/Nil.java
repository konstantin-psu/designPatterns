import java.lang.*;

class Nil<E> implements ListIF<E> {
    public int length() {return 0;}
    public boolean isEmpty() {return true;}
    public E head() throws IllegalStateException { 
        throw new IllegalStateException("Empty List");
    }
    public ListIF<E> tail() throws IllegalStateException { 
        throw new IllegalStateException("Empty List");
    }
}
