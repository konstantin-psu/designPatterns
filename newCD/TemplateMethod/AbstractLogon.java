import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.swing.JDialog;
import java.awt.swing.JLabel;
import java.awt.swing.JOptionPane;

/**
 * This is an abstract class for authenticating a user for a program.
 */
public abstract class AbstractLogon {
    /**
     * This method authenticates a user.
     * @param frame The frame that will be the parent of any dialogs
     *              that this method pops up.
     * @param programName The name of the program as it should appear
     *                    when prompting the user for logon.
     */
    public void logon(Frame frame, String programName) {
        Object authenticationToken;
        LogonDialog logonDialog;
        logonDialog = new LogonDialog(frame, "Log on to "+programName);
        JDialog waitDialog = createWaitDialog(frame);
        while(true) {
            waitDialog.setVisible(false);
            logonDialog.setEnabled(true);
            logonDialog.setVisible(true);
            logonDialog.setEnabled(false);
            waitDialog.setVisible(true);
            try {
                String userID = logonDialog.getUserID();
                String password = logonDialog.getPassword();
                authenticationToken = authenticate(userID, password);
                break;
            } catch (Exception e) {
                // Tell user that authentication failed.
                JOptionPane.showMessageDialog(frame,
                                              e.getMessage(),
                                              "Authentication Failure",
                                              JOptionPane.ERROR_MESSAGE);
            } // try
        }
        // Authentication successful
        waitDialog.setVisible(false);
        logonDialog.setVisible(false);
        notifyAuthentication(authenticationToken);
    } // logon()

    private JDialog createWaitDialog(Frame parent) {
        JDialog waitDialog = new AuthenticationDialog(parent);
        return waitDialog;
    } // createWaitDialog()

    private static class AuthenticationDialog extends JDialog
                                              implements Runnable {
        private JLabel authenticating = new JLabel("Authenticating Logon");
        private Thread blinkThread;
        private static final int blinkInterval = 500;
        AuthenticationDialog(Frame parent) {
            super(parent, "Please Wait");
            authenticating.setOpaque(true);
            getContentPane().add(authenticating, BorderLayout.CENTER);
            pack();
            blinkThread = new Thread(this);
            blinkThread.start();
            addWindowListener(new MyWindowAdapter());
        } // constructor(Frame)

        public void show() {
            super.show();
            synchronized (this) {
                notifyAll();
            } // synchronized
        } // show

        /**
         * Running in its own thread, this blinks dialog's label.
         */
        public void run() {
            try {
                while (!blinkThread.isInterrupted()) {
                    if (!isShowing()) {
                        synchronized (this) {
                            while (!isShowing()) {
                                wait();
                            } // while !isShowing
                        } // synchronized
                    } // if
                    synchronized (this) {
                        Color foreground = authenticating.getForeground();
                        Color background = authenticating.getBackground();
                        authenticating.setForeground(background);
                        authenticating.setBackground(foreground);
                    } // synchronized
                    authenticating.repaint();
                    blinkThread.sleep(blinkInterval);
                } // while !isInterrupted
            } catch (InterruptedException e) {
            } // try
        } // run()

        // Respond to window events
        private class MyWindowAdapter extends WindowAdapter {
            synchronized public void windowOpened(WindowEvent e) {
                notifyAll();
                if ( !blinkThread.isAlive()
                     || blinkThread.isInterrupted()) {
                    blinkThread = new Thread(AuthenticationDialog.this);
                    blinkThread.start();
                } // if
            } // windowOpened(WindowEvent)

            synchronized public void windowClosed(WindowEvent e) {
                blinkThread.interrupt();
            } // windowClosed
            
            synchronized public void windowDeiconified(WindowEvent e) {
                notifyAll();
            } // windowDeiconified(WindowEvent)

            synchronized public void windowActivated(WindowEvent e) {
                notifyAll();
            } // windowActivated(WindowEvent)
        } // class MyWindowAdapter
    } // class AuthenticationDialog

    /**
     * Authenticate the user based on the supplied user id and password.
     * @param userID the supplied user id
     * @param password the supplied password
     * @return An object that encapsulates whatever data is needed, if
     *         any, to prove that the user has been authenticated.
     * @exception Exception Throws an Exception if the given user id and
     *                      password cannot be authenticated.  The
     *                      Exception should have a message associated
     *                      with it that is suitable for displaying to a
     *                      user.
     */
    abstract protected Object authenticate(String userID, String password)
                       throws Exception;

    /**
     * Notify the rest of the program that the user has been
     * authenticated.
     * @param authenticationToken The object returned by the
     *                            authenticate method.
     */
    abstract protected void notifyAuthentication(Object authenticationToken) ;
} // class AbstractLogon
