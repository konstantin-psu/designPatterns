import java.io.*;

public class Main {
    private void main () {
	try {
	    for (int i = 0; i < 3; i++) {
		char [] cname = { '?', '.', 'l', 'e', 't', 't', 'e', 'r' };
		cname [0] = (char) (i + (int) 'A');
		String fname = new String (cname);
		// System.out.println (i+" "+fname);
		BufferedReader file = new BufferedReader (
		    new InputStreamReader (
  		        new FileInputStream (fname)));
		String symmetry = file.readLine ();
		// System.out.println ("Symmetry "+symmetry);
		Letter letter = LetterFactory.read (file, symmetry);
		letter.print ();
	    }
	} catch (FileNotFoundException fnf) {
	    System.err.println ("File not found "+fnf.getMessage ());
	} catch (IOException io) {
	    System.err.println ("IO Exception "+io.getMessage ());
	}
    }
    public static void main (String [] ignore) { (new Main ()).main (); }
}
