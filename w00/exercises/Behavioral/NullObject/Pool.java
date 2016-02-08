/**
 * This class implements a pool of list cells.
 * It also maintains some statistics about the pool usage.
 */
public class Pool {
    private List pool = null;
    private int created = 0;
    private int recycled = 0;
    private int held = 0;
    /**
     * Acquire a list cell.
     * The cell is recycled from the pool if any is available;
     * otherwise it is created by the list cell constructor.
     * @return A list cell.
     */
    public List acquire () {
	if (pool == null) {
	    created++;
	    return new List ();
	}
	else {
	    held--;
	    recycled++;
	    List tmp = pool;
	    pool = pool.tail ();
	    return tmp;
	}
    }
    /**
     * Return a list cell to the pool.
     * @param list The list cell to return to the pool.
     */
    public void release (List list) {
	held++;
	list.reset (null, pool);
	pool = list;
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
