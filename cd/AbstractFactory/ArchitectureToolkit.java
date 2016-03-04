/**
 * This is an abstract factory class for creating objects that are used to
 * perform remote tests on core components of computers.
 */
public abstract class ArchitectureToolkit {
    private static final EmberToolkit emberToolkit
      = new EmberToolkit();
    private static final EnginolaToolkit enginolaToolkit
      = new EnginolaToolkit();
    //...

    // Symbolic names to identify types of computers
    public final static int ENGINOLA = 900;
    public final static int EMBER    = 901;
    // ...

    /**
     * This method returns a concrete factory object that is an instance
     * of the concrete factory class that is appropriate for the given
     * computer architecture.
     * @param architecture a value indicating the architecture that a
     *        concrete factory should be returned for.
     */
    static final ArchitectureToolkit getFactory(int architecture) {
        switch (architecture) {
          case ENGINOLA:
              return enginolaToolkit;

          case EMBER:
              return emberToolkit;
              // ...
        } // switch
        String errMsg = Integer.toString(architecture);
        throw new IllegalArgumentException(errMsg);
    } // getFactory()

    /**
     * Method to create objects for remote testing CPUs.
     */
    public abstract CPU createCPU() ;

    /**
     * Method to create objects for remote testing MMUs.
     */
    public abstract MMU createMMU() ;

    //...
} // ArchitectureToolkit
