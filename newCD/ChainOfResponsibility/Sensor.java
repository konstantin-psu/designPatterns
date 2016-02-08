/**
 * Superclass for all classes whose instances model the state of sensors.
 */
abstract class Sensor {
    /**
     * This method is called when the sensor associated with this object
     * observes a new reading.
     * @param measurement the new sensor reading.
     */
    abstract void notify(int measurement) ;
} // class Sensor
