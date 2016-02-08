/**
 * Instances of this class are responsible for transmitting the number
 * of vehicles that have passed a place in the road every minute.
 */
public class TrafficTransmitter implements Runnable {
    private TrafficSensorController controller;
    private Thread myThread;

    /**
     * constructor.
     * @param controller The TrafficSensorController that this object
     *                   will get vehicle counts from.
     */
    public TrafficTransmitter(TrafficSensorController controller) {
        this.controller = controller;
        //...
        myThread = new Thread(this);
        myThread.start();
    } // constructor(TrafficSensorController)

    /**
     * transmit a vehicle count every minute
     */
    public void run() {
        while (true) {
            try {
                myThread.sleep(60*1000);
                transmit(controller.getAndClearCount());
            } catch (InterruptedException e) {
            } // try
        } // while
    } // run()

    /**
     * Transmit a vehicle count.
     */
    private native void transmit(int count) ;
} // class TrafficTransmitter
