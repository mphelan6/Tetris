
public class loseShape extends shape {

    public loseShape() {
        super();
    }

    @Override
    public boolean moveRight() {
        return true;
    }

    @Override
    public boolean moveLeft() {
        return true;
    }

    @Override
    public boolean fall() {
        return true;
    }

    @Override
    protected void setShapeOpen() {
    }

    @Override
    protected void setShapeClosed() {
    }

    @Override
    public void speed() {
    }

    @Override
    public boolean rotate() {
        return false;
    }
}
