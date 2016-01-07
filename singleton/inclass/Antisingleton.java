class Antisingleton {
    private static int counter = 0;
    Antisingleton() {
	if (counter == 1) {
	    // disaster
	} else {
	    counter++;
	}
    }
}
