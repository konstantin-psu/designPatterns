import java.awt.*;
import java.awt.event.*;
import java.awt.swing.*;
import java.awt.swing.border.*;
import java.awt.swing.event.DocumentEvent;
import java.awt.swing.event.DocumentListener;
import java.awt.swing.event.ListSelectionEvent;
import java.awt.swing.event.ListSelectionListener;
import java.awt.swing.text.JTextComponent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Dialog for entering banquet room reservations
 */
class BanquetReservationDialog extends JDialog {
    // Values of dialog attributes
    private int peopleCount = PEOPLE_COUNT_DEFAULT;
    private Date date = null;
    private Date startTime = null;
    private Date endTime = null;
    private int serviceType = UNKNOWN_SERVICE;

    /**
     * Type of service has not been set.
     */
    public static final int UNKNOWN_SERVICE = 0;

    /**
     * Banquet line service
     */
    public static final int BANQUET_SERVICE = 1;

    /**
     * Table service.
     */
    public static final int TABLE_SERVICE = 2;

    /**
     * Minimum number of people for a banquet.
     */
    public final static int MIN_PEOPLE = 25;

    /**
     * Maximum number of people for a banquet.
     */
    public final static int MAX_PEOPLE = 1600;

    /**
     * The value for number of people when no values has been specified.
     */
    public final static int PEOPLE_COUNT_DEFAULT = 0;

    /**
     * Constructor
     * @param Frame The parent frame of this dialog
     */
    BanquetReservationDialog(Frame parent) {
        super(parent, "Banquet Room Reservation");
        BanquetMediator mediator = new BanquetMediator();
        Container contentPane = getContentPane();
        contentPane.add(createDispositionPanel(mediator),
                        BorderLayout.SOUTH);
        contentPane.add(createBodyPanel(mediator), BorderLayout.CENTER);
        contentPane.add(createTopPanel(mediator), BorderLayout.NORTH);
        pack();
    } // constructor(Frame)

    // create panel with OK and Cancel Buttons
    private JPanel createDispositionPanel(BanquetMediator mediator) {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        JButton okButton = new JButton("OK");
        mediator.registerOkButton(okButton);
        p.add(okButton);
        JButton cancelButton = new JButton("Cancel");
        p.add(cancelButton);
        return p;
    } // createDispositionPanel()

    // create top panel
    private JPanel createTopPanel(BanquetMediator mediator) {
        JPanel top = new JPanel(new BorderLayout(10, 5));
        JPanel countPanel;
        countPanel = new JPanel();
        countPanel.add(new JLabel("Number of People (25-1600):"));
        JTextField countField = new JTextField(4);
        mediator.registerPeopleCountField(countField);
        countPanel.add(countField);
        top.add(countPanel, BorderLayout.WEST);

        return top;
    } // createTopPanel()

    // create panel that will be the body of the dialog
    private JPanel createBodyPanel(BanquetMediator mediator) {
        JPanel bodyPanel = new JPanel(new BorderLayout(5,5));
        bodyPanel.add(new JSeparator(), BorderLayout.NORTH);
        bodyPanel.add(createMainPanel(mediator), BorderLayout.CENTER);
        bodyPanel.add(new JSeparator(), BorderLayout.SOUTH);
        return bodyPanel;
    } // createBodyPanel()
    
    // Create main panel that allows selection of the banquet details.
    private Container createMainPanel(BanquetMediator mediator) {
        JPanel mainPanel;
        mainPanel= new JPanel(new BorderLayout(5,3));
        mainPanel.add(createDateTimePanel(mediator), BorderLayout.WEST);
        mainPanel.add(createServicePanel(mediator), BorderLayout.CENTER);
        String foods[]= { "Roast Beef", "Egg Rolls", "Shish Kebob",
                          "Burritos", "Lasagna", "Ham", "Veal Marsala",
                          "Saurbraten", "Beef Wellington",
                          "Mesquite Chicken"};
        JList foodList = new JList(foods);
        int mode = ListSelectionModel.MULTIPLE_INTERVAL_SELECTION;
        foodList.setSelectionMode(mode);
        foodList.setVisibleRowCount(7);
        mediator.registerFoodList(foodList);
        mainPanel.add(foodList, BorderLayout.EAST);

        return mainPanel;
    } // createMainPanel()

