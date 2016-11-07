
import java.awt.Color;

public class squareShape extends shape {

    public squareShape() {
        super();
        cors[0] = new xycor(3, 3);
        cors[1] = new xycor(3, 4);
        cors[2] = new xycor(4, 3);
        cors[3] = new xycor(4, 4);
        shapeColor = Color.RED;
        setShapeClosed();
    }

    @Override
    public boolean rotate() {
        return true;
    }
}
