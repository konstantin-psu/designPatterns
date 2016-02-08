/**
 * This interface is implemented by all objects that are able to receive
 * a stream of measurement values.
 */
public interface StreamingSensorListener {
    /**
     * StreamingSensor objects deliver a stream of values to
     * interested objects by passing each value to the object's
     * processMeasurement method.  The delivery of values is done
     * using its own thread and is asynchronous of everyting else.
     * @param value The measurement value being delivered.
     */
    public void processMeasurement(int value);
} // interface StreamingSensorListener
