import java.util.ArrayList;

public class Observer {
    ArrayList<ObservableIF> observables = new ArrayList<ObservableIF>();

    void register(ObservableIF settable) {
        if (!observables.contains(settable)) {
            observables.add(settable);
        }
    }

    void update(ObservableIF settable, int value) {
        for (ObservableIF c: observables) {
            if (settable != c) {
                c.set(value);
            }
        }
    }
}
