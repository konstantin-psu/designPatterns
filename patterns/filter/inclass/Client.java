class Client {
    public static void main(String [] ignore) {
	SourceFilter source = new SourceFilter();
	ColorFilter color = new ColorFilter();
	InflateFilter inflate = new InflateFilter();
	inflate.setPrevious(color);
	color.setPrevious(source);

	for (int i = 0; i < 10; i++) {
	    inflate.pull();
	}

	System.out.println("colored = " + color.color);
	System.out.println("inflated = " + inflate.inflate);

    }
}
