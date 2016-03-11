import java.util.Hashtable;

class FlyweightFactory {
    private FlyweightFactory() {}  // singleton
    private static class Glyph implements FlyweightIF {
	final char c; final int i;
	Glyph(char c, int i) { 
	    System.out.println("constructing");
	    this.c = c; 
	    this.i = i; 
	}
	public String toString() { return ("glyph " + c + " " + i); }
    }
    static Hashtable first = new Hashtable();
    static FlyweightIF get(char c, int i) {
	Hashtable second = (Hashtable) first.get(c);
	if (second == null) {
	    second = new Hashtable();
	    first.put(c,second);
	}
	Glyph glyph = (Glyph) second.get(i);
	if (glyph == null)  {
	    glyph = new Glyph(c,i);
	    second.put(i,glyph);
	}
	return glyph;
    }
}
