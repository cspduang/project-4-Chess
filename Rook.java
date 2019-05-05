public class Rook extends ChessPiece {

    public Rook(int x, int y) {
        this.x = x;
        this.y = y;
        this.step = 0;
        this.type = "ROOK";
    }

    public boolean move(int newX, int newY) throws OutOfBoardException, IllegalChessMoveException {
        if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {
            throw new OutOfBoardException();
        }

        if (newX == x && newY == y) {
            throw new IllegalChessMoveException();
        }
        if (newY < y) {
            throw new IllegalChessMoveException();
        }
        if (newY != y && newX != x) {
            throw new IllegalChessMoveException();
        }

        return true;
    }

    public String toString() {
        return "-r-";
    }
}
