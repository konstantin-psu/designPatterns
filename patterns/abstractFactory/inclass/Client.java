class Client {
    public static void main(String [] ignore) {
	AbsFact factory = new Roman();
	order(factory, new Quantity());
    }
    static void order(AbsFact factory, Quantity quantity) {
	// invoice
	// ship
	// reorder ...
    }
}
