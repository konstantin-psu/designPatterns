public class Flusher {
    private boolean flushInProgress = false;

    /**
     * This method is called to start a flush.
     */
    public void flush() {
        synchronized (this) {
            if (flushInProgress)
              return;
            flushInProgress = true;
        }
        // code to start flush goes here.
    }

    /**
     * This method is called to notify this object that a flush has completed.
     */
    void flushCompleted() {
        flushInProgress = false;
    } // flushCompleted()
} // class Flusher
