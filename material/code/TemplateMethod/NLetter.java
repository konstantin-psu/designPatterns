import java.io.*;

public class NLetter extends Letter {
    public void dots () throws IOException {
	for (int h = 0; h < rh; h++) {
	    for (int w = 0; w < rw; w++)
		dot [w] [h] = file.read () == (int) '+';
	    file.readLine ();
	}
    }
}
