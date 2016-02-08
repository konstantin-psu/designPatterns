class Client {
    public static void main (String [] ignore) {
	Service service = new Proxy();
	someMethod(service);
    }
    static void someMethod(Service service) {
	System.out.println("work1 "+ service.work1());
	System.out.println("work2 "+ service.work2());
    }
}
