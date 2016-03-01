import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.awt.event.ActionEvent;

public class TextBox extends JTextField implements ObservableIF {
    private Observer observer;
    public TextBox(Observer observer) {
        this.observer = observer;
        this.observer.register(this);
        setColumns(3);
        setText("0");
        setVisible(true);

        // Update on return
        Action action = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                update();
            }
        };
        addActionListener(action);
        setFilter();
    }

    public void set(int value) {
        setText(value + "");
    }

    private void update() {
        observer.update(this,new Integer(getText()));
    }

    /**
     *  Setup the field to limit the text area to numeric input of max length 3
     */
    private void setFilter() {

        PlainDocument doc = (PlainDocument) getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            private boolean isValid(String testText) {
                if (testText.length() > 3) {
                    return false;
                }
                if (testText.isEmpty()) {
                    return true;
                }
                int intValue = 0;
                try {
                    intValue = Integer.parseInt(testText.trim());
                } catch (NumberFormatException e) {
                    return false;
                }
                if (intValue < 0 || intValue > 100) {
                    return false;
                }
                return true;
            }

            @Override
            public void insertString(FilterBypass fb, int offset, String text,
                                     AttributeSet attr) throws BadLocationException {
                StringBuilder sb = new StringBuilder();
                sb.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
                sb.insert(offset, text);
                if (isValid(sb.toString())) {
                    super.insertString(fb, offset, text, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length,
                                String text, AttributeSet attrs) throws BadLocationException {
                StringBuilder sb = new StringBuilder();
                sb.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
                int end = offset + length;
                sb.replace(offset, end, text);
                if (isValid(sb.toString())) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            @Override
            public void remove(FilterBypass fb, int offset, int length)
                    throws BadLocationException {
                StringBuilder sb = new StringBuilder();
                sb.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
                int end = offset + length;
                sb.delete(offset, end);
                if (isValid(sb.toString())) {
                    super.remove(fb, offset, length);
                }
            }
        });

    }

}
