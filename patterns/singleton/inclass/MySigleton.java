class MySingleton {
    private MySingleton() {}
    private static MySingleton theInstance = new  MySingleton();
    public static MySingleton getInstance() { return theInstance; }    
}
