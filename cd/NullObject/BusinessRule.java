import java.util.Date;

/**
 * Superclass for business rule classes
 */
class BusinessRule {
    private WarningRouter warning;
    private Date expirationDate = new Date(Long.MAX_VALUE);
    //...
    BusinessRule() {
        //...
        if (new Date().after(expirationDate)) {
            warning.routeWarning(getClass().getName()+" has expired.");
        } // if
        //...
    } // constructor()
} // class BusinessRule
