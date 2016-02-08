class Abstraction {
    ImplementationIF implementation = new GasImplementation();
    void fillup() {
	int tmp = implementation.content();
	implementation.refuel(100-tmp);
    }
    void goGreen() {
	implementation = new ElectImplementation();
    }
}
