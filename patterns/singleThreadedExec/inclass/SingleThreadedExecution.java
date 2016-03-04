class SingleThreadedExecution {
    int x,y;
    boolean read() {
        int t = x;
        long now = System.currentTimeMillis();
        while(System.currentTimeMillis() < now + 1000 ) {
        }
        return t == y;
    }

    void change() {
        x = y = x + 1;
    }
}
