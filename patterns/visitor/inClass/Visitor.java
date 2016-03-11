interface Visitor {
    Object visit(Component component);
    Object visit(Container container);
}

class LetterVisitor implements Visitor {
    public Object visit(Component component) {
	return "B";
    }
    public Object visit(Container container) {
	return "A" + (String) container.composite.accept(this);
    }   
}
