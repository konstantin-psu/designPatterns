/**
 * This class implements SimpleSensor operations for sensors made by
 * Eagle. 
 */
class EagleSimpleSensor implements SimpleSensorImpl {
    /**
     * Return the value of the sensor's current measurement.
     * @exception SensorException if there is a problem accessing the
     *                            sensor.
     */
    public int getValue() throws SensorException {
        int value;
        //...
        value = 123;
        return value;
    } // getValue()
} // class EagleSimpleSensor
