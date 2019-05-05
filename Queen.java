public class Queen extends ChessPiece {

    public Queen(int x, int y) {
        this.x = x;
        this.y = y;
        this.step = 0;
        this.type = "QUEEN";
    }

    public boolean move(int newX, int newY) throws OutOfBoardException, IllegalChessMoveException {
        if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {
            throw new OutOfBoardException();
        }

        if (x == newX && y == newY) {
            throw new IllegalChessMoveException();
        }
        if (newX == x || newY == y) {
            return true;
        }
        if (Math.abs(newX - x) == Math.abs(newY - y)) {
            return true;
        }

        throw new IllegalChessMoveException();
    }

    public String toString() {
        return "-Q-";
    }
}
