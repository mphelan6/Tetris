import java.awt.Color;

public class longShape extends shape {

    public longShape() {
        super();
        cors[0] = new xycor(3, 3);
        cors[1] = new xycor(4, 3);
        cors[2] = new xycor(5, 3);
        cors[3] = new xycor(6, 3);
        shapeColor = Color.ORANGE;
        setShapeClosed();
    }

    @Override
    public boolean rotate() {
        int startX = cors[0].getX(), startY = cors[0].getY();
        xycor newCors[] = new xycor[4];

        setShapeOpen();
        if (rotState == 0) {
            newCors[0] = new xycor(startX, startY);
            newCors[1] = new xycor(startX, startY - 1);
            newCors[2] = new xycor(startX, startY - 2);
            newCors[3] = new xycor(startX, startY - 3);
           rotState = 1;
        } else {
            newCors[0] = new xycor(startX, startY);
            newCors[1] = new xycor(startX + 1, startY);
            newCors[2] = new xycor(startX + 2, startY);
            newCors[3] = new xycor(startX + 3, startY);
            rotState = 0;
        }

        for (int i = 0; i < 4; i++) {
            if (!w.isOpen(newCors[i].getX(), newCors[i].getY())) {
                setShapeClosed();
                return false;
            }
        }

        cors = newCors;
        setShapeClosed();
        return true;
    }
}
