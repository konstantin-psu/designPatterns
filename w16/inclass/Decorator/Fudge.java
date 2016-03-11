class Fudge implements IcecreamIF {
    IcecreamIF decorated;
    Fudge(IcecreamIF decorated) { this.decorated = decorated; }
    public int calories() { return 150 + decorated.calories(); }
}
