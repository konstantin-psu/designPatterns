/**
 *  This class implements the client of a service.
 *  An object of this class is created with a fuse.
 *  When the fuse is over the client requests a service.
 *  The service has both a priority and a duration.
 *  The client is a thread that dies once the service is completed.
 */

public class Client extends Thread {
    private int id;
    private int priority;
    private int fuse;
    private int duration;
    private Robot robbie;
    /**
     *  Construct this client.
     *  @param id  Client's id.  Used for tracing the execution.
     *  @param fuse  Client's fuse.  When the fuse is over,
     *               the client requests a service.
     *  @param priority  Priority of the service requested by this client.
     *  @param duration  Duration of the service requested by this client.
     *  @param robbie  Robot to which the client asks the service.
     */
    public Client (int id, int fuse, int priority, int duration, Robot robbie) {
	this.id = id;
	this.priority = priority;
	this.fuse = fuse;
        this.duration = duration;
        this.robbie = robbie;
	start ();
    }
    /**
     *  Client behavior.
     *  Sleep until the fuse is over, then ask the service to the robot.
     */
    public void run () {
	System.out.println (Main.now()+" Created client "+id+
			    " with fuse="+fuse+
			    ", priority="+priority+
			    ", duration="+duration);
	try {
	    sleep (fuse-Main.now()); 
	    long time = Main.now();
	    System.out.println (time+" Req. from client "+id+
				"  (delay="+(time-fuse)+")"+
				", priority="+priority);
	    robbie.deliver (id, fuse, priority, duration);
	} catch (InterruptedException ie) {}
    }
}
