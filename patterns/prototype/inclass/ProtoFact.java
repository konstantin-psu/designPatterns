class ProtoFact {
    private Sink sink;
    private Faucet faucet;
    Sink createSink() { return sink.clone(); } /* covariant */
    Faucet createFaucet() {return (Faucet) faucet.clone(); }
    void setPrototypes(Sink sink, Faucet faucet) {
	this.sink = sink;
	this.faucet = faucet;
    }    
}
