package shell;

import java.io.FileDescriptor;
import java.net.InetAddress;

/**
 * This is a security manager that lets code outside of the shell
 * package do everything except call System.exit(), link in a native
 * code library or define classes that are part of the shell package.
 */
class NoExitSecurityManager extends SecurityManager {
    /*
     * Throw a SecurityException for exit calls from a hosted program.
     */
    public void checkExit(int status) {
        if (!isTrusted())
          throw new SecurityException();
    } // checkExit(int)

    // We don't want programs hosted by the shell to be able to circumvent
    // this SecurityManager by linking in native code.  Though we could
    // override checkLink in a manner similar to checkExit to only prohibit
    // linking in native code by hosted programs, the shell has no need
    // to do that so it is simplest to just not override checkLink and
    // let it throw an exception if any code attempts to link in native
    // code.

    // Methods that alway return normally to allow operations
    public void checkCreateClassLoader() { } 
    public void checkAccess(Thread g) { }
    public void checkAccess(ThreadGroup g) { }
    public void checkExec(String cmd) { }
    public void checkRead(FileDescriptor fd) { }
    public void checkRead(String file) { }
    public void checkRead(String file, Object context) { }
    public void checkWrite(FileDescriptor fd) { }
    public void checkWrite(String file) { }
    public void checkDelete(String file) { }
    public void checkConnect(String host, int port) { }
    public void checkConnect(String host, int port, Object context) { }
    public void checkListen(int port) { }
    public void checkAccept(String host, int port) { }
    public void checkMulticast(InetAddress maddr) { }
    public void checkMulticast(InetAddress maddr, byte ttl) { }
    public void checkPropertiesAccess() { }
    public void checkPropertyAccess(String key) { }
    public void checkPropertyAccess(String key, String def) { }
    public boolean checkTopLevelWindow(Object window) { return true; }
    public void checkPrintJobAccess() { }
    public void checkSystemClipboardAccess() { }
    public void checkAwtEventQueueAccess() { }
    public void checkPackageAccess(String pkg) { }
    public void checkPackageDefinition(String pkg) { }
    public void checkSetFactory() { }
    public void checkMemberAccess(Class clazz, int which) { }
    public void checkSecurityAccess(String provider) { }
    
    /*
     * This method returns true if the caller of its caller is trusted.
     * Be sure to call this <b>directly</b> from the check methods.
     */
    private boolean isTrusted() {
        return !inClass("shell.Invoker");
    } // isTrusted()
}	
