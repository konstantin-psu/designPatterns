class Adapter implements ServiceIF {
    NewService newservice = new NewService();
    public void method(int x) {
	newservice.mymethod(x, 0);	
    }    
}
