/**
 * All objects that implement operations for AveragingSensor objects must
 * implement this interface.
 */
interface AveragingSensorImpl extends SimpleSensorImpl {
    /**
     * Averaging sensors produce a value that is the average of
     * measurements made over a period of time.  That period of time
     * begins when this method is called.
     * @exception SensorException if there is a problem accessing the
     *                            sensor.
     */
    public void beginAverage() throws SensorException;
} // interface AveragingSensorImpl