    // Create date and time panel
    private Container createDateTimePanel(BanquetMediator mediator) {
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints labelConstraints = new GridBagConstraints();
        labelConstraints.anchor = GridBagConstraints.NORTHWEST;
        labelConstraints.insets = new Insets(5,0,0,0);
        labelConstraints.weighty = 0;
        GridBagConstraints fieldConstraints = new GridBagConstraints();
        fieldConstraints.anchor = GridBagConstraints.NORTHWEST;
        fieldConstraints.gridwidth = GridBagConstraints.REMAINDER;
        fieldConstraints.insets = new Insets(5,3,0,0);
        fieldConstraints.weighty = 0;
        JPanel datePanel = new JPanel(gb);
        JLabel dateLabel = new JLabel("Date (MM/DD/YY):");
        gb.setConstraints(dateLabel, labelConstraints);
        datePanel.add(dateLabel);
        JTextField dateField = new JTextField(10);
        mediator.registerDateField(dateField);
        gb.setConstraints(dateField, fieldConstraints);
        datePanel.add(dateField);
        JLabel startLabel = new JLabel("Start Time (HH:MM):");
        gb.setConstraints(startLabel, labelConstraints);
        datePanel.add(startLabel);
        JTextField startField = new JTextField(7);
        mediator.registerStartField(startField);
        gb.setConstraints(startField, fieldConstraints);
        datePanel.add(startField);
        JLabel endLabel = new JLabel("End Time (HH:MM):");
        labelConstraints.weighty = 1;
        gb.setConstraints(endLabel, labelConstraints);
        datePanel.add(endLabel);
        JTextField endField = new JTextField(7);
        mediator.registerEndField(endField);
        fieldConstraints.weighty = 1;
        gb.setConstraints(endField, fieldConstraints);
        datePanel.add(endField);
        return datePanel;
    } // createDateTimePanel()

    // create panel to select buffet or table service
    private Container createServicePanel(BanquetMediator mediator) {
        ButtonGroup serviceGroup = new ButtonGroup();
        JRadioButton tableServiceButton
          = new JRadioButton("Table Service");
        mediator.registerTableButton(tableServiceButton);
        serviceGroup.add(tableServiceButton);
        JRadioButton buffetButton = new JRadioButton("Buffet Line");
        mediator.registerBuffetButton(buffetButton);
        serviceGroup.add(buffetButton);

        JPanel servicePanel = new JPanel();
        servicePanel.setLayout(new BoxLayout(servicePanel,
                                             BoxLayout.Y_AXIS));
        servicePanel.setBorder(BorderFactory.createTitledBorder("Service"));
        servicePanel.add(tableServiceButton);
        servicePanel.add(buffetButton);
        JPanel pad = new JPanel();
        pad.add(servicePanel);
        return pad;
    } // createServicePanel

    /**
     * Return the number of people the banquet is for.
     * @return The of people or PEOPLE_COUNT_DEFAULT if the number of
     *         people has has not been specified.
     */
    public int getPeopleCount() { return peopleCount; }

    /**
     * Return the start Calendar for the banquet.
     */
    private Calendar getStartCalendar() {
        if (startTime == null || date == null)
          return null;
        return new GregorianCalendar(date.getYear(),
                                     date.getMonth(),
                                     date.getDate(),
                                     startTime.getHours(),
                                     startTime.getMinutes(),
                                     0);
    } // getStartCalendar()

    /**
     * Return the start time for the banquet.
     * @return The start time as a Date object or null
     */
    public Date getStartTime() {
        Calendar cal = getStartCalendar();
        return (cal == null) ? null : cal.getTime();
    } // getStartTime()

    /**
     * Return the end calendar for the banquet.
     */
    private Calendar getEndCalendar() {
        if (endTime == null || date == null)
          return null;
        return new GregorianCalendar(date.getYear(),
                                     date.getMonth(),
                                     date.getDate(),
                                     endTime.getHours(),
                                     endTime.getMinutes(),
                                     0);
    } // getEndCalendar()

    /**
     * Return the end time for the banquet.
     * @return The end time as a Date object or null
     */
    public Date getEndTime() {
        Calendar cal = getEndCalendar();
        return (cal == null) ? null : cal.getTime();
    } // getEndTime()

    /**
     * return the selected type of serivce.
     */
    public int getServiceType() { return serviceType; }

    /**
     * This class is resonsible for the higher level behavior of this
     * dialog. 
     */
    private class BanquetMediator {
        // The text field that contains the number of people.
        private JTextComponent peopleCountField;

        // This mediator enables/disables these buttons and fields.
        private JButton okButton;
        private JTextComponent dateField;
        private JTextComponent startField;
        private JTextComponent endField;
        private JToggleButton buffetButton;
        private JToggleButton tableServiceButton;
        private JList foodList;

        private ItemAdapter itemAdapter = new ItemAdapter();
        private ListSelectionAdapter listSelectionAdapter
          = new ListSelectionAdapter();

        private boolean busy = false;

