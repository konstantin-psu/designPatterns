/**
 * A Class that abstracts an editable street address information.
 * It implements the AddressIF interface.
 */
public class Address implements AddressIF {

    private String address1;
    private String address2;
    private String city;
    private String state;
    private String postalCode;

    /**
     * Get the first line of the street address.
     */
    public String getAddress1 () { return address1; }

    /**
     * Set the first line of the street address.
     */
    public void setAddress1 (String address1) { this.address1 = address1; }

    /**
     * Get the second line of the street address.
     */
    public String getAddress2 () { return address2; }

    /**
     * Set the second line of the street address.
     */
    public void setAddress2 (String address2) { this.address2 = address2; }

    /**
     * Get the city.
     */
    public String getCity () { return city; }

    /**
     * Set the city.
     */
    public void setCity (String city) { this.city = city; }

    /**
     * Get the state.
     */
    public String getState () { return state; }

    /**
     * Set the state.
     */
    public void setState (String state) { this.state = state; }

    /**
     * get the postal code
     */
    public String getPostalCode () { return postalCode; }

    /**
     * set the postal code
     */
    public void setPostalCode (String postalCode) { this.postalCode = postalCode; }
} // class Address

