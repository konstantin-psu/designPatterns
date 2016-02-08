class Client {
    public static void main(String [] ignore) {
	FactMethod factory = new Roman();
	Fixture fixture = factory.createFixture();
    }
    static void order(FactMethod factory, Fixture fixture) {
	// invoice
	// ship
	// reorder ...
    }
}
