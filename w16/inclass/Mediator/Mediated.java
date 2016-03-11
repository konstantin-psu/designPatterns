class Mediated {
    Mediator mediator;    
    void onEvent(EventIF event) {
	mediator.onEvent(event, this);
    }
    void doSomething() {
    }
}
