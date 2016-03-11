import java.util.*;

class Mediator {
    Collection mediateds;
    void onEvent(EventIF event, Mediated subject) {
	// confer with some mediateds
	subject.doSomething();
    } 
}
