import java.util.Random;

/**
 *  Driver for a Scheduler pattern.
 *  This program constructs a bunch of clients of a service.
 *  Each client is constructed with a fuse.
 *  When the fuse is over each client requests a service.
 *  Each client is constructed with a duration of the service
 *  it requests and a priority.
 *  All the client's parameters are randomly selected.
 */

public class Main {
    private static final long epoch = System.currentTimeMillis ();
    /**
     *  Return the time since the beginning of the execution.
     *  @return The time since the beginning of the execution.
     */
    public static long now () {
	return System.currentTimeMillis () - epoch;
    }
    // parcel priorities
    private final String [] pname = { "bulk", "regular", "express", };
    // random times range between 0 and range
    private final int range = 10000;
    // the robot
    private final Robot robbie = new Robot ();
    // this method constructs the clients that use to robot
    private void main () {
	Random random = new Random (0);
	for (int i = 0; i < 20; i++) {
	    int fuse = Math.abs (random.nextInt ()) % range;
	    int duration = Math.abs (random.nextInt ()) % (range / 10);
	    int priority = Math.abs (random.nextInt ()) % pname.length;
	    // Client will make a delivery request at time fuse
	    new Client (i, fuse, priority, duration, robbie);
	}
    }
    /**
     *  Usual entry point.
     *  @param ignore Ditto
     */
    public static void main (String [] ignore) {
        (new Main ()).main ();
    }
}
