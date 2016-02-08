class Proxy implements Service {
    Service service = new RealService();
    boolean thursday = true;
    public int work1() { return service.work1(); }
    public int work2() { 
	if (thursday) {
	    System.out.println("Sorry");
	    return 0;
	} else {
	    return service.work2(); 
	}
    }
}
