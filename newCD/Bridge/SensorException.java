/**
 * Instances of this class are thrown by methods that access sensors
 * when they encounter an error in accessing a sensor.
 */
public class SensorException extends Exception {
    /**
     * Constructor
     * @param msg The message string to associate with this exception
     *            object.
     */
    public SensorException(String msg) {
        super(msg);
    } // Constructor(String)
} // class SensorException

