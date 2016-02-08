public class Tester {
    public static void main(String[] argv) {
	Position p = new Position (3, 4);
	ImmutablePositionIF ip = (ImmutablePositionIF) new Position (5, 6);
	p.setX (5);
	ip.setY (4);   // compile error
    } // main(String[])
} // class Tester
