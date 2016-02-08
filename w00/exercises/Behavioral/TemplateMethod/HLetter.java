import java.io.*;

public class HLetter extends Letter {
    public void dots () throws IOException {
	for (int h = 0; h < rh; h++) {
	    for (int w = 0; w < rw; w++)
		dot [w] [2*rh-2-h] = dot [w] [h] = file.read () == (int) '+';
	    file.readLine ();
	}
    }
}
