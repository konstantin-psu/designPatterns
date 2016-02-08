import pattpack.pooledlist.*;
import java.util.Enumeration;

class Facade {
    private List list = new Nil();
    public int length () { return list.length(); }
    public Object head () throws IllegalStateException { return list.head(); }
    public void add (Object object) { list = new Cons(object, list); }

    public Enumeration elements () { return new Iterator(list); }
}
