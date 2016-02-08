/**
 * Created by kmacarenco on 1/15/16.
 */
public class SecurityManagerStandard extends SecurityManager {
    /** *  Get the maximum allowed connection hours.
     */
    public int getConnectionHours () {return 0;}
    /**
     *  Get the maximum allowed connection speed.
     */
    public int getConnectionSpeed () {return 0;}
}
