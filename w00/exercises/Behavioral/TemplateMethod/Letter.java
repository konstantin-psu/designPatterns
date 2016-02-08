import java.io.*;

public abstract class Letter {
    protected boolean [] [] dot;
    protected BufferedReader file;
    protected int fw;
    protected int fh;
    protected int rw;
    protected int rh;
    protected String comment;
    public Letter read (BufferedReader file) {
	try {
	    this.file = file;
	    comment ();
	    // System.out.println ("Comment: \""+comment+"\"");
	    dotsSize ();
	    // System.out.println ("Reduced size: "+rw+"x"+rh);
	    size ();
	    // System.out.println ("Full size: "+fw+"x"+fh);
	    dots ();
	} catch (IOException io) {
	    System.err.println ("IO Exception "+io.getMessage ());
	}
	return this;
    }
    public void size () throws IOException {
	fw = Integer.parseInt (file.readLine ());
	fh = Integer.parseInt (file.readLine ());
	dot = new boolean [fw] [fh];
	for (int h = 0; h < fh; h++)
	    for (int w = 0; w < fw; w++)
		dot [w] [h] = false;
    }
    public void comment () throws IOException { comment = file.readLine (); }
    private void dotsSize () throws IOException {
	rw = Integer.parseInt (file.readLine ());
	rh = Integer.parseInt (file.readLine ());
    }
    abstract void dots () throws IOException;
    public void print () {
	for (int w = 0; w < fw; w++) {
	    for (int h = fh-1; h >= 0; h--)
		System.out.print ((dot [w] [h]) ? 'X' : ' ');
	    System.out.println ();
	}
    }
}
