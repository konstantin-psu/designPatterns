import java.util.Enumeration;
import java.util.LinkedList;

class ImplIterator<E> implements Enumeration 
{
    private LinkedList<E> list = new LinkedList<E>();
    ImplIterator(Stack<E> stack) { 
        Stack<E> c = stack.clone();
        while(!stack.isEmpty()) {
            list.addFirst(c.pop());
        }
    }
    public boolean hasMoreElements() { return ! list.isEmpty(); }
    public E nextElement() { 
        return list.poll();
    }
}
