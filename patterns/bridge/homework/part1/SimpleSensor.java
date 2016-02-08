/**
 * Instances of this class are used to represent all kinds of sensors.
 * Instances of subclasses of this class represent specialized kinds of
 * sensors.
 */
public class SimpleSensor {
    // A reference to the object that implements operations specific to
    // the actual sensor device that this object represents.
    private SimpleSensorImpl impl;

    /**
     * Constructor
     *<p>
     * This constructor is intended to be called by a factory method
     * object that is in the same package as this class and the the
     * classes that implement its operations.
     * @param impl The object that implements the sensor type-specific
     *             operations this object will provide.
     */
    SimpleSensor(SimpleSensorImpl impl) {
        this.impl = impl;
    } // constructor(SimpleSensorImpl)

    /**
     * This method allows subclasses of this class to get the reference
     * to the implementation object.
     */
    protected SimpleSensorImpl getImpl() {
        return impl;
    } // getImpl()

    //...

    /**
     * Return the value of the sensor's current measurement.
     * @exception SensorException if there is a problem accessing the
     *                            sensor.
     */
    public int getValue() throws SensorException {
        return impl.getValue();
    } // getValue()
} // class SimpleSensor

