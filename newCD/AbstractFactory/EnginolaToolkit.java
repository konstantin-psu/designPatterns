/**
 * This is a concrete factory class for creating objects that are used to
 * perform remote tests on core components of enginola architecture
 * computers.
 */
class EnginolaToolkit extends ArchitectureToolkit {
    /**
     * Method to create objects for remote testing enginola CPUs.
     */
    public CPU createCPU() {
        return new EnginolaCPU();
    } // createCPU()

    /**
     * Method to create objects for remote testing enginola MMUs.
     */
    public MMU createMMU() {
        return new EnginolaMMU();
    } // createMMU()
    //...
} // class EnginolaToolkit

