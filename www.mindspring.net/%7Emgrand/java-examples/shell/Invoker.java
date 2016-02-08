package shell;

/**
 * This class creates an instance of another class, calling the instantiated
 * class' zero argument constructor.  This class is designed to be used
 * with NoExitSecurityManager.  Methods invoked directly or indirectly
 * by the Invoker class are assumed by NoExitSecurityManager to be
 * untrusted. 
 */
class Invoker {
    static void invoke(Class c) {
        try {
            c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        } //try
    } // invoke
} // class Invoker
