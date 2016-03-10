/**
 *  This program shows the need of Single Threaded Execution
 *  for certain critical regions of a program.
 *  <P>
 *  Class Main defines an object, position, and two threads:
 *  writer and reader.
 *  A position holds three coordinates: x, y and z.
 *  Thread writer periodically stores coordinates in the position
 *  subject to the constrain that x=y=z, i.e., any position lies
 *  on the main diagonal of a 3D Cartesian space.
 *  Thread reader periodically reads the coordinates of the position.
 *  If the coordinates are not equal, it prints a nasty message.
 *  <P>
 *  Since the threads execute concurrently, the nasty message should
 *  eventually be printed, although this may be system dependent.
 *  On the instructor's system, the message occurs only early in
 *  the execution of the program and only if some tracing messages
 *  (which widen the critical regions) are printed during execution.
 *  <P>
 *  Writing and reading a more complex structure instead of a few numbers
 *  should make the problem more conspicuous.
 */
public class Main {
    // If trace is true, show what is being written and read
    // Print statements may appear "out of order".
    // The solution, of course, is to use this pattern,
    // but this is hardly the right place.
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
    private class Writer extends Thread {
        public void run () {
	    // higher priority will interleave reading
            setPriority (getPriority () + 1);
            for (int i = 0;; i++) {
                //+ synchronized (position) {
  		    double t = (double) i;
                    position.set (t, t, t);
                    if (trace) System.out.println ("Set x,y,z="+t);
                //+ }
                try { sleep (8); }
                catch (InterruptedException ie) {}
            }
        }
    }
    private Writer writer = new Writer ();
    private class Reader extends Thread {
        public void run () {
            for (;;) {
                //+ synchronized (position) {
                    double x = position.getX ();
                    if (trace) System.out.println ("Got x="+x);
                    double y = position.getY ();
                    if (trace) System.out.println ("Got y="+y);
                    double z = position.getZ ();
                    if (trace) System.out.println ("Got z="+z);
                    if (! (x==y && y==z))
			System.err.println ("Something bad happened");
                //+ }
                try { sleep (5); }
                catch (InterruptedException ie) {}
            }
        }
    }
    private Reader reader = new Reader ();
    private void main () {
        writer.start ();
        reader.start ();
    }
    /**
     *  Usual entry point.
     *  @param ignore Ditto
     */
    public static void main (String [] ignore) {
        (new Main ()).main ();
    }
}
