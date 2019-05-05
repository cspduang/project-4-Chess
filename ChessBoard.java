public class ChessBoard {

    private ChessPiece[][] board;

    public ChessBoard() {
        board = new ChessPiece[8][8];
    }

    public void putChessPiece(ChessPiece piece) throws OutOfBoardException {
        if (piece.getX() < 0 || piece.getX() > 7 || piece.getY() < 0 || piece.getY() > 7) {
            throw new OutOfBoardException();
        }

        board[piece.getY()][piece.getX()] = piece;
    }

    public void moveChessPiece(int x, int y, int newX, int newY)
            throws PathwayException, IllegalChessMoveException, OutOfBoardException {
        ChessPiece piece = board[y][x];
        if (piece == null) {
            return;
        }

        boolean canMove = piece.move(newX, newY);
        if (canMove) {
            if (piece.getType().equals("PAWN")) {
                for (int i = y + 1; i <= newY; i++) {
                    if (board[i][x] != null) {
                        throw new PathwayException();
                    }
                }
            } else if (piece.getType().equals("ROOK")) {
                // forward
                if (x == newX) {
                    for (int i = y + 1; i <= newY; i++) {
                        if (board[i][x] != null) {
                            throw new PathwayException();
                        }
                    }
                }
                // sideways, right go
                if (y == newY && x < newX) {
                    for (int i = x + 1; i <= newX; i++) {
                        if (board[y][i] != null) {
                            throw new PathwayException();
                        }
                    }
                }
                // sideways, left go
                if (y == newY && x > newX) {
                    for (int i = x - 1; i >= newX; i++) {
                        if (board[y][i] != null) {
                            throw new PathwayException();
                        }
                    }
                }
            } else if (piece.getType().equals("KNIGHT")) {
                if (board[newY][newX] != null) {
                    throw new PathwayException();
                }
            } else if (piece.getType().equals("BISHOP")) {
                // right up
                if (newX > x && newY > y) {
                    for (int i = y + 1, j = x + 1; i <= newY; i++, j++) {
                        if (board[i][j] != null) {
                            throw new PathwayException();
                        }
                    }
                }
                // left up
                if (newX < x && newY > y) {
                    for (int i = y + 1, j = x - 1; i <= newY; i++, j--) {
                        if (board[i][j] != null) {
                            throw new PathwayException();
                        }
                    }
                }
                // right down
                if (newX > x && newY < y) {
                    for (int i = y - 1, j = x + 1; j <= newX; i--, j++) {
                        if (board[i][j] != null) {
                            throw new PathwayException();
                        }
                    }
                }
                // left down
                if (newX < x && newY < y) {
                    for (int i = y - 1, j = x - 1; j <= newX; i--, j--) {
                        if (board[i][j] != null) {
                            throw new PathwayException();
                        }
                    }
                }
            } else if (piece.getType().equals("KING")) {
                if (board[newY][newX] != null) {
                    throw new PathwayException();
                }
            } else if (piece.getType().equals("QUEEN")) {
                // forward
                if (x == newX && newY > y) {
                    for (int i = y + 1; i <= newY; i++) {
                        if (board[i][x] != null) {
                            throw new PathwayException();
                        }
                    }
                }
                // backward
                if (x == newX && newY < y) {
                    for (int i = y - 1; i >= newY; i--) {
                        if (board[i][x] != null) {
                            throw new PathwayException();
                        }
                    }
                }
                // sideways, right go
                if (y == newY && x < newX) {
                    for (int i = x + 1; i <= newX; i++) {
                        if (board[y][i] != null) {
                            throw new PathwayException();
                        }
                    }
                }
                // sideways, left go
                if (y == newY && x > newX) {
                    for (int i = x - 1; i >= newX; i++) {
                        if (board[y][i] != null) {
                            throw new PathwayException();
                        }
                    }
                }
                // right up
                if (newX > x && newY > y) {
                    for (int i = y + 1, j = x + 1; i <= newY; i++, j++) {
                        if (board[i][j] != null) {
                            throw new PathwayException();
                        }
                    }
                }
                // left up
                if (newX < x && newY > y) {
                    for (int i = y + 1, j = x - 1; i <= newY; i++, j--) {
                        if (board[i][j] != null) {
                            throw new PathwayException();
                        }
                    }
                }
                // right down
                if (newX > x && newY < y) {
                    for (int i = y - 1, j = x + 1; j <= newX; i--, j++) {
                        if (board[i][j] != null) {
                            throw new PathwayException();
                        }
                    }
                }
                // left down
                if (newX < x && newY < y) {
                    for (int i = y - 1, j = x - 1; j <= newX; i--, j--) {
                        if (board[i][j] != null) {
                            throw new PathwayException();
                        }
                    }
                }
            }
        }

        board[y][x] = null;
        piece.setX(newX);
        piece.setY(newY);
        piece.setStep(piece.getStep() + 1);
        board[newY][newX] = piece;

        System.out.println(piece.getType() + ": " + "(" + x + "," + y + ") " + "(" + newX +
                "," + newY + ")");
        System.out.println("Moved! " + "(" + x + "," + y + ") " + "(" + newX +
                "," + newY + ")");
        System.out.println("=======================================");
        System.out.println();
    }

    public void printBoard() {
        for (int row = 7; row >= 0; row--) {
            System.out.print("=" + row + "= ");
            for (int col = 0; col < 7; col++) {
                if (board[row][col] == null) {
                    System.out.print("--- ");
                } else {
                    System.out.print(board[row][col] + " ");
                }
            }
            if (board[row][7] == null) {
                System.out.println("---");
            } else {
                System.out.println(board[row][7]);
            }
        }
        System.out.println("=== =0= =1= =2= =3= =4= =5= =6= =7=");
    }
}
