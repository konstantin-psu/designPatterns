/**
 *  This class is a driver for VirtualProxy patterns exercise.
 *  It complements the textbook by showing that a class is
 *  loaded when the constructor is executed, but generally not before.
 *  <P>
 *  Compiling this program will result in the compilation of file
 *  <I>Expensive.java</I> and the consequent generation of file
 *  <I>Expensive.class</I>.  The latter should be <B>removed</B>
 *  before execution.  
 *  The idea is that the execution of this program will throw
 *  a <I>NoClassDefFoundError</I> exception, but not until
 *  class <I>Expensive</I> is loaded, which occurs only when
 *  the user hits the "return" key.
 */
public class Main {
    /**
     *  Standard entry point.  No argument is used.
     *  After the user hits the "return" key
     *  class <I>Expensive</I> is loaded.
     *  An exception is thrown is the class file is missing.
     */
    public static void main (String [] ignore) throws Exception {
	Proxy proxy = new Proxy ();
	System.out.print ("Hit return to load ");
	System.in.read ();
	proxy.doit ();
    }
    private static class Proxy { private void doit () { new Expensive (); } }
}
