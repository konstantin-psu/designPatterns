/**
 * Instances of this class receive a notification from an object that is
 * can only deliver it to an object the implements the SecurityObserver
 * interface and apsses it on to a SecurityMonitor object that does not
 * implement SecurityObserver.
 */
class SecurityAdapter implements SecurityObserver {
    private SecurityMonitor sm;
    
    /**
     * Constructor
     */
    SecurityAdapter(SecurityMonitor sm) {
        this.sm = sm;
    } // Constructor(SecurityMonitor)

    /**
     * This is method is called to deliver a security notification to
     * this object.
     * @param device A number that identifies the device that originated
     *        this notification.
     * @param event This should be one of the constants defined in this
     *              interface.
     */
    public void notify(int device, int event) {
        switch (event) {
          case ALARM:
              sm.securityAlert(device);
              break;

          case LOW_POWER:
          case DIAGNOSTIC:
              sm.diagnosticAlert(device);
              break;
        } // switch
    } // notify(int, int)
} // class SecurityAdapter
