abstract class Sink implements Cloneable {
    public Sink clone() {
	try { return (Sink) super.clone(); }
	catch(CloneNotSupportedException ex) {
	    // Ring the alarm bell
	    System.out.println("ALARM!");
	    System.exit(1);
	    return null;
	}
    }
}
