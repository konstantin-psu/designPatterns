class Client {
    public static void main(String [] ignore) {
	Component c1 = new Component(23);
	Component c2 = new Component(13);
	Component c3 = new Component(9);
	Component c4 = new Component(17);
	Composite d1 = new Composite(4);
	Composite d2 = new Composite(8);
	d1.add(c1);
	d1.add(d2);
	d2.add(c2);
	d2.add(c3);
	d2.add(c4);
	d1.pp(0);
    }
}
