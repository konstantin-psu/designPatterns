import java.util.ArrayList;

public class Queue {
    private ArrayList data = new ArrayList();

    /**
     * Put an object on the end of the queue
     * @param obj the object to put at end of queue
     */
    synchronized public void push(TroubleTicket tkt) {
        data.add(tkt);
        notify();
    } // push(TroubleTicket)

    /**
     * Get an TroubleTicket from the front of the queue
     * If queue is empty, waits until it is not empty.
     */
    synchronized public TroubleTicket pull() {
        while (data.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
            } // try
        } // while
        TroubleTicket tkt = (TroubleTicket)data.get(0);
        data.remove(0);
        return tkt;
    } // pull()

    /**
     * Return the number of trouble tickets in this queue.
     */
    public int size() {
        return data.size();
    } // size()
} // class Queue
