class Client {
    public static void main(String [] ignore) {
	IcecreamIF icecream = new Icecream();
	System.out.println("cal = "+icecream.calories());
	icecream = new Sprinkles(icecream);
	System.out.println("cal = "+icecream.calories());
	icecream = new Fudge(icecream);
	System.out.println("cal = "+icecream.calories());
    }
}
