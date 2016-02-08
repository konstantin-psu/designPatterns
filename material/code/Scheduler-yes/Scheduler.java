import java.util.Vector;

/**
 * This class is used to explicitly schedule single threaded access to a
 * resource.  A Client wanting to access the resource calls the enter()
 * method of this scheduler first.  The enter() method returns to the
 * client only when the client is free to access the resource.
 * When the client is done with the resource, it calls the done() method
 * of this scheduler, to inform the scheduler that the client is no
 * longer accessing the resource (so another client may be scheduled).
 */
public class Scheduler {
    private Client runningClient;
    private Vector waitingClients = new Vector ();
    /**
     *  This method is called by a client before accessing a resource.
     *  The method returns to the client only when the client
     *  is authorized to access the resource.
     *  @exception InterruptedException when a waiting client
     *             is interrupted.
     */
    public void enter () throws InterruptedException {
        Client thisClient = (Client) Thread.currentThread ();
	// When the managed resourse is not busy, allocate it to the client.
	// Must synchronize on this object to ensure the mutual
	// exclusion of concurrent resources.
        synchronized (this) {
            if (runningClient == null) {
                runningClient = thisClient;
                return;
            }
	    // When the managed resourse is busy,
            // place the client in a queue according to its priority.
            int index;
            for (index = 0; index < waitingClients.size (); index++) {
                Client client = (Client) waitingClients.elementAt (index);
                if (client.priority () < thisClient.priority ()) break;
            }
            waitingClients.add (index, thisClient);
        }
	// Hold the client till it becomes the first in line
        synchronized (thisClient) {
            while (thisClient != runningClient) {
                thisClient.wait ();
            }
        }
    }

    /**
     * This method is called to indicate that a client is done
     * with accessing a resource.
     * @exception IllegalStateException if called by a client that is
     *            not the client accessing the resource.
     */
    synchronized public void done() {
        if (runningClient != Thread.currentThread ())
          throw new IllegalStateException ("Wrong Thread");
        // System.out.println ("done client "+runningClient.id ());
        if (waitingClients.size () == 0) {
            // System.out.println ("No client waiting");
            runningClient = null;
        } else {
            // System.out.println ("Waiting clients");
            // debug ();
            runningClient = (Client) waitingClients.elementAt (0);
            waitingClients.remove (runningClient);
            synchronized (runningClient) {
                runningClient.notifyAll ();
            }
        }
    }
    // Print the clients waiting to access the resource.
    private void debug () {
        for (int i = 0; i < waitingClients.size (); i++) {
            Client client = (Client) waitingClients.elementAt (i);
            int id = client.id ();
            int priority = client.priority ();
            System.out.println ("  waiting["+i+"]=("+id+","+priority+")");
        }
    }
}
