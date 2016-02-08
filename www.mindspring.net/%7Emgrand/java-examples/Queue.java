import java.util.Enumeration;
import java.util.NoSuchElementException;

/**
 * A class that implements a Queue data structure.<br>
 * Requires java 1.1 or later.
 */
public class Queue {
    private QueueNode queue;
    private int length = 0;

    /**
     * Put an object on the end of the queue
     * @param obj the object to put at end of queue
     */
    synchronized public void push(Object obj) {
        if (queue == null) {
            queue = new QueueNode(obj);
            queue.next = queue;
            length = 1;
        } else {
            QueueNode t = new QueueNode(obj);
            t.next = queue.next;
            queue.next = t;
            queue = t;
            length++;
        } // if
        notify();
    } // push(Object)

    /**
     * Get an object from the front of the queue
     * If queue is empty, waits until it is not empty.
     */
    synchronized public Object pull() {
        while (queue == null) {
            try {
                wait();
            } catch (InterruptedException e) {
            } // try
        } // while
        return pull0();
    } // pull()

    /**
     * Get an object from the front of the queue
     * @exception EmptyQueueException If the Queue
     * is empty.
     */
    synchronized public Object pullNow()
                        throws EmptyQueueException {
        if (queue == null)
          throw new EmptyQueueException();
        return pull0();
    } // pullNow()

    // Assume that this method's caller is synchronized
    private Object pull0() {
        Object obj;
        if (queue.next == queue) {
            obj = queue.getObject();
            queue = null;
            length = 0;
        } else {
            obj = queue.next.getObject();
            queue.next = queue.next.next;
            length++;
        } // if
        return obj;
   } // pull0()

    /**
     * Return the number of objects in the queue.
     */
    public int getLength() {
        return length;
    } // getLength()

    /**
     * Returns an Enumeration object that accesses this Queue object's
     * current contents.
     */
    public Enumeration elements() {
        return new QueueEnumerator();
    } // elements()

    /**
     * returns a string representation of the queue.
     */
    public synchronized String toString() {
        if (queue == null) {
            return "***Empty*Queue***";
        } // if
        StringBuffer buf = new StringBuffer((length+1)*16);
        buf.append("[ ");
        QueueNode q = queue.next;
        do {
            buf.append(q.getObject().toString());
            buf.append(' ');
            q = q.next;
        } while (q != queue);
        buf.append(']');
        return buf.toString();
    } // toString()

    /**
     * Returns true if the given argument is a Queue object that has the
     * same number of objects and corresponding objects in the two
     * Queues are equal.
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof Queue)
            || getLength()!=((Queue)obj).getLength())
          return false;
        QueueNode q = queue.next;
        QueueNode oq = ((Queue)obj).queue.next;
        do {
            if (!q.getObject().equals(oq.getObject()))
              return false;
            q = q.next;
            oq = oq.next;
        } while (q != queue);
        return true;
    } // equals(Object)

    /**
     * returns a hash code fot this queue
     */
    public synchronized int hashCode() {
        int hash = 0;
        if (queue != null) {
            QueueNode q = queue.next;
            do {
                hash ^= q.getObject().hashCode();
                q = q.next;
            } while (q != queue);
        } // if
        return hash;
    } // hashCode()

    /**
     * Enumeration class for Queue
     */
    private class QueueEnumerator implements Enumeration {
        private QueueNode start, end;

        /**
         * Constructor.
         */
        QueueEnumerator() {
            synchronized (Queue.this) {
                if (queue != null) {
                    start = queue.next;
                    end = queue;
                } // if
            } // synchronized
        } // Constructor()

        /**
         * Returns true if the enumeration contains more elements; false
         * if its empty.
         */
        public boolean hasMoreElements() {
            return start != null;
        } // hasMoreElements()

        /**
         * Returns the next element of the enumeration. Calls to this
         * method will enumerate successive elements.
         * @exception NoSuchElementException If no more elements exist.
         */
        public synchronized Object nextElement() {
            if (start == null)
              throw new NoSuchElementException();
            Object obj = start.getObject();
            if (start == end)
              start = null;
            else
              start = start.next;
            return obj;
        } // nextElement()
    } // class QueueEnumerator

    /**
     * The queue is represented internally as a circular List of these
     * objects.
     */
    private static class QueueNode {
        private Object obj;
        QueueNode next;

        /**
         * create a QueueNode that puts the given object in the internal
         * Linked List.
         */
        QueueNode(Object obj) {
            this.obj = obj;
        } // constructor(Object)

        /**
         * Get the object associated with this QueueNode.
         */
        Object getObject() {
            return obj;
        } // getObject()
    } // class QueueNode

    /**
     * Exception class for complaining about an empty queue.
     */
    public static class EmptyQueueException extends Exception {
    } // class EmptyQueueException
} // class Queue
