class Roman implements AbsFact {
    public Sink createSink() { return new RomanSink(); }
    public Faucet createFaucet() { return new RomanFaucet(); }
}
