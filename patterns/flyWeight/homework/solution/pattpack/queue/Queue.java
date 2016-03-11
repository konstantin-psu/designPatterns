package pattpack.queue;

import java.util.Vector;

/**
 *  Simple implementation of a queue ADT.
 *  Only the methods necessary by the "catch-the-nut" game
 *  are provided.
 *  <P>
 *  This queue supports only single threaded accesses
 *  (note that the game in which it is used is multithreaded).
 */

public class Queue {
    // Representing a queue with a java.util.Vector is inefficient
    // particularly for big queues, but this exercise focuses on
    // the ProducerConsumer pattern.
    private Vector data = new Vector ();
    /**
     *  Add the argument to the queue.
     *  @param object The object to add to the queue.
     */
    public void enqueue (Object object) { data.add (object); }
    /**
     *  Remove from the queue the first element and return it.
     *  @return The first element of the queue.
     *  @exception IllegalStateException if the queue is empty.
     */
    public Object dequeue () {
	try {
	    Object object = data.get (0);
	    data.remove (0);
	    return object;
	} catch (ArrayIndexOutOfBoundsException aioobe) {
	    throw new IllegalStateException ("Can't dequeue an empty queue");
	}
    }
    /**
     *  Tell the size of the queue.
     *  @return The size of the queue.
     */
    public int size () { return data.size (); }
}
