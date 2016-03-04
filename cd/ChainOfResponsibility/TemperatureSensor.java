/**
 * Instances of this class model the state of a temperature sensor.
 */
class TemperatureSensor extends Sensor {
    private SecurityZone zone;
    //...
    /**
     * When the temperature sensor associated with this object observes a
     * different temperature this method is called.
     * @param measurement The new temperature.
     */
    void notify(int measurement) {
        zone.notify(measurement, this);
    } // notify(int)
} // class TemperatureSensor
