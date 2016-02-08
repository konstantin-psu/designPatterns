package pool;

import list.*;

/**
 * This class implements a pool of list cells.
 * It also maintains some statistics about the pool usage.
 */
public class Pool {
    private List pool = new Nil ();
    private int created = 0;
    private int recycled = 0;
    private int held = 0;
    /**
     * Acquire a list cell.
     * The cell is recycled from the pool if any is available;
     * otherwise it is created by the list cell constructor.
     * @return A list cell.
     */
    public Cons acquire () {
	if (pool.isEmpty ()) {
	    created++;
	    return new Cons ();
	}
	else {
	    held--;
	    recycled++;
	    Cons tmp = (Cons) pool;
	    pool = pool.tail ();
	    return tmp;
	}
    }
    /**
     * Return a list cell to the pool.
     * @param cons The list cell to return to the pool.
     */
    public void release (Cons cons) {
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
