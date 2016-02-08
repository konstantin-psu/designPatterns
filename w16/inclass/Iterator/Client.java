import pattpack.pooledlist.*;
import java.util.Enumeration;

class Client {
    public static void main(String [] ignore) {
	List list = new Nil();
	for (int i = 0; i < 10; i++)
	    list = new Cons(i,list);
	//	for (Enumeration e = list.elements() ; e.hasMoreElements() ;) {
	for (Enumeration e = new Iterator(list) ; e.hasMoreElements() ;) {
	    Object first = e.nextElement();
	    for (Enumeration x = new Iterator(list) ; x.hasMoreElements() ;) {
		System.out.println(first+","+x.nextElement());
	    }
	}
    }
}
