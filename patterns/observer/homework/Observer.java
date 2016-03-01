import java.util.ArrayList;

public class Observer {
    private ArrayList<ObservableIF> observables = new ArrayList<ObservableIF>();

    public void register(ObservableIF observable) {
        if (!observables.contains(observable)) {
            observables.add(observable);
        }
    }

    public void update(ObservableIF observable, int value) {
        for (ObservableIF c: observables) {
            if (observable != c) {
                c.set(value);
            }
        }
    }
}
