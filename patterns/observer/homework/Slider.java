import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slider extends JSlider implements Settable {
    private Observer observer;
    Slider(Observer observer) {
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

    public void update() {
        observer.update(this, getValue());
    }
}

