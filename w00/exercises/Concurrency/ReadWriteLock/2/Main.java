/**
 *  This program is a driver to test a ReadWrite Lock pattern.
 *  <P>
 *  Class Main defines an object, <I>position</I>, and several threads of
 *  either of two kinds:  writers and readers.
 *  A position holds three coordinates: x, y and z.
 *  Writer threads periodically store coordinates in the position
 *  subject to the constrain that x=y=z, i.e., any position lies
 *  on the main diagonal of a 3D Cartesian space.
 *  Reader threads periodically read the coordinates of the position.
 *  If the coordinates are not equal, it prints a nasty message.
 *  <P>
 *  A compile time variable, <I>trace</I>, defines whether a trace
 *  of accesses to the position is produced.
 */
public class Main {
    private ReadWriteLock lockManager = new ReadWriteLock ();
    // If trace is true, show what is being written and read
    // Print statements may appear "out of order".
    private static final boolean trace = true;
    private class Position {
        // the position's coordinates
        private double x, y, z;
        private void set (double x, double y, double z) {
	    this.x = x; this.y = y; this.z = z;
	}
        private double getX () { return x; }
        private double getY () { return y; }
        private double getZ () { return z; }
    }
    private Position position = new Position ();
    // Writer thread.
    private class Writer extends Thread {
	/** This thread object id for tracing purposes. */
	public final int id;
	private Writer (int id) { this.id = id; }
        public void run () {
	    // higher priority and lower frequency to interleave reading
            setPriority (getPriority () + 1);
            for (int i = 0;; i++) {
		try {
		    try { sleep (random (125, 400)); }
		    catch (InterruptedException ie) {}
		    double t = (double) i;
		    lockManager.writeLock (id);
		    position.set (t, t, t);
		    lockManager.done (id);
		    if (trace) System.out.println ("W"+id+" Set x,y,z="+t);
		} catch (InterruptedException ie) {
		    System.err.println ("W"+id+" interrupted");
		}
	    }
	}
    }
    private class Reader extends Thread {
	/** This thread object id for tracing purposes. */
	public final int id;
	private Reader (int id) { this.id = id; }
        public void run () {
            for (;;) {
		try {
		    try { sleep (random (25, 50)); }
		    catch (InterruptedException ie) {}
		    lockManager.readLock (id);
		    double x = position.getX ();
		    if (trace) System.out.println ("R"+id+" Got x="+x);
		    double y = position.getY ();
		    if (trace) System.out.println ("R"+id+" Got y="+y);
		    double z = position.getZ ();
		    if (trace) System.out.println ("R"+id+" Got z="+z);
		    lockManager.done (id);
		    if (! (x==y && y==z))
			System.err.println ("R"+id+" Something bad happened");
		} catch (InterruptedException ie) {
		    System.err.println ("R"+id+" interrupted");
		}
	    }
        }
    }
    // Construct some writers and some readers and let them loose
    private void main () {
	for (int i = 0; i < 4; i++) (new Writer (i)).start ();
	for (int i = 4; i < 20; i++) (new Reader (i)).start ();
    }
    private java.util.Random random = new java.util.Random (0);
    private int random (int low, int high) {
	int tmp = Math.abs (random.nextInt ()) % (high - low) + low;
	// System.out.println (tmp);
	return tmp;
    }
    /**
     *  Usual entry point.
     *  @param ignore Ditto
     */
    public static void main (String [] ignore) {
        (new Main ()).main ();
    }
}
