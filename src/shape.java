
import java.awt.Color;

public abstract class shape {

    protected world w;
    protected xycor[] cors = new xycor[4];
    protected Color shapeColor;
    protected int rotState = 0;

    public shape() {
        w = tetris.w;
    }

    public abstract boolean rotate();

    public boolean moveRight() {
        xycor[] newCors = new xycor[4];
        setShapeOpen();

        for (int i = 0; i < 4; i++) {
            if (w.isOpen(cors[i].getX() + 1, cors[i].getY())) {
                newCors[i] = new xycor(cors[i].getX() + 1, cors[i].getY());
            } else {
                setShapeClosed();
                return false;
            }
        }

        cors = newCors;
        setShapeClosed();

        return true;
    }

    public boolean moveLeft() {
        xycor[] newCors = new xycor[4];
        setShapeOpen();

        for (int i = 0; i < 4; i++) {
            if (w.isOpen(cors[i].getX() - 1, cors[i].getY())) {
                newCors[i] = new xycor(cors[i].getX() - 1, cors[i].getY());
            } else {
                setShapeClosed();
                return false;
            }
        }

        cors = newCors;
        setShapeClosed();

        return true;
    }

    public boolean fall() {
        xycor[] newCors = new xycor[4];
        setShapeOpen();

        for (int i = 0; i < 4; i++) {
            if (w.isOpen(cors[i].getX(), cors[i].getY() + 1)) {
                newCors[i] = new xycor(cors[i].getX(), cors[i].getY() + 1);
            } else {
                setShapeClosed();
                return false;
            }
        }

        cors = newCors;
        setShapeClosed();

        return true;
    }

    public void speed() {
        while (fall()) {
            //no need to put anything in here
        }
    }

    protected void setShapeClosed() {
        for (int i = 0; i < 4; i++) {
            w.setClosed(cors[i].getX(), cors[i].getY(), shapeColor);
        }
    }

    protected void setShapeOpen() {
        for (int i = 0; i < 4; i++) {
            w.setOpen(cors[i].getX(), cors[i].getY());
        }
    }

    protected boolean isArrayValid(xycor testCors[]) {
        for (int i = 0; i < 4; i++) {
            if (!w.isOpen(testCors[i].getX(), testCors[i].getY())) {
                return false;
            }
        }
        return true;
    }
}
