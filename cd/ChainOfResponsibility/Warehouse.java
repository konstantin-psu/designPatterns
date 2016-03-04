/**
 * Instances of this class are used to represent a warehouse.
 */
class Warehouse extends SecurityZone {
    //...
    /**
     * This method is called by the notify method so that this object can have
     * a chance to handle measurements.
     */
    boolean handleNotification(int measurement, Sensor sensor) {
        //...
        return false;
    } // handleNotification(int, Sensor)

    /**
     * This method is called by a child zone to report a fire.  It is
     * expected that the child zone has turned on sprinklers or taken
     * other appropriate measures to control the fire within the child
     * zone. The purpose of this method is to be overridden by other
     * subclasses so that it can take any necessary actions outside of
     * the child zone.
     */
    void fireAlarm(SecurityZone zone) {
        if (zone instanceof Area) {
            // Turn on sprinklers in surrounding areas
            //...
            // Don't call super.fireAlarm because that will turn on the
            // sprinkler for the whole warehouse.
            if (getParent() != null)
              getParent().fireAlarm(zone);
            return;
        } // if
        //...
        super.fireAlarm(zone);
    } // fireAlarm(SecurityZone)
} // class Warehouse
