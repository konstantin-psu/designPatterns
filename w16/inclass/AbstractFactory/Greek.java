class Greek implements AbsFact {
    public Sink createSink() { return new GreekSink(); }
    public Faucet createFaucet() { return new GreekFaucet(); }
}
