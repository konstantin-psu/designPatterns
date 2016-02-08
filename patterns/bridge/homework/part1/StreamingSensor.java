import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Vector;

/**
 * Instances of this class are used to represent sensors that produce
 * a stream of measurement values.
 */
public class StreamingSensor extends SimpleSensor implements StreamingSensorListener, Runnable {
    // These objects are used to provide a buffer that allows the
    // implementation object to asynchronously deliver measurement values
    // while this object is delivering value it has already received to its
    // listeners.
    private DataInputStream consumer;
    private DataOutputStream producer;

    private Vector listeners = new Vector(); // aggregate listeners here

    /**
     * Constructor
     *<p>
     * This constructor is intended to be called by a factory method
     * object that is in the same package as this class and the the
     * classes that implement its operations.
     * @param impl The object that implements the sensor type-specific
     *             operations this object will provide.
     * @exception SensorException if initialization of this object fails.
     */
    StreamingSensor(StreamingSensorImpl impl) throws SensorException {
        super(impl);

        // Create pipe stream that will support this object's ability
        // to deliver measurement values at the same time it is
        // receiving them. 
        PipedInputStream pipedInput = new PipedInputStream();
        consumer = new DataInputStream(pipedInput);
        PipedOutputStream pipedOutput;
        try {
            pipedOutput = new PipedOutputStream(pipedInput);
        } catch (IOException e) {
            throw new SensorException("pipe creation failed");
        } // try
        producer = new DataOutputStream(pipedOutput);

        // start a thread to deliver measurement values
        new Thread(this).start();
    } // constructor(StreamingSensorImpl)

    //...

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
        // delegate this to the implementation object
        ((StreamingSensorImpl)getImpl()).setSamplingFrequency(freq);
    } // setSamplingFrequency(int)

    /**
     * StreamingSensor objects deliver a stream of values to
     * interested objects by passing each value to the object's
     * processMeasurement method.  The delivery of values is done
     * using its own thread and is asynchronous of everyting else.
     * @param value The measurement value being delivered.
     */
    public void processMeasurement(int value) {
        try {
            producer.writeInt(value);
        } catch (IOException e) {
            // If the value cannot be delivered, just discard it.
        } // try
    } // processMeasurement(int)

    /**
     * This method registers its argument as a recipient of future
     * measurement values from this sensor.
     */
    public void addStreamingSensorListener(StreamingSensorListener listener) {
        listeners.addElement(listener);
    } // addStreamingSensorListener(StreamingSensorListener)
    
    /**
     * This method unregisters its argument as a recipient of future
     * measurement values from this sensor.
     */
    public void
    removeStreamingSensorListener(StreamingSensorListener listener) {
        listeners.removeElement(listener);
    } // addStreamingSensorListener(StreamingSensorListener)

    /**
     * This method asynchronously removes measurement values from the pipe
     * and delivers them to registered listeners.
     */
    public void run() {
        while (true) {
            int value;
            try {
                value = consumer.readInt();
            } catch (IOException e) {
                // Pipes is broken so return from this method letting
                // ths trhead die.
                return;
            } // try
            for (int i=0; i < listeners.size(); i++) {
                StreamingSensorListener listener;
                listener
                  = (StreamingSensorListener)listeners.elementAt(i);
                listener.processMeasurement(value);
            } // for
        } // while
    } // run()
} // class StreamingSensor

