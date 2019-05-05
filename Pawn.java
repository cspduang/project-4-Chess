public class Pawn extends ChessPiece {

    public Pawn(int x, int y) {
        this.x = x;
        this.y = y;
        this.step = 0;
        this.type = "PAWN";
    }

    public boolean move(int newX, int newY) throws OutOfBoardException, IllegalChessMoveException {
        if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {
            throw new OutOfBoardException();
        }

        if (newX == x && newY == y) {
            throw new IllegalChessMoveException();
        }
        if (newX != x) {
            throw new IllegalChessMoveException();
        }
        if ((newY - y) < 0 || (newY - y) > 2) {
            throw new IllegalChessMoveException();
        }
        if (((newY - y) == 2) && step != 0) {
            throw new IllegalChessMoveException();
        }

        return true;
    }

    public String toString() {
        return "-p-";
    }
}
