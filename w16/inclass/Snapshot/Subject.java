class Subject {
    static private class Memento {
	int state;
    }
    int useful_state;
    int useless_state;
    Caretaker caretaker = new Caretaker();
    void work() {
	useful_state = 23;
	useless_state = 45;
	System.out.println(useful_state);
	save();
	useful_state++;
	restore();
	System.out.println(useful_state);
    }
    void save() {
	Memento memento = new Memento();
	memento.state = useful_state;
	caretaker.put(memento);
    }
    void restore() {
	Memento memento = (Memento) caretaker.get();
	useful_state = memento.state;
    }
}
