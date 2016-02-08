class Client {
    public static void main(String [] ignore) {
	ReusableIF r1 = Pool.checkout();
	ReusableIF r2 = Pool.checkout();
	Pool.checkin(r1);
	ReusableIF r3 = Pool.checkout();
	// ReusableIF r4 = new Reusable();
	Pool.dump();
    }
}
