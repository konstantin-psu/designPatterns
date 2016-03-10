class GuardedSuspension {
    boolean detection = false;
    synchronized void activateDoor() {
	while (true) {
	    // be ready to open door when detection
	    while (! detection) {
		try {
		    System.out.println("Waiting");
		    wait();
		} catch (InterruptedException ex) {
		    System.out.println("EX");
		}
	    }
	    // open door
	    System.out.println("Opening");
	    detection = false;
	}
    }
    synchronized void detected() {
	System.out.println("Detection");
	detection = true;
	notify();
    }
}
