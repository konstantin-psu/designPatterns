/**
 * This is a concrete factory class for creating objects that are used to
 * perform remote tests on core components of ember architecture
 * computers.
 */
class EmberToolkit extends ArchitectureToolkit {
    /**
     * Method to create objects for remote testing ember CPUs.
     */
    public CPU createCPU() {
        return new EmberCPU();
    } // createCPU()

    /**
     * Method to create objects for remote testing ember MMUs.
     */
    public MMU createMMU() {
        return new EmberMMU();
    } // createMMU()
    //...
} // class EmberToolkit

