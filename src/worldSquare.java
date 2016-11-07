import java.awt.Color;

public class worldSquare {

    private boolean worldBoolean;
    private Color c;

    public worldSquare() {
        worldBoolean = false;
        c = Color.WHITE;
    }

    public worldSquare(Color startColor, boolean startBoolean) {
        c = startColor;
        worldBoolean = startBoolean;
    }

    public Color getColor() {
        return c;
    }

    public void setColor(Color newColor) {
        c = newColor;
    }

    public boolean getBoolean() {
        return worldBoolean;
    }

    public void setTrue() {
        worldBoolean = true;
    }

    public void setFalse() {
        worldBoolean = false;
    }

    public void setBoolean(boolean newState) {
        worldBoolean = newState;
    }
}
