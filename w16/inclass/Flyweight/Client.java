class Client {
    public static void main(String [] ignore) {
	for (char c : new char[] {'a','b','a','c'}) {
	    for (int i : new int[] {9,11,13}) {
		// Glyph error = new Glyph();
		FlyweightIF glyph = FlyweightFactory.get(c,i);
		System.out.println(glyph);
	    }
	}
    }
}
