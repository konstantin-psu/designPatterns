/**
 *  This class is a driver for a Bridge pattern exercise.
 *  <P>
 *  
 */

public class Main implements Runnable, StreamingSensorListener {
    // Assume there are 3 locations that we refer to as
    // plant, storage, and shipping.
    // We want to record measurements from each location.
    // Measurement are take every minute for an hour and
    // then are stored on disk.
    private final int PLANT = 0;
    private final int STORAGE = 1;
    private final int SHIPPING = 2;
    Thread thread = new Thread (this);
    /**
     *  Create a structure that holds measurements taken from
     *  3 sensors.  Create the sensors: a StreamingSensor,
     *  a SimpleSensor, and an AveragingSensor.
     *  Fill the structure with measurements taken at periodic
     *  intervals and print the structure after a fixed number
     *  of measures have been taken.
     */
    public void run () {
	int [] [] measure = new int [3] [60];
	int index = 0;
	try {
	    StreamingSensor plant
		= new StreamingSensor (new EagleStreamingSensor ());
	    plant.addStreamingSensorListener (this);
	    SimpleSensor shipping
		= new SimpleSensor (new HawkSimpleSensor ());
	    AveragingSensor storage
		= new AveragingSensor (new EagleAveragingSensor ());
	    storage.beginAverage ();
	    for (;;) {
		measure [PLANT] [index] = lastStreamValue;
		measure [SHIPPING] [index] = shipping.getValue ();
		measure [STORAGE] [index] = storage.getValue ();
		storage.beginAverage ();
		if (++index == 60) {
		    index = 0;
		    for (int m = 0; m < 60; m++)
			System.out.println (m+
					    "  P="+measure[PLANT][m]+
					    "  H="+measure[SHIPPING][m]+
					    "  T="+measure[STORAGE][m]);
		}
		thread.sleep (60 /* 60000 */);
	    }
	} catch (SensorException se) {
	    System.err.println ("Giving up: "+se.getMessage ());
	} catch (InterruptedException ie) {
	    System.err.println ("Giving up: "+ie.getMessage ());
	}
    }

    /**
     *  StreamingSensorListener interface method.
     *  This method stores the received value in an instance variable.
     *  @param value  The value provided by the stream.
     */
    public void processMeasurement (int value) { lastStreamValue = value; }
    private int lastStreamValue;

    /**
     *  Usual entry point.
     *  @param arg Ignored.
     */
    public static void main (String [] arg) {
	Main here = new Main ();
	here.thread.start ();
    }
}
