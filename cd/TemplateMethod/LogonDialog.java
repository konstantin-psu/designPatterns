import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.swing.*;

/**
 * General purpose logon dialog
 */
public class LogonDialog extends JDialog {
    private JTextField userField;
    private JTextField passwordField;

    /**
     * constructor
     * @param parent The logon dialog's parent frame.
     * @param title The title to display at the top to the dialog.
     */
    public LogonDialog(Frame parent, String title) {
        super(parent, title, true);
        
        GridBagLayout gb = new GridBagLayout();
        JPanel centerPanel = new JPanel(gb);
        GridBagConstraints labelConstraints = new GridBagConstraints();
        labelConstraints.anchor = GridBagConstraints.NORTHWEST;
        labelConstraints.insets = new Insets(5,0,0,0);
        GridBagConstraints fieldConstraints = new GridBagConstraints();
        fieldConstraints.anchor = GridBagConstraints.NORTHWEST;
        fieldConstraints.gridwidth = GridBagConstraints.REMAINDER;
        fieldConstraints.insets = new Insets(5,3,0,0);
        JLabel userLabel = new JLabel("User ID:");
        gb.setConstraints(userLabel, labelConstraints);
        centerPanel.add(userLabel);
        userField = new JTextField(10);
        gb.setConstraints(userField, fieldConstraints);
        centerPanel.add(userField);
        JLabel passwordLabel = new JLabel("Password:");
        gb.setConstraints(passwordLabel, labelConstraints);
        centerPanel.add(passwordLabel);
        passwordField = new JPasswordField(10);
        gb.setConstraints(passwordField, fieldConstraints);
        centerPanel.add(passwordField);
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        JButton okButton = new JButton("OK");
        buttonPanel.add(okButton);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        okButton.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setVisible(false);
            } // actionPerformed(ActionEvent)
          }  );
        pack();
    } // LogonDialog(Frame, String)

    /**
     * Return the user id that the user specified.
     */
    public String getUserID() {
        return userField.getText();
    } // getUserID()

    /**
     * Return the password that was specified
     */
    public String getPassword() {
        return passwordField.getText();
    } // getPassword()
} // class LogonDialog

