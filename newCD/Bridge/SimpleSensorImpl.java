/**
 * All objects that implement operations for SimpleSensor objects must
 * implement this interface.
 */
interface SimpleSensorImpl {
    /**
     * Return the value of the sensor's current measurement.
     * @exception SensorException if there is a problem accessing the
     *                            sensor.
     */
    public int getValue() throws SensorException;
} // interface SimpleSensorImpl
