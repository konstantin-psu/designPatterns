/**
 * Instances of this class are associated with a traffic
 * sensor.  A traffic sensor detects the passing of a vehicle over a
 * place in a traffic lane.  When the traffic sensor associated with an
 * instance of this class detects a passing vehicle, the instance's
 * detect method is called.  Its detect method is responsible for
 * notifying other interested objects of the passing vehicle.
 */
public class TrafficSensor implements Runnable {
    private TrafficObserver observer;

    /**
     * Constructor
     * @param observer The object to notify when this object's associated
     *                 traffic sensor detects a passing vehicle.
     */
    public TrafficSensor(TrafficObserver observer) {
        this.observer = observer;
        new Thread(this).start();
    } // constructor(TrafficObserver)

    /**
     * Top level logic for this object's thread.
     */
    public void run() {
        monitorSensor();
    } // run()

    /**
     * This method is responsible for calling this object's detect when
     * its associated traffic sensor detects a passing vehicle.
     */
    private native void monitorSensor() ;

    /**
     * This method is called by the monitorSensor method to report the
     * passing of a vehicle to this object's observer.
     */
    private void detect() {
        observer.vehiclePassed();
    } // detect()

    //...

    /**
     * Classes must implement this interface to be notified of passing
     * vehicles by a TrafficSensor object.
     */
    public interface TrafficObserver {
        /**
         * This is called when a TrafficSensor detects a passing vehicle.
         */
        public void vehiclePassed();
    } // interface TrafficObserver
} // class TrafficSensor

