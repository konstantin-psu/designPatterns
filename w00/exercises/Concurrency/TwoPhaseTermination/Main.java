import queue.Queue;

/**
 *  This class refines the ProducerConsumer exercise by adding
 *  orderly shutdown.
 *  <P>
 *  This class implements a trivial game using a ProducerConsumer pattern.
 *  The game participants are a tree that drops coconuts and
 *  some monkeys that have to catch (and eat) the coconuts before they
 *  hit the ground.
 *  <P>
 *  The tree plays the role of producer whereas the monkeys are the consumers.
 *  <P>
 *  For purpose of this exercise, the tree drops a new coconut at
 *  random intervals in the range 0 to 250 msec.
 *  A monkey catches a coconut as soon as it is not busy.
 *  When a monkey catches a coconut, it is busy for 500 msec to eat it,
 *  after which, the monkey is free to catch another coconut.
 *  <P>
 *  On the instructor machine a game ends after between 10 and 19
 *  coconuts are dropped.
 */

public class Main {
    // Number of monkeys in the game
    private final int numMonkeys = 3;
    // Number of coconuts dropped from the tree
    private int nuts = 0;
    // Queue to store dropping nuts
    private Queue queue = new Queue ();

    // We measure all times relative to the beginning of the execution
    private long elapsed = System.currentTimeMillis ();
    private long now () { return System.currentTimeMillis () - elapsed; }

    // Generation of random numbers in a certain range
    private java.util.Random random = new java.util.Random (0);
    private int random (int low, int high) {
	int tmp = Math.abs (random.nextInt ()) % (high - low) + low;
	// System.out.println (tmp);
	return tmp;
    }

    // This class abstracts a coconut.  Coconuts have an id.
    private class Nut {
	private /* final */ int id;
	private Nut (int id) { this.id = id; }
    }

    // Synchronization lock
    private Object lock = new Object ();

    // This class abstracts the tree from which coconuts fall.
    // Falling coconuts are placed in a queue.
    // The game is over if more than numMonkeys coconuts are in the queue
    // When a coconut is falling, the monkeys are notified.
    // Coconuts fall at random intervals in the range 0 to 250
    private class Tree extends Thread {
	public void run () {
	    try {
		while (true) {
		    synchronized (lock) {
			queue.enqueue (new Nut (nuts));
			System.out.println ("Nut #"+nuts+" dropped at "+now());
			nuts++;
			if (queue.size () > numMonkeys) shutdown ();
			else lock.notify ();
		    }
		    sleep (random (0, 250));
		} 
	    } catch (InterruptedException ie) { 
		if (queue.size () > numMonkeys)
		    System.out.println ("Game ends at "+now()+
					". "+nuts+" nuts dropped.");
	    }
	}
    }

    // This class abstracts a monkey trying to catch a coconut before
    // it hits the ground.  Monkeys catch the coconuts from the queue
    // they are in.  After a monkey catches a coconut it must wait
    // 500 msec before it can catch another.
    private class Monkey extends Thread {
	private int id;
	private Monkey (int id) { this.id = id; }
	private int nuts = 0;
	public void run () {
	    try {
		while (true) {
		    synchronized (lock) {
			while (queue.size () == 0) { lock.wait (); }
			Nut x = (Nut) queue.dequeue ();
			nuts++;
			System.out.println ("Monkey #"+id+" catches nut #"+
					    x.id+" at "+now());
		    }
		    sleep (500);
		}
	    } catch (InterruptedException ie) { 
		System.out.println ("Monkey #"+id+" ate "+nuts+" nuts.");
	    }
	}
    }

    Tree tree = new Tree ();
    Monkey [] monkey = { new Monkey (0), new Monkey (1), new Monkey (2) };
    // Create and start the monkeys and the tree.
    private void main () {
	for (int i = 0; i < numMonkeys; i++) monkey [i].start ();
	tree.start ();
    }
    // Stop monkeys and tree.  End the game.
    private void shutdown () {
	for (int i = 0; i < numMonkeys; i++) monkey [i].interrupt ();
	tree.interrupt ();
    }

    /**
     *  Usual entry.
     *  @param ignore Ditto.
     */
    public static void main (String [] ignore) { (new Main ()).main (); }
}
