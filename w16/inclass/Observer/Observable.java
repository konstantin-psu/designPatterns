import java.util.Vector;

class Observable {
    Vector<Observer> vector = new Vector<Observer>();
    void work() {
	// pretend the state changes
	for (Observer x : vector) {
	    x.update(this);
	}
    }
    void register(Observer observer) {
	vector.add(observer);
    }
}
