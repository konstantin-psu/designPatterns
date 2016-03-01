import javax.swing.*;
import java.awt.*;

public class Client extends JFrame {
    public Client() {
	// Create  and setup main window
        JPanel panel = new JPanel();
        setSize(400,50);
        setTitle("Observer Assignment");
        setLayout(new GridLayout(1,2,3,3));

        Observer observer = new Observer();

        Digital field1 =new Digital(observer);
        Slider slider = new Slider(observer);

	// Set up main window layout and various attributes
        panel.add(field1, BorderLayout.LINE_START);
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

