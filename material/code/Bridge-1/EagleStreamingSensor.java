/**
 * This class impelments StreamingSensor operations for sensors made
 * by Eagle.
 */
class EagleStreamingSensor extends EagleSimpleSensor implements StreamingSensorImpl {
    /**
     * Streaming sensors produce a stream of measurement values.  The
     * stream of values is produced with a frequency no greater than
     * the given number of times per minute.
     * @param freq The maximum number of times per minute that this
     *             streaming sensor will produce a measurement value.
     * @exception SensorException if there is a problem accessing the
     *                            sensor.
     */
    public void setSamplingFrequency(int freq) throws SensorException {
        //...
    } // setSamplingFrequency(int)

    /**
     * This method is called by an object than represents the
     * streaming sensor abstraction so that this object can perform a
     * call-back to that object to deliver measurement values to it.
     * @param abstraction The abstraction object to deliver
     *                    measurement values to.
     */
    public void setStreamingSensorListener(StreamingSensorListener listener) {
        //...
    } // setStreamingSensorListener(StreamingSensorListener)
} // class EagleStreamingSensor
