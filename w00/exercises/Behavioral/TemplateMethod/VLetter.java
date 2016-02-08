import java.io.*;

public class VLetter extends Letter {
    public void dots () throws IOException {
	for (int h = 0; h < rh; h++) {
	    for (int w = 0; w < rw; w++)
		dot [fw-1-w] [h] = dot [w] [h] = file.read () == (int) '+';
	    file.readLine ();
	}
    }
}
