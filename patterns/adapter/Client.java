class Client {
    static ServiceIF service = new Adapter();
    public static void main(String [] ignore) {
	service.method(23);
    }	
}
