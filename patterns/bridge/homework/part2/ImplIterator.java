import java.util.Enumeration;
import java.util.LinkedList;

class ImplIterator implements Enumeration 
{
    LinkedList list = new LinkedList();
    ImplIterator(Stack stack) { 
        Stack c = stack.clone();
        while(!stack.isEmpty()) {
            list.addFirst(c.pop());
        }
    }
    public boolean hasMoreElements() { return ! list.isEmpty(); }
    public Object nextElement() { 
        Object current = list.poll();
        return current; 
    }
}
