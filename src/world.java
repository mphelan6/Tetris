
import java.awt.Color;
import java.awt.Graphics;

public class world {

    public static final int MAX_X = 10;
    public static final int MAX_Y = 24;
    public static final Color BG_COLOR = Color.WHITE;

    private worldSquare worldArray[][] = new worldSquare[MAX_X][MAX_Y];

    public int dim;

    public world() {
        for (int y = 0; y < MAX_Y; y++) {
            for (int x = 0; x < MAX_X; x++) {
                worldArray[x][y] = new worldSquare(BG_COLOR, false);
            }
        }
        dim = 45;
    }

    public void draw(Graphics g) {
        for (int y = 0; y < MAX_Y; y++) {
            for (int x = 0; x < MAX_X; x++) {
                if (worldArray[x][y].getBoolean()) {
                    g.setColor(worldArray[x][y].getColor());
                    g.fillRect(x * dim, y * dim, dim, dim);
                    g.setColor(Color.BLACK);
                    g.drawRect(x * dim, y * dim, dim-1, dim-1);
                } else {
                    g.setColor(BG_COLOR);
                    g.fillRect(x * dim, y * dim, dim, dim);
                }
            }
        }
    }

    public void checkLines() {
        for (int y = MAX_Y - 1; y > 2; y--) {
            boolean lineDone = true;

            for (int x = 0; x < MAX_X; x++) {
                if (isOpen(x, y)) {
                    lineDone = false;
                }
            }

            if (lineDone) {
                for (int y2 = y - 1; y2 > 2; y2--) {
                    for (int x2 = 0; x2 < MAX_X; x2++) {
                        worldArray[x2][y2 + 1].setBoolean(worldArray[x2][y2].getBoolean());
                        worldArray[x2][y2 + 1].setColor(worldArray[x2][y2].getColor());
                        worldArray[x2][y2] = new worldSquare(BG_COLOR, false);
                    }
                }
                y++;
            }
        }
    }

    public boolean lose() {
        for (int y = 3; y >= 0; y--) {
            for (int x = 0; x < 10; x++) {
                if (!isOpen(x, y)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isOpen(int x, int y) {
        if (!isValid(x, y)) {
            return false;
        }
        return !worldArray[x][y].getBoolean();
    }

    public boolean setOpen(int x, int y) {
        if (isValid(x, y)) {
            worldArray[x][y].setFalse();
            worldArray[x][y].setColor(BG_COLOR);
            return true;
        }
        return false;
    }

    public boolean setClosed(int x, int y, Color shapeColor) {
        if (isValid(x, y)) {
            worldArray[x][y].setTrue();
            worldArray[x][y].setColor(shapeColor);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String toReturn = new String();

        for (int y = 0; y < MAX_Y; y++) {
            for (int x = 0; x < MAX_X; x++) {
                if (worldArray[x][y].getBoolean()) {
                    toReturn = toReturn + "O";
                } else {
                    toReturn = toReturn + "-";
                }
            }
            toReturn = toReturn + ": " + y + "\n";
        }

        return toReturn;
    }

    private boolean isValid(int x, int y) {
        if ((x < 0 || x >= MAX_X) || (y < 0 || y >= MAX_Y)) {
            return false;
        }
        return true;
    }
}
