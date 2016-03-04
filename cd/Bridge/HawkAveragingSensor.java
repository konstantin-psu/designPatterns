/**
 * This class impelments AveragingSensor operations for sensors made
 * by Hawk.
 */
class HawkAveragingSensor extends HawkSimpleSensor implements AveragingSensorImpl {
    /**
     * Averaging sensors produce a value that is the average of
     * measurements made over a period of time.  That period of time
     * begins when this method is called.
     * @exception SensorException if there is a problem accessing the
     *                            sensor.
     */
    public void beginAverage() throws SensorException {
        //...
    } // beginAverage()
} // class HawkAveragingSensor
