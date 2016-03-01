import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slider extends JSlider implements ObservableIF {
    private Observer observer;
    public Slider(Observer observer) {
        super(0,100);
        this.observer = observer;
        this.observer.register(this);
        addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                update();
            }
        });
    }

    public void set(int value) {
        setValue(value);
    }

    private void update() {
        observer.update(this, getValue());
    }
}

