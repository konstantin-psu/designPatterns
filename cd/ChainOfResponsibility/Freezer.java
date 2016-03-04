/**
 * Instances of this class are used to represent a Freezer.
 */
class Freezer extends SecurityZone {
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
            if (measurement > 30) {
                // sound alarm that freezer is too warm
                //...
            } // if
        } //...
        //...
        return false;
    } // handleNotification(int, Sensor)
} // class Freezer
