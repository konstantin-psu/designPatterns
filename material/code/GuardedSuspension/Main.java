import java.util.Random;

/**
 *  This class is a driver for a Guarded Suspension pattern exercise.
 *  It hosts a thread that simulates a machine that fills boxes
 *  of breakfast cereals.
 *  <P>
 *  The simulator drops an amount of cereals into the box at
 *  periodic intervals.  Both the amounts of cereals and the intervals
 *  are subject to small random variations. When the box is filled
 *  to nominal capacity, the drops end.
 *  <P>
 *  An overflow safety mechanism shutoffs the drops if the box
 *  amount exceeds a certain threshold.
 */
public class Main {
    // Filling simulation thread. 

    // The box is full with 400 grams.
    private final int nominal = 400;
    // The threshold is 3% above nominal capacity
    private final int threshold = (int) (nominal * 1.03 + 0.5);
    // The current box content
    private int content;
    // True when box has been filled
    private boolean filled = false;
    // The duration of the filling
    private long duration = 0;

    private Filler filler = new Filler ();
    private Watcher watcher = new Watcher ();
    private Object object = new Object ();

    private class Filler extends Thread {
	// A new amount of cereal is dropped into the box
	// every 22 to 38 milliseconds
	private final int intervalStart = 22;
	private final int intervalEnd = 38;
	// The amount of cereal is dropped into the box every interval
	// is between 5 and 11 grams.
	private final int amountStart = 5;
	private final int amountEnd = 11;

	/* Execute the drops till the box is full. */
        public void run () { 
	    synchronized (object) {
		while (! filled) {
		    int interval = random (intervalStart, intervalEnd);
		    int amount = random (amountStart, amountEnd);
		    content += amount;
		    duration += interval;
		    object.notify ();
		    try { object.wait (interval); }
		    catch (InterruptedException ie) {
			throw new RuntimeException ("Filler interrupted");
		    }
		    // uncomment for normal operations, comment for shutoff
		    // filled = content >= nominal;
		}
		System.out.println ("Filled at "+content+
				    " gr. after "+duration+" ms.");
	    }
	}
    }

    private class Watcher extends Thread {
	// A new amount of cereal is dropped into the box
	// Shutoff mechanism
	public void run () {
	    synchronized (object) {
		while (content < threshold && ! filled) { 
		    try { object.wait (); }
		    catch (InterruptedException ie) {
			throw new RuntimeException ("Watcher interrupted");
		    }
		}
		// either the box is overflowing, or it has been filled  
		if (! filled) {
		    System.out.println ("Shutoff at "+content+
					" gr. after "+duration+" ms.");
		    filled = true;
		}
	    }
	}
    }

    // Device to compute intervals and amounts with random variations
    private Random random = new Random ();
    private int random (int start, int end) {
	int tmp = Math.abs (random.nextInt ()) % (end - start) + start;
	return tmp;
    }
    private void main () { 
       	watcher.start ();
	filler.start ();
    }
    /**
     *  Usual entry point.
     *  @param ignore Ditto
     */
    public static void main (String [] ignore) { (new Main ()).main (); }
}
