import java.io.*;

public class LetterFactory {
    private static final String [] cases = {
	"NONE", "NLetter",
	"VERTICAL", "VLetter",
	"HORIZONTAL", "HLetter",
    };
    public static Letter read (BufferedReader file, String symmetry) {
	for (int i = 0; i < cases.length; i += 2)
	    try {
		if (cases [i].equals (symmetry)) {
		    Letter letter
			= (Letter) Class.forName (cases [i+1]).newInstance ();
		    return letter.read (file);
		}
	    } catch (ClassNotFoundException cnfe) {
		System.err.println ("Calls not found \""+cases [i+1]+"\"");
	    } catch (InstantiationException ie) {
		System.err.println ("Instantiation exception \""+cases [i+1]+"\"");
	    } catch (IllegalAccessException iae) {
		System.err.println ("Illegal access exception \""+cases [i+1]+"\"");
	    }
	throw new RuntimeException ("Unexpected symmetry "+symmetry);
    }
}
