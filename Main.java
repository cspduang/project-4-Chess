import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ChessBoard board = new ChessBoard();

        Scanner scan = new Scanner(new File("new_input.txt"));
        String line;
        String[] lineSegment;
        while(scan.hasNextLine())
        {
            line = scan.nextLine();
            lineSegment = line.split(" ");

            if (lineSegment.length == 3) {
                String type = lineSegment[0];
                int x = Integer.valueOf(lineSegment[1]);
                int y = Integer.valueOf(lineSegment[2]);

                ChessPiece piece = null;
                if (type.equals("pawn")) {
                    piece = new Pawn(x, y);
                } else if (type.equals("rook")) {
                    piece = new Rook(x, y);
                } else if (type.equals("knight")) {
                    piece = new Knight(x, y);
                } else if (type.equals("bishop")) {
                    piece = new Bishop(x, y);
                } else if (type.equals("king")) {
                    piece = new King(x, y);
                } else if (type.equals("queen")) {
                    piece = new Queen(x, y);
                }

                try {
                    board.putChessPiece(piece);
                } catch (OutOfBoardException e) {
                    System.out.println("Invalid Board Position. " + "(" + x + "," + y + ")");
                }
            }

            if (lineSegment.length == 5) {
                String type = lineSegment[0];
                int x = Integer.valueOf(lineSegment[1]);
                int y = Integer.valueOf(lineSegment[2]);
                int newX = Integer.valueOf(lineSegment[3]);
                int newY = Integer.valueOf(lineSegment[4]);

                try {
                    board.printBoard();
                    board.moveChessPiece(x, y, newX, newY);
                } catch (PathwayException e) {
                    System.out.println("Invalid Board Position. " + "(" + x + "," + y + ") " +
                            "(" + newX + "," + newY + ")");
                    System.out.println("=======================================");
                    System.out.println();
                } catch (IllegalChessMoveException e) {
                    System.out.println("Invalid Board Position. " + "(" + x + "," + y + ") " +
                            "(" + newX + "," + newY + ")");
                    System.out.println("=======================================");
                    System.out.println();
                } catch (OutOfBoardException e) {
                    System.out.println("Invalid Board Position. " + "(" + x + "," + y + ") " +
                            "(" + newX + "," + newY + ")");
                    System.out.println("=======================================");
                    System.out.println();
                }
            }
        }
    }
}
