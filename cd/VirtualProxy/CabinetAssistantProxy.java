import java.lang.reflect.Constructor;

/**
 * This class is an example of a virtual proxy.
 */
public class CabinetAssistantProxy {
    private CabinetAssistantIF assistant = null;
    private String myParam;     // for assistant object's constructor

    /**
     * Constructor
     */
    public CabinetAssistantProxy(String s) {
        myParam = s;
    } // constructor(String)

    /**
     * Get the the CabinetAssistant object that is used to implement
     * operations.  This method creates it if it did not exist.
     */
    private CabinetAssistantIF getCabinetAssistant() {
        if (assistant == null) {
            try {
                // Get class object that represents the Assistant class.
                Class clazz = Class.forName("CabinetAssistant");

                // Get a constructor object to access the
                // CabinetAssistant class' constructor that takes a
                // single string argument. 
                Constructor constructor;

                // Get the constructor object to create the
                // CabinetAssistant object. 
                Class[] formalArgs = new Class [] { String.class };
                constructor = clazz.getConstructor(formalArgs);

                // User the constructor object.
                Object[] actuals = new Object[] { myParam };
                assistant
                  = (CabinetAssistantIF)constructor.newInstance(actuals);
            } catch (Exception e) { 
            } // try
            if (assistant == null) {
                // deal with failure to create CabinetAssistant object
                throw new RuntimeException();
            } // if
        } // if
        return assistant;
    } // getCabinetAssistant()

    //...
    public void operation1() {
        getCabinetAssistant().operation1();
    } // operation1()

    public void operation2() {
        getCabinetAssistant().operation2();
    } // operation2()
} // class CabinetAssistantProxy
