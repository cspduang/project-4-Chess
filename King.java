public class King extends ChessPiece {

    public King(int x, int y) {
        this.x = x;
        this.y = y;
        this.step = 0;
        this.type = "KING";
    }

    public boolean move(int newX, int newY) throws OutOfBoardException, IllegalChessMoveException {
        if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {
            throw new OutOfBoardException();
        }

        if (x == newX && y == newY) {
            throw new IllegalChessMoveException();
        }
        if (Math.abs(newX - x) == 1 && (newY == y)) {
            return true;
        }
        if (Math.abs(newY - y) == 1 && (newX == x)) {
            return true;
        }
        if (Math.abs(newX - x) == 1 && Math.abs(newY - y) == 1) {
            return true;
        }

        throw new IllegalChessMoveException();
    }

    public String toString() {
        return "-K-";
    }
}
