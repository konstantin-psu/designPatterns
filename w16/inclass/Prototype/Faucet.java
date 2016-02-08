abstract class Faucet {
    public Object clone() {
	try { return super.clone(); }
	catch(CloneNotSupportedException ex) {
	    // Ring the alarm bell
	    System.out.println("ALARM!");
	    System.exit(1);
	    return null;
	}
    }
}

