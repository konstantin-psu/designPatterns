/**
 * This class is a driver for the Immutable interface.
 * It shows that an interface can be used to hide an object's
 * state changing methods.
 * <P>
 * It does not prevent casting away the "immutability".
 * One could make Position a private class nested in a factory.
 * If Position implements Mutable, a position object can be
 * casted to Mutable and fool the purpose.
 * Use a proxy for a foolproof solution
 * <P>
 * The compiler will report an error when compiling this program.
 */


class Tester {
    /**
     *  Usual entry point.
     *  @param ignore Ditto.
     */
    public static void main(String[] ignore) {
	MutablePosition p = new Position (3, 4);
	ImmutablePosition ip = new Position (7, 8);
	p.setX (5);
	ip.getX ();

        // Tests
	// ip.setY (3);                   // compile error
        ((Position) ip).setY (3);         // allowed, hide Position
        ((MutablePosition) ip).setY (3);  // allowed, use a proxy

    } // main(String[])
} // class Tester
