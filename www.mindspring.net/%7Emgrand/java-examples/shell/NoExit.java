package shell;


/*
 * This is a simple application to demonstrate the NoExitSecurityManager.
 * The purpose of the NoExitSecurityManager class is to prevent any methods
 * called directly or indirectly from the Invoker class (also part of this
 * demonstration) from calling System.exit.
 */ 
public class NoExit {
    public static void main(String[] argv) {
        try {
            System.setSecurityManager(new NoExitSecurityManager());
            Class e =  Class.forName("Exit");
            Invoker.invoke(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main(String[])
} // class NoExit
