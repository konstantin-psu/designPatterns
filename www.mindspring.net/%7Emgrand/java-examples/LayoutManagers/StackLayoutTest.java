import java.applet.Applet;
import java.awt.*;

/**
 * This is a sample application to exercise StackLayout.
 */
public class StackLayoutTest extends Applet {
    public void init() {
        setLayout(new StackLayout());

        Label l = new Label("Stack Layout Test");
        l.setFont(new Font("TimesRoman", 0, 24));
        add(l);
        List list = new List();
        list.addItem("abc");
        list.addItem("xyz");
        list.addItem("123");
        add(list);
        add(new TextField("",20));
        add(new TextArea(5,20));
        resize(preferredSize());
    } // init()

    public void paint(Graphics g) {
        resize(preferredSize());
    } // paint(Graphics)
} // class StackLayoutTest

