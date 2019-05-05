public class Knight extends ChessPiece {

    public Knight(int x, int y) {
        this.x = x;
        this.y = y;
        this.step = 0;
        this.type = "KNIGHT";
    }

    public boolean move(int newX, int newY) throws OutOfBoardException, IllegalChessMoveException {
        if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {
            throw new OutOfBoardException();
        }

        if (newX == x && newY == y) {
            throw new IllegalChessMoveException();
        }
        if ((Math.abs(newX - x) == 2 && Math.abs(newY - y) == 1) ||
                Math.abs(newY - y) == 2 && Math.abs(newX - x) == 1) {
            return true;
        } else {
            throw new IllegalChessMoveException();
        }
    }

    public String toString() {
        return "-h-";
    }
}
