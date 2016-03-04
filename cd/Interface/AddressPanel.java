import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Panel for editing street addresses.
 *<p>
 * <b>Caution:</b></br>
 * This panel works for the USA and Canada (excluding Quebec).  To
 * work for addresses elsewhere will require additional work.
 * @author Mark Grand
 */
class AddressPanel extends Panel {
    private AddressIF data;     // Data object

    // Text fields
    TextField address1Field   = new TextField("", 35);
    TextField address2Field   = new TextField("", 35);
    TextField cityField       = new TextField("", 16);
    TextField stateField      = new TextField("", 2);
    TextField postalCodeField = new TextField("", 10);

    /**
     * Constructor
     */
    public AddressPanel() {
        //Layout Panel
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints labelConstraints = new GridBagConstraints();
        labelConstraints.anchor = GridBagConstraints.EAST;
        labelConstraints.insets = new Insets(0, 0, 1, 3);
        GridBagConstraints fieldConstraints = new GridBagConstraints();
        fieldConstraints.anchor = GridBagConstraints.WEST;
        fieldConstraints.gridwidth = GridBagConstraints.REMAINDER;
        fieldConstraints.insets = new Insets(0, 0, 1, 0);
        setLayout(gb);

        Label label;
        label = new Label("Address1:");
        gb.setConstraints(label, labelConstraints);
        add(label);
        gb.setConstraints(address1Field, fieldConstraints);
        add(address1Field);
        label = new Label("Address2:");
        gb.setConstraints(label, labelConstraints);
        add(label);
        gb.setConstraints(address2Field, fieldConstraints);
        add(address2Field);
        label = new Label("City:");
        gb.setConstraints(label, labelConstraints);
        add(label);
        gb.setConstraints(cityField, fieldConstraints);
        add(cityField);
        label = new Label("State:");
        gb.setConstraints(label, labelConstraints);
        add(label);
        gb.setConstraints(stateField, fieldConstraints);
        add(stateField);
        label = new Label("Postal Code:");
        gb.setConstraints(label, labelConstraints);
        add(label);
        gb.setConstraints(postalCodeField, fieldConstraints);
        add(postalCodeField);
    } // Constructor(AddressIF)

    /**
     * Set the data object that this panel will work with.
     * @param address The data object that this object should fetch
     *                and store data from.
     */
    public void setData(AddressIF address) {
        data = address;

        // get data
        address1Field.setText(address.getAddress1());
        address2Field.setText(address.getAddress2());
        cityField.setText(address.getCity());
        stateField.setText(address.getState());
        postalCodeField.setText(address.getPostalCode());
    } // setData(AddressIF)

    /**
     * Save the contents of the TextFields into the data object.
     */
    public void save() {
        if (data != null) {
            data.setAddress1(address1Field.getText());
            data.setAddress2(address2Field.getText());
            data.setCity(cityField.getText());
            data.setState(stateField.getText());
            data.setPostalCode(postalCodeField.getText());
        } // if data
    } // save()
} // class AddressPanel
