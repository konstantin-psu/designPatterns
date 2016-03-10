import java.util.Random;

class Client {
    static GuardedSuspension subject = new GuardedSuspension();
    static class Controller extends Thread {
	public void run() {
	    subject.activateDoor();
	}
    }
    static class Simulator extends Thread {
	Random random = new Random();
	public void run() {
	    for (int i = 0; i < 10; i++) {
		try {
		    sleep(random.nextInt(1000));
		    subject.detected();
		} catch (InterruptedException ex) {
		    System.out.println("EX Simul");
		}
	    }
	}
    }
    public static void main(String [] ignore) {
	// one thread activates the door
	new Controller().start();
	// one thread simulates detections
	new Simulator().start();
    }
}
