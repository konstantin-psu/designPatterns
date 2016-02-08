class ReceivingLocation extends Facility implements AddressIF{
    private Address address;

    //...

    /**
     * Get the first line of the street address.
     */
    public String getAddress1() { return address.getAddress1 (); }

    /**
     * Set the first line of the street address.
     */
    public void setAddress1(String address1) { address.setAddress1 (address1); }

    /**
     * Get the second line of the street address.
     */
    public String getAddress2() { return address.getAddress2 (); }

    /**
     * Set the second line of the street address.
     */
    public void setAddress2(String address2) { address.setAddress2 (address2); }

    /**
     * Get the city.
     */
    public String getCity() { return address.getCity (); }

    /**
     * Set the city.
     */
    public void setCity(String city) { address.setCity (city); }

    /**
     * Get the state.
     */
    public String getState() { return address.getState (); }

    /**
     * Set the state.
     */
    public void setState(String state) { address.setState (state); }

    /**
     * get the postal code
     */
    public String getPostalCode() { return address.getPostalCode (); }

    /**
     * set the postal code
     */
    public void setPostalCode(String postalCode) {
        address.setPostalCode (postalCode);
    } // setPostalCode(String)
} // class ReceivingLocation
