interface Composite {
    String toDigits();
    Object accept(Visitor visitor);
}

class Component implements Composite {
    public String toDigits() { return "0"; }
    public Object accept(Visitor visitor) { return visitor.visit(this); }
}

class Container implements Composite {
    Composite composite;
    Container(Composite composite) { this.composite = composite; }
    public String toDigits() { return "1" + composite.toDigits(); }
    public Object accept(Visitor visitor) { return visitor.visit(this); }
}