        /**
         * Constructor.
         */
        BanquetMediator() {
            WindowAdapter windowAdapter = new WindowAdapter() {
                /**
                 * Invoked when a window has been opened.
                 */
                public void windowOpened(WindowEvent e) {
                    initialState();
                } // windowOpened(WindowEvent)
              };
            addWindowListener(windowAdapter);
        } // Constructor()

        /**
         * This class is an adapter that allows the mediator to handle
         * ListSelection events.
         */
        private
        class ListSelectionAdapter implements ListSelectionListener {
            /** 
             * Invoked when a list item has been selected or deselected.
             */
            public void valueChanged(ListSelectionEvent e) {
                enforceInvariants();
            } // valueChanged(ListSelectionEvent)
        } // class ListSelectionAdapter

        /**
         * This class is an adapter that allows the mediator to handle
         * ItemStateChanged events.
         */
        private class ItemAdapter implements ItemListener {
            /** 
             * Invoked when an item has been selected or deselected.
             */
            public void itemStateChanged(ItemEvent e) {
                enforceInvariants();
            } // itemStateChanged(ItemEvent)
        } // class ItemAdapter

        /**
         * This class is an adapter that allows the mediator to handle
         * Document events.
         */
        private abstract class DocumentAdapter implements DocumentListener {
            /**
             * Gives notification that there was an insert.
             * @param e the document event
             */
            public void insertUpdate(DocumentEvent e) {
                parseDocument();
                enforceInvariants();
            } // insertUpdate(DocumentEvent)

            /**
             * Gives notification that a portion of the document has
             * been removed.
             * @param e the document event
             */
            public void removeUpdate(DocumentEvent e) {
                parseDocument();
                enforceInvariants();
            } // removeUpdate(DocumentEvent)

            /**
             * Gives notification of an attribute change.
             * @param e the document event
             */
            public void changedUpdate(DocumentEvent e) {
                parseDocument();
                enforceInvariants();
            } // changedUpdate(DocumentEvent)

            /**
             * Subclasses of this class override this method to parse
             * the document and set the value of an instance variable.
             */
            protected abstract void parseDocument();
        } // class DocumentAdapter

        /**
         * Set the components of this dialog to their initial state.
         */
        private void initialState() {
            peopleCount = PEOPLE_COUNT_DEFAULT;
            startTime = null;
            endTime = null;
            serviceType = UNKNOWN_SERVICE;
            peopleCountField.setText("");
            peopleCountField.setEnabled(true);
            dateField.setText("");
            dateField.setEnabled(false);
            startField.setText("");
            startField.setEnabled(false);
            endField.setText("");
            endField.setEnabled(false);
            tableServiceButton.setSelected(false);
            tableServiceButton.setEnabled(false);
            buffetButton.setSelected(false);
            buffetButton.setEnabled(false);
            foodList.clearSelection();
            foodList.setEnabled(false);
            okButton.setEnabled(false);
        } // initialState()

        /**
         * Enforce the dialog's invariants by calling
         * protectedEnforceInvariants if it is not being called
         * recursively. 
         */
        private void enforceInvariants() {
            // The following does not need to be synchronized because
            // the Java event model specifies synchronous delivery of
            // events. 
            if (busy)
              return;
            busy = true;
            protectedEnforceInvariants();
            busy = false;
        } // enforceInvariants()

        /**
         * This method ensures that all of the dialog's invariants are
         * observed. The invariants are
         *<UL>
         *<LI>
         * The date, start time and end time field are enabled if and
         * only if the number of people field contains a valid
         * value.</LI>
         *<LI>
         * If the radio buttons are disabled then they are in an
         * unselected state. </LI>
         *<LI>
         * The food list is enabled if and only if the date, start time
         * and end time fields are enabled and contain valid values, end time
         * is at least one hour later than start time and the buffet button
         * or table button is selected. </LI>
         *<LI>
         * The OK button is enabled if and only it the food list is
         * enabled and one or more foods on the list has been selected.
         * </LI>
         *</UL>
         */
        private void protectedEnforceInvariants() {
            // set enable to true if number of people has been set.
            boolean enable = (peopleCount !=  PEOPLE_COUNT_DEFAULT);

            // Date, start, end, buffet button and table button are
            // enabled if, and only if, a valid value is in the number
            // of people field.
            dateField.setEnabled(enable);
            startField.setEnabled(enable);
            endField.setEnabled(enable);
            buffetButton.setEnabled(enable);

            tableServiceButton.setEnabled(enable);
            if (enable) {
                // Food list is enabled if and only if date or time
                // fields or radio buttons are enabled and end time is
                // at least one hour later than start time and the
                // buffet button or table button is selected.
                enable = (buffetButton.isSelected()
                          || tableServiceButton.isSelected());
                foodList.setEnabled(endAtLeastOneHourAfterStart());
            } else {
                // if date or time fields or radio buttons are disabled
                // then food list must also be disabled.
                foodList.setEnabled(false);
                // radio buttons not enabled so they must be deselected.
                buffetButton.setSelected(false);
                tableServiceButton.setSelected(false);
            } // if enable
            okButton.setEnabled(foodList.isEnabled()
                                && foodList.getMinSelectionIndex()>-1);
        } // protectedEnforceInvariants()

