class Client {
    public static void main(String [] ignore) {
	Service service = new Proxy();
	service.hello();
    }
}
