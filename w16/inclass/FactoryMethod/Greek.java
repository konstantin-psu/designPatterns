class Greek extends FactMethod {
    public Sink createSink() { return new GreekSink(); }
    public Faucet createFaucet() { return new GreekFaucet(); }
}
