import java.awt.swing.JOptionPane;

class WarningDialog implements WarningRouter {
    /**
     * This method sends a warning message to whatever destination it
     * considers appropriate.
     * @return true If caller should proceed with its current operation.
     */
    public boolean routeWarning(String warning) {
        int r;
        r = JOptionPane.showConfirmDialog(null,
                                          warning,
                                          "Warning",
                                          JOptionPane.OK_CANCEL_OPTION,
                                          JOptionPane.WARNING_MESSAGE);
        return r == 0;
    } // routeWarning(String)
} // class WarningDialog
