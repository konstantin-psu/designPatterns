class Roman extends FactMethod {
    public Sink createSink() { return new RomanSink(); }
    public Faucet createFaucet() { return new RomanFaucet(); }
}
