
import java.awt.Color;

public class L_Shape_Right extends shape {

    public L_Shape_Right() {
        super();
        cors[0] = new xycor(3, 3);
        cors[1] = new xycor(3, 4);
        cors[2] = new xycor(4, 4);
        cors[3] = new xycor(5, 4);
        shapeColor = Color.CYAN;
        setShapeClosed();
    }

    @Override
    public boolean rotate() {
        xycor newCors[] = new xycor[4];
        setShapeOpen();

        if (rotState == 0) {
            newCors[0] = new xycor(cors[0].getX(), cors[0].getY() + 1);
            newCors[1] = new xycor(cors[1].getX(), cors[1].getY() - 1);
            newCors[2] = new xycor(cors[2].getX() - 1, cors[2].getY() - 2);
            newCors[3] = new xycor(cors[3].getX() - 1, cors[3].getY() - 2);

            if (isArrayValid(newCors)) {
                cors = newCors;
                setShapeClosed();
                rotState = 1;
                return true;
            }
            setShapeClosed();
            return false;
        } else if (rotState == 1) {
            newCors[0] = new xycor(cors[0].getX() + 2, cors[0].getY());
            newCors[1] = new xycor(cors[1].getX() + 2, cors[1].getY());
            newCors[2] = new xycor(cors[2].getX() + 1, cors[2].getY() + 1);
            newCors[3] = new xycor(cors[3].getX() - 1, cors[3].getY() + 1);

            if (isArrayValid(newCors)) {
                cors = newCors;
                setShapeClosed();
                rotState = 2;
                return true;
            }
            setShapeClosed();
            return false;
        } else if (rotState == 2) {
            newCors[0] = new xycor(cors[0].getX() - 2, cors[0].getY());
            newCors[1] = new xycor(cors[1].getX() - 1, cors[1].getY() + 1);
            newCors[2] = new xycor(cors[2].getX(), cors[2].getY());
            newCors[3] = new xycor(cors[3].getX() + 1, cors[3].getY() - 1);

            if (isArrayValid(newCors)) {
                cors = newCors;
                setShapeClosed();
                rotState = 3;
                return true;
            }
            setShapeClosed();
            return false;
        } else {
            newCors[0] = new xycor(cors[0].getX(), cors[0].getY() - 1);
            newCors[1] = new xycor(cors[1].getX() - 1, cors[1].getY());
            newCors[2] = new xycor(cors[2].getX(), cors[2].getY() + 1);
            newCors[3] = new xycor(cors[3].getX() + 1, cors[3].getY() + 2);

            if (isArrayValid(newCors)) {
                cors = newCors;
                setShapeClosed();
                rotState = 0;
                return true;
            }
            setShapeClosed();
            return false;
        }
    }
}
