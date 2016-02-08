import java.util.Random;
import list.*;
import pool.*;

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
	Pool pool = new Pool ();
	List list = new Nil ();
	Random random = new Random ();
	for (int i = 0; i < 200; i++) {
	    switch (Math.abs (random.nextInt ()) % 2) {
	    case 0: 
		if (! list.isEmpty ()) {
		    Cons save = (Cons) list; 
		    list = list.tail ();
		    pool.release (save);
		}
		break;
	    case 1:
		Cons cons = pool.acquire ();
		cons.reset (new Integer (i), list);
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