        /**
         * return true if the date, start and end field contain valid
         * values and the time in the end field is at least one hour
         * after the end field.
         */
        private boolean endAtLeastOneHourAfterStart() {
            Calendar startCalendar = getStartCalendar();
            if (startCalendar == null)
              return false;
            Calendar endCalendar = getEndCalendar();
            if (endCalendar == null)
              return false;
            startCalendar.add(Calendar.MINUTE, 59);
            return getEndCalendar().after(startCalendar);
        } // endAtLeastOneHourAfterStart()

        /**
         * Register an OK button with this mediator
         * @param ok The dialog's OK button
         */
        public void registerOkButton(JButton ok) {
            okButton = ok;
        } // registerOkButton(JButton)

        /**
         * Register the field for entering the number of people
         * @param field The field used to enter the number people
         */
        public void registerPeopleCountField(final JTextComponent field) {
            peopleCountField = field;
            DocumentAdapter documentAdapter = new DocumentAdapter() {
                protected void parseDocument() {
                    int count = PEOPLE_COUNT_DEFAULT;
                    try {
                        count = Integer.parseInt(field.getText());
                    } catch (NumberFormatException e) {
                    }
                    if (MIN_PEOPLE<=count && count<=MAX_PEOPLE )
                      peopleCount =  count;
                    else
                      peopleCount = PEOPLE_COUNT_DEFAULT;
                } // parseDocument()
              };
            field.getDocument().addDocumentListener(documentAdapter);
        } // registerPeopleCountField(JTextComponent)

        /**
         * register the field for entering the date of the banquet
         * @param field The field used to enter the date of the banquet.
         */
        public void registerDateField(final JTextComponent field) {
            dateField = field;
            DocumentAdapter documentAdapter = new DocumentAdapter() {
                SimpleDateFormat dateFormat
                  = new SimpleDateFormat("MM/dd/yy");
                protected void parseDocument() {
                    try {
                        date = dateFormat.parse(field.getText());
                    } catch (java.text.ParseException e) {
                        date = null;
                    } // try
                } // parseDocument()
              };
            field.getDocument().addDocumentListener(documentAdapter);
        } // registerDateField(JTextComponent)

        /**
         * register the field for entering the start time of the banquet
         * @param field The field used to enter start time of banquet.
         */
        public void registerStartField(final JTextComponent field) {
            startField = field;
            DocumentAdapter documentAdapter = new DocumentAdapter() {
                SimpleDateFormat dateFormat
                  = new SimpleDateFormat("HH:mm");
                protected void parseDocument() {
                    try {
                        startTime = dateFormat.parse(field.getText());
                    } catch (java.text.ParseException e) {
                        startTime = null;
                    } // try
                } // parseDocument()
              };
            field.getDocument().addDocumentListener(documentAdapter);
        } // registerStartField(JTextComponent)

        /**
         * register the field for entering the end time of the banquet
         * @param field The field used to enter end time of banquet.
         */
        public void registerEndField(final JTextComponent field) {
            endField = field;
            DocumentAdapter documentAdapter = new DocumentAdapter() {
                SimpleDateFormat dateFormat
                  = new SimpleDateFormat("HH:mm");
                protected void parseDocument() {
                    try {
                        endTime = dateFormat.parse(field.getText());
                    } catch (java.text.ParseException e) {
                        endTime = null;
                    } // try
                } // parseDocument()
              };
            field.getDocument().addDocumentListener(documentAdapter);
        } // registerEndField(JTextComponent)

        /**
         * register the toggle button that indicates table service
         * @param button Button that indicates table service
         */
        public void registerTableButton(JToggleButton button) {
            tableServiceButton = button;
            button.addItemListener(itemAdapter);
        } // registerEndField(JTextComponent)

        /**
         * register the toggle button that indicates buffet service
         * @param button Button that indicates buffet service
         */
        public void registerBuffetButton(JToggleButton button) {
            buffetButton = button;
            button.addItemListener(itemAdapter);
        } // registerEndField(JTextComponent)

        /**
         * Register the list of foods
         * @param list The list of foods.
         */
        public void registerFoodList(JList list) {
            foodList = list;
            list.addListSelectionListener(listSelectionAdapter);
        } // registerEndField(JTextComponent)
    } // class BanquetMediator
} // class BanquetReservationDialog
