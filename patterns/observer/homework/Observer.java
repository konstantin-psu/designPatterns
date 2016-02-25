import java.util.ArrayList;

public class Observer {
    ArrayList<Settable> observabals = new ArrayList<Settable>();

    void register(Settable settable) {
        if (!observabals.contains(settable)) {
            observabals.add(settable);
        }
    }

    void update(Settable settable, int value) {
        for (Settable c: observabals) {
            if (settable != c) {
                c.set(value);
            }
        }
    }
}
