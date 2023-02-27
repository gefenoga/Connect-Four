import java.util.*;

class Main
{
    public static Scanner reader = new Scanner(System.in);

    public static void main(String[] args){
        int boardWidth = 6;
        int boardHeight = 7;
        int turn;
        int columnInput;
        Type turnType;
        Board board = new Board(boardHeight, boardWidth, null);

        System.out.println("Choose which player starts(1 or anything but 1): ");
        turn = reader.nextInt();
        if (turn == 1)
            turnType = Type.player1;
        else turnType = Type.player2;

        board.drawBoard();

        Type status = board.checkWin();
        while(status == Type.empty){
            System.out.println("Enter column to add piece in: ");
            columnInput = reader.nextInt();
            board.addPiece(columnInput, turnType);
            if (turnType == Type.player1)
                turnType = Type.player2;
            else
                turnType = Type.player1;

            board.drawBoard();
            status = board.checkWin();
        }

        if (status == Type.player1)
        {
            System.out.println("PLAYER 1 WINS!");
        }
        else
        {
            System.out.println("PLAYER 2 WINS!");
        }
    }
}
