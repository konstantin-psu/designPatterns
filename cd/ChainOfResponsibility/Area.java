/**
 * Instances of this class are used to represent an open area in a
 * warehouse, an office building or retail floor.
 */
class Area extends SecurityZone {
    //...
    /**
     * This method is called by the notify method so that this object can have
     * a chance to handle measurements.
     */
    boolean handleNotification(int measurement, Sensor sensor) {
        if (sensor instanceof TemperatureSensor) {
            if (measurement > 150) {
                fireAlarm(this);
                return true;
            } // if
        } //...
        //...
        return false;
    } // handleNotification(int, Sensor)
} // class Area
