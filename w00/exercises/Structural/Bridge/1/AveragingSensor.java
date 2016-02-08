/**
 * Instances of this class are used to represent sensors that produce
 * values that are the average of measurements made over a period of
 * time. 
 */
public class AveragingSensor extends SimpleSensor {
    /**
     * Constructor
     *<p>
     * This constructor is intended to be called by a factory method
     * object that is in the same package as this class and the the
     * classes that implement its operations.
     * @param impl The object that implements the sensor type-specific
     *             operations this object will provide.
     */
    AveragingSensor(AveragingSensorImpl impl) {
        super(impl);
    } // constructor(AveragingSensorImpl)

    //...

    /**
     * Averaging sensors produce a value that is the average of
     * measurements made over a period of time.  That period of time
     * begins when this method is called.
     * @exception SensorException if there is a problem accessing the
     *                            sensor.
     */
    public void beginAverage() throws SensorException {
        ((AveragingSensorImpl)getImpl()).beginAverage();
    } // beginAverage()
} // class AveragingSensor

