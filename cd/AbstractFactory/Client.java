/**
 * Sample client class to show how a client class can create concrete
 * widget objects using an abstract factory
 */
public class Client {
    public void doIt () {
        ArchitectureToolkit af;
        af = ArchitectureToolkit.getFactory(ArchitectureToolkit.EMBER);
        CPU cpu = af.createCPU();
        //...
    } //doIt
} // class Client
