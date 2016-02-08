/**
 * Created by konstantin on 08/01/16.
 */
public class Position {
    protected int x;
    protected int y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {return x;}
    public int getY() {return y;}

    public Position offset(int xOffset, int yOffset) {
        return new Position(x+xOffset, y+yOffset);
    }
}
