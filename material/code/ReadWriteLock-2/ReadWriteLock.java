import java.util.Vector;

/**
 * Instances of this class manage read and write locks.
 * <P>
 * This class is an alternative implementation of the a class with
 * the same name by M. Grand, Patterns in Java, p. 431.  It is not
 * a specialized form of the Scheduler pattern.
 * It provides extensive tracing.
 * <P>
 * This class is intended for applications where there is a set
 * of waiting writers and it does not make any difference which
 * is allowed to write.  (An implied assumption is that there are
 * not waiting writers all the time).
 */
public class ReadWriteLock {
    // Defines whether a trace should be produced
    private final boolean trace = true;

    // Number of reader threads currently reading
    private int concurrentReaders = 0;
    // Number of writer threads currently reading
    private int concurrentWriters = 0;
    // Number of reader threads waiting access to read
    // It si not necessary, but we like to know
    private int waitingReaders = 0;
    // Number of writer threads waiting access to write
    private int waitingWriters = 0;

    // Lock.  We could use the instance of ReadWriteLock
    // but a separate object makes tracing easier.  Methods
    // that would be synchronized can instead trace their
    // calls when they happen.
    private Object Lock = new Object ();

    /**
     * Issue a read lock if there is no outstanding write lock or
     * threads waiting to get a write lock.
     */
    public void readLock (int id) throws InterruptedException {
	if (trace) System.out.println ("R"+id+" asks");
	synchronized (Lock) {
	    waitingReaders++;
	    while (waitingWriters+concurrentWriters > 0) {
		if (trace) System.out.println ("R"+id+" waits: "+snoop ());
		Lock.wait();
	    }
	    waitingReaders--;
	    concurrentReaders++;
	}
	if (trace) System.out.println ("R"+id+" goes: "+snoop ());
	// Now caller thread should read
    }

    /**
     * Issue a write lock if there are no outstanding read or write
     * locks.
     */
    public void writeLock (int id) throws InterruptedException {
	if (trace) System.out.println ("W"+id+" asks");
	synchronized (Lock) {
	    waitingWriters++;
	    while (concurrentWriters+concurrentReaders > 0) {
		if (trace) System.out.println ("W"+id+" waits: "+snoop ());
		Lock.wait();
	    }
	    waitingWriters--;
	    concurrentWriters++;
	}
	if (trace) System.out.println ("W"+id+" goes: "+snoop ());
	// Now caller thread should write
    }
    /**
     * Threads call this method to relinquish a lock that they
     * previously got from this object.
     * @exception IllegalStateException if called when there are no
     *            outstanding locks or there is a write lock issued to a
     *            different thread.
     */

    public void done (int id) throws InterruptedException {
	synchronized (Lock) {
	    // There is at most one concurrent writer
	    if (concurrentWriters == 1) {
		concurrentWriters--;
		if (trace) System.out.println ("W"+id+" done");
	    } else if (concurrentReaders > 0) { 
		concurrentReaders--;
		if (trace) System.out.println ("R"+id+" done");
	    } else {
		throw new IllegalStateException("Thread does not have lock");
	    }
	    // Now caller thread has written or read. Let others run
	    Lock.notifyAll ();
	}
    }

    private String snoop () {
	return " cw="+concurrentWriters+
	    " ww="+waitingWriters+
	    " cr="+concurrentReaders+
	    " wr="+waitingReaders;
    }
}
