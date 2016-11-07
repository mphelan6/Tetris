public class xycor {

    private final int MAX_X = world.MAX_X;
    private final int MAX_Y = world.MAX_Y;
    private int x;
    private int y;

    public xycor() {
        x = 0;
        y = 0;
    }

    public xycor(int startX, int startY) {
        if (!setX(startX)) {
            x = 0;
        }
        if (!setY(startY)) {
            y = 0;
        }
    }

    public boolean setX(int newX) {
        x = newX;
        return true;
    }

    public boolean setY(int newY) {
        y = newY;
        return true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
