abstract class FactMethod {
    abstract Sink createSink();
    abstract Faucet createFaucet();
    final Fixture createFixture() {
	return new Fixture(createSink(), createFaucet(), createFaucet());
    }
}
