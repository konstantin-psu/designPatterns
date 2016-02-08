package pattpack.pooledlist;

/**
 * This class implements a pool of list cells.
 * It also maintains some statistics about the pool usage.
 */
public class Pool<E> {
    private List<E> pool = new Nil<E> ();
    private int created = 0;
    private int recycled = 0;
    private int held = 0;
    /**
     * Acquire a list cell.
     * The cell is recycled from the pool if any is available;
     * otherwise it is created by the list cell constructor.
     * The argument are for the initialization of the cell.
     * @param object The head of the pooled cell.
     * @param list The tail of the pooled cell.
     * @return A list cell.
     */
    public Cons<E> acquire (E e, List<E> list) {
	if (pool.isEmpty ()) {
	    created++;
	    return new Cons<E> (e, list);
	}
	else {
	    held--;
	    recycled++;
	    Cons<E> tmp = (Cons<E>) pool;
	    pool = pool.tail ();
	    tmp.reset (e, list);
	    return tmp;
	}
    }
    /**
     * Return a list cell to the pool.
     * @param cons The list cell to return to the pool.
     */
    public void release (Cons<E> cons) {
	held++;
	cons.reset (null, pool);
	pool = cons;
    }
    /**
     * Print on standard output the number of cell nodes
     * that have been constructed, that have been created,
     * and that are held by the pool since the beginning
     * of execution.
     */
    public void statistics () {
	System.out.println ("created="+created+
                            "  recycled="+recycled+
                            "  held="+held);
    }
}
