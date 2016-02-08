public class Logon extends AbstractLogon {
    //...
    protected Object authenticate(String userID, String password)
                     throws Exception {
        if (userID.equals("abc") && password.equals("123"))
          return userID;
        throw new Exception("bad userID");
    } // authenticate

    protected void notifyAuthentication(Object authenticationToken) {
        //...
    } // notify(Object)
} // class Logon
