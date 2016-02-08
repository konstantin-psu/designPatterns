import pattpack.image.Image;

/**
 *  Driver for a LayeredInitialization pattern example.
 */
public class Main {
    /**
     *  Usual entry point.
     *  Takes one command line argument and attempts to create
     *  and image.  The creation depends on the image type (gif,
     *  jpeg, etc.), but the user is shielded from detail by
     *  the LayeredInitialization pattern.
     *  @param arg Only one element is accepted.  It is the name of the
     *             file containing the image.  The suffix identifies
     *             the type of the image, e.g., gif, jpeg, png.
     */
    public static void main (String [] arg) {
        if (arg.length != 1) {
	    System.err.println ("Exactly one argument required: a filename");
	    System.exit (1);
	}
	Image image = new Image (arg [0]);
    }
}
