import java.lang.reflect.Array;
class StackArray<E> implements StackImplementationIF<E> {
        private E[] elements;
        private int lastIndex;
        private int max = 10;
    
    @SuppressWarnings("unchecked") 
    StackArray() {
        elements = (E[]) new Object[max];
    }
    public E push(E c) {
        elements[lastIndex] = c;
        lastIndex++;
        return c;
    }
    
    public E pop() {
        lastIndex--;
        E c = elements[lastIndex];
        elements[lastIndex] = null;
        return c;
    }

    public E peek() {
        
        return elements[lastIndex-1];
    }

    public boolean isEmpty() {
        return lastIndex == 0;
    }
    
}
