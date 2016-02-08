/**
 *  Driver for the Filter pattern example that comes with M. Grand
 *  Patterns in Java, Vol. 1.
 *  <P>
 *  This driver uses a new implemented word count filter
 *  in addition to the byte count filter that is part of the example.
 */

public class Main {
    /**
     *  Standard entry point.
     *  This program reads a file whose name is given in the command
     *  line and prints the number of both words and characters in the file.
     *  It is an error if there is not exactly one filename
     *  in the command line.
     *  @param arg It must contain only one element.
     *             This element must contain the name of the file to process.
     */
    public static void main (String [] arg) {
	try {
	    if (arg.length != 1)
		throw new Exception ("Must specify one filename in command line");
	    FileInStream file = new FileInStream (arg [0]);
	    ByteCountInStream bcs = new ByteCountInStream (file);
	    WordCountInStream wcs = new WordCountInStream (bcs);
	    byte [] array = new byte [80];
	    int length;
	    while ((length = wcs.read (array)) != -1) {}
	    System.out.println (wcs.getWordCount ()+"   "
                               +bcs.getByteCount ()+"   "+arg [0]);
	} catch (Exception e) {
	    System.err.println ("Exception: "+e.getMessage ());
	    e.printStackTrace ();
	}
    }
}
