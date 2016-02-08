/**
 * This class implements SimpleSensor operations for sensors made by
 * Hawk. 
 */
class HawkSimpleSensor implements SimpleSensorImpl {
    /**
     * Return the value of the sensor's current measurement.
     * @exception SensorException if there is a problem accessing the
     *                            sensor.
     */
    public int getValue() throws SensorException {
        int value;
        //...
	value = 345;
        return value;
    } // getValue()
} // class HawkSimpleSensor
