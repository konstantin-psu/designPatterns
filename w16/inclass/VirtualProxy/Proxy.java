class Proxy implements Service {
    private Expensive expensive;
    public void hello() {
	System.out.println("I'm the Proxy");
	if (expensive == null) expensive = new Expensive();
	expensive.hello();
    }
}
