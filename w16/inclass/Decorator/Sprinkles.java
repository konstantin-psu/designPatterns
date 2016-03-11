class Sprinkles implements IcecreamIF {
    IcecreamIF decorated;
    Sprinkles(IcecreamIF decorated) { this.decorated = decorated; }
    public int calories() { return 100 + decorated.calories(); }
}
