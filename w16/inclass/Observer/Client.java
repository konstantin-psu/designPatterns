class Client {
    public static void main(String [] ignore) {
	Observable observable = new Observable();
	Observer observer = new Observer();
	observable.register(observer);
	observable.work();
    }
}
