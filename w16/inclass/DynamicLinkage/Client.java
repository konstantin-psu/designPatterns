class Client {
    public static void main(String [] ignore) {
	try {
	    String fruitName = Chooser.getFruitName();
	    Fruit fruit = (Fruit) Class.forName(fruitName).newInstance();
	    System.out.println(fruit.getColor());
	} catch (Exception ex) {
	    System.out.println(ex);
	}
    }
}
