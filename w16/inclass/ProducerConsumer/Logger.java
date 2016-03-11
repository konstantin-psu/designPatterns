class Logger {
    static long start = System.currentTimeMillis();
    private Logger() {}
    static void log(String msg) {
	long now = System.currentTimeMillis() - start;
	System.out.println(now +" "+ msg);
    }
}
