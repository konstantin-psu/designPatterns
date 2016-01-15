class Client {
    public static void main(String [] ignore) {
	ProtoFact factory = new ProtoFact();
	factory.setPrototypes(new RomanSink(), new RomanFaucet());
	order(factory, new Quantity());
    }
    static void order(ProtoFact factory, Quantity quantity) {
	Sink sink = factory.createSink();
	// Faucet sink = factory.createFaucet(); will crash!!!
	// invoice
	// ship
	// reorder ...
    }
}
