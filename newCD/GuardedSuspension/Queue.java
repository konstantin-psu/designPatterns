import java.util.Vector;

public class Queue {
    private Vector data = new Vector();

    /**
     * Put an object on the end of the queue
     * @param obj the object to put at end of queue
     */
    synchronized public void put(Object obj) {
        data.addElement(obj);
        notify();
    } // put(Object)

    /**
     * Get an object from the front of the queue
     * If queue is empty, waits until it is not empty.
     */
    synchronized public Object get() {
        while (data.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
            } // try
        } // while
        Object obj = data.elementAt(0);
        data.removeElementAt(0);
        return obj;
    } // get()
} // class Queue
