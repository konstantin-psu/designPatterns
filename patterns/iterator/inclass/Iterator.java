import pattpack.pooledlist.List;
import java.util.Enumeration;

class Iterator implements Enumeration {
    List list;
    Iterator(List list) { this.list = list; }
    public boolean hasMoreElements() { return ! list.isEmpty(); }
    public Object nextElement() { 
	Object current = list.head();
	list = list.tail();
	return current; 
    }
}
