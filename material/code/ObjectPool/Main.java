import java.util.Random;
import pattpack.pooledlist.*;

/**
 * This class is test harness for an Object Pool class.
 */
public class Main {
    /**
     *  Usual entry point.
     *  This method performs 200 times one of two operations on a list.
     *  Operations are either adding a cell to a list
     *  or removing a cell from a list.
     *  Operations are randomly selected.
     *  List cells to add to or remove from a list are acquired from
     *  or released to a pool of list cell.
     *  <P>
     *  At the end of the execution, both the content of the list
     *  and statistics about the pool are printed.
     */
    public static void main (String [] arg) {
	Pool<Integer> pool = new Pool<Integer> ();
	List<Integer> list = new Nil<Integer> ();
	Random random = new Random ();
	for (int i = 0; i < 200; i++) {
	    switch (Math.abs (random.nextInt ()) % 2) {
	    case 0: 
		if (! list.isEmpty ()) {
		    Cons<Integer> save = (Cons<Integer>) list; 
		    list = list.tail ();
		    pool.release (save);
		}
		break;
	    case 1:
		Cons<Integer> cons = pool.acquire (i, list);
		list = cons;
		break;
	    }
	}
	while (! list.isEmpty ()) {
	    System.out.print (list.head ()+"  ");
	    list = list.tail ();
	}
	System.out.println ();
	pool.statistics ();
    }
}
