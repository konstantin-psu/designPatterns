class GuardedSuspension {
    boolean isOpen = false;
    boolean detection = false;
    synchronized void activateDoor() {
	while (true) {
	    // be ready to open door when detection
	    while (! detection) {
		try {
		    Logger.log("Waiting");
		    wait();
		} catch (InterruptedException ex) {
		    System.out.println("EX");
		}
	    }
	    // balking
	    if (isOpen) {
		Logger.log("Balking");
	    } else {
		openDoor();
	    }
	    detection = false;
	}
    }
    synchronized void detected() {
	Logger.log("Detection");
	detection = true;
	notify();
    }
    void openDoor() {
	class Timer extends Thread {
	    synchronized public void run() {
		try {
		    wait(1000);
		    Logger.log("Closing");
		    isOpen = false;
		} catch (InterruptedException ex) {
		    System.out.println("EX");
		}
	    }
	}
	Logger.log("Opening");
	isOpen = true;
	new Timer().start();
    }
}
