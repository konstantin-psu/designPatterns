import java.util.ArraySet;
import java.util.Iterator;

/**
 * When an instance of this class receives a notification from a
 * security device, it passes it on to all of its registered observers.
 */
class SecurityNotifier {
    private ArraySet observers = new ArraySet();
    //...
    /**
     * Add a new observer to this object.
     */
    public void addObserver(SecurityObserver observer) {
        observers.add(observer);
    } // addObserver(SecurityObserver)

    /**
     * Remove an observer from this object
     */
    public void removeObserver(SecurityObserver observer) {
        observers.remove(observer);
    } // removeObserver(SecurityObserver)

    /**
     * This method is called when this object needs to pass on a
     * notification to its registered observers.
     * @param device A number that identifies the device that originated
     *        this notification.
     * @param event This should be one of the constants defined in this
     *              interface.
     */
    private void notify(int device, int event) {
        Iterator iterator = observers.iterator();
        while (iterator.hasNext()) {
            ((SecurityObserver)iterator.next()).notify(device, event);
        } // while
    } // notify(int, int)
} // class SecurityNotifier
