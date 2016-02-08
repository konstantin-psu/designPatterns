class Component {
    int x;
    Component(int x) { this.x = x; }
    void pp(int depth) {
	indent(depth);
	System.out.println(x);
    }
    void indent(int depth) {
	for (int i = 0; i < depth; i++) {
	    System.out.print("- ");
	}
    }
}
