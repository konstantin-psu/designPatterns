/**
 * Created by konstantin on 1/7/16.
 */
public interface AbstractFactoryIF {
    AccountIF createAccount(int loginId);
    SecurityManagerIF createSecurityManager();
}
