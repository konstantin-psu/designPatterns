/**
 * Instances of this class maintain a running total of the number of
 * vehicles that have passed the traffic sensors associated with the
 * instance.
 */
public class TrafficSensorController
             implements TrafficSensor.TrafficObserver {
    private int vehicleCount = 0;
    //...

    /**
     * This method is called when a traffic sensor detects a passing
     * vehicle.  It increments the vehicle count by one.
     */
    public synchronized void vehiclePassed() {
        vehicleCount++;
    } // vehiclePassed()

    /**
     * Set the vehicle count to 0.
     * @return the previous vehicle count.
     */
    public synchronized int getAndClearCount() {
        int count = vehicleCount;
        vehicleCount = 0;
        return count;
    } // getAndClearCount()
} // class TrafficSensorController

