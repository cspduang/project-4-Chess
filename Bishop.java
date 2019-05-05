public class Bishop extends ChessPiece {

    public Bishop(int x, int y) {
        this.x = x;
        this.y = y;
        this.step = 0;
        this.type = "BISHOP";
    }

    public boolean move(int newX, int newY) throws OutOfBoardException, IllegalChessMoveException {
        if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {
            throw new OutOfBoardException();
        }

        if (x == newX && y == newY) {
            throw new IllegalChessMoveException();
        }
        if (Math.abs(newX - x) != Math.abs(newY - y)) {
            throw new IllegalChessMoveException();
        }

        return true;
    }

    public String toString() {
        return "-b-";
    }
}
