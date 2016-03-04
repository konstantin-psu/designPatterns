/**
 * Classes that implement this interface can register to receive
 * security notifications from SecurityNotifier objects.
 */
public interface SecurityObserver {
    public final int ALARM = 1;
    public final int LOW_POWER = 2;
    public final int DIAGNOSTIC = 3;
    
    /**
     * This is method is called to deliver a security notification to
     * this object.
     * @param device A number that identifies the device that originated
     *        this notification.
     * @param event This should be one of the constants defined in this
     *              interface.
     */
    public void notify(int device, int event);
} // interface SecurityObserver

 
