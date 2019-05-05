public abstract class ChessPiece {

    protected int x;
    protected int y;
    protected int step;
    protected String type;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getType() {
        return type;
    }

    public abstract boolean move(int newX, int newY) throws OutOfBoardException, IllegalChessMoveException;

    public String toString() {
        return "---";
    }
}
