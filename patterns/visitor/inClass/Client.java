class Client {
    public static void main(String [] ignore) {
	Composite testme = new Container(new Container(new Component()));
	System.out.println(testme.toDigits());
	Visitor visitor = new LetterVisitor();
	System.out.println(testme.accept(visitor));
    }
}
