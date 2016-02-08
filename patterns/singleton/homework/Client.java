class Client {
    static Logger logger = null;
    public static void main(String[] args) {
        logger = Logger.getInstance("testfile", 2);
        logger.log("testing logger");
    }
}
