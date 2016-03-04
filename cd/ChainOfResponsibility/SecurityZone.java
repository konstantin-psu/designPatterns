/**
 * This is the superclass for all classes that are used to model a kind
 * of security zone.
 */
abstract class SecurityZone {
    private SecurityZone parent;
    //...
    /**
     * Return this object's parent zone.
     */
    SecurityZone getParent() {
        return parent;
    } // getParent()

    /**
     * This method is called to notify this security zone of a change in
     * a sensor measurement.
     * @param measurement The new measurement
     * @param sensor The object that models the sensor that produced the
     *               measurement.
     */
    void notify(int measurement, Sensor sensor) {
        if (!handleNotification(measurement, sensor) && parent != null) {
            parent.notify(measurement, sensor);
        } // if
    } // notify(int, Sensor)

    /**
     * This method is called by the notify method so that this object can have
     * a chance to handle measurements.
     */
    abstract boolean handleNotification(int measurement, Sensor sensor);

    /**
     * This method is called by a child zone to report a fire.  It is
     * expected that the child zone has turned on sprinklers or taken
     * other appropriate measures to control the fire within the child
     * zone. The purpose of this method is to be overridden by other
     * subclasses so that it can take any necessary actions outside of
     * the child zone.
     */
    void fireAlarm(SecurityZone zone) {
        // Turn on sprinklers
        //...
        if (parent != null)
          parent.fireAlarm(zone);
    } // fireAlarm(SecurityZone)
} // class SecurityZone
