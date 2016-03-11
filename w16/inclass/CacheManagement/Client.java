class Client {
    public static void main(String [] ignore) {
	long time = System.currentTimeMillis();
	PlotIF plot = Cache.getPlot("AAPL", time);
	plot = Cache.getPlot("MSFT", time);
	plot = Cache.getPlot("AAPL", time);
    }
}
