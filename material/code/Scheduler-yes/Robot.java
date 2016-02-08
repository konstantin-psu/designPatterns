/**
 *  This class abstracts a robot that delivers a parcel of mail.
 *  The delivery is simulated by a useless computation of a certain duration.
 */
public class Robot {
    private Scheduler scheduler = new Scheduler ();
    /**
     *  Simulate the delivery of a parcel.
     *  This method is synchronized under the assumption that there
     *  is only one robot.  When the robot is deliverying a parcel
     *  for a client, no other client can use the delivery service.
     *  @param id  Id of the client requesting the delivery.
     *  @param fuse Nominal time at which the delivery should be started.
     *              If too many clients requests too many deliveries,
     *              the delivery of a client may be delayed.
     *  @param priority The priority of the parcel to deliver.
     *  @param duration The amount of time necessary for the delivery.
     *                  The robot wastes time to simulate the delivery.
     */
    public void deliver (int id, int fuse, 
			 int priority, int duration) {
	try {
	    scheduler.enter ();
	    long time = Main.now();
	    System.out.println (time+" Exec. for client "+id+
				"  (delay="+(time-fuse)+")");
	    // simulate the time it takes for the delivery
	    // it includes (!?) the time to move to the next origin
	    long start = System.currentTimeMillis ();
	    while (System.currentTimeMillis () - start < duration) {}
	    System.out.println ("Robot waited "+
				(System.currentTimeMillis ()-start)+
				" msec for client "+id);	    
	} catch (InterruptedException ie) {}
	scheduler.done ();
    }
}
