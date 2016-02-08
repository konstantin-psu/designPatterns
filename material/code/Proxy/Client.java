/**
 *  This class exercises a proxy of a (remote) calculator.
 */
class Client {

    /**
     *  Usual main, command line arguments are ignored.
     *  Create remote calculator proxy,
     *  request an addition, and print the result.
     *  @param ignore Ditto.
     */
    public static void main (String [] ignore) {
	Proxy proxy = new Proxy ();
	float result = proxy.add (2.2f, 6.6f);
	System.out.println ("Client: Calculator result: " + result);
    }
}
