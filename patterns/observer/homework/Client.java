import javax.swing.*;
import java.awt.*;

public class Client extends JFrame {
    public Client() {
        Observer observer = new Observer();
        setSize(400,50);
        JPanel panel = new JPanel();
        setTitle("Observerable");
        setLayout(new GridLayout(1,2,3,3));
        Digital field1 =new Digital(observer);

        panel.add(field1, BorderLayout.LINE_START);
        Slider slider = new Slider(observer);
        panel.add(new Slider(observer));
        add(panel);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        observer.update(slider,89);
    }
}

