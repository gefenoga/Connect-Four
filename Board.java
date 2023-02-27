class Board
{
    int width;
    int height;
    Piece[][] currBoard;

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Board(int height, int width, Piece[][] board){
        this.width = width;
        this.height = height;
        this.currBoard = new Piece[height][width];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                currBoard[i][j] = new Piece(Type.empty);
            }
        }
    }

    void addPiece(int column, Type player) {
        if (column >= width || column < 0) {
            System.out.println("out of borders");
            System.exit(2013);
        }

        if (currBoard[0][column].type != Type.empty)
        {
            System.out.println("Row is full!");
            return;
        }

        int row;
        for(row = 0; row < height; row++){
            if (currBoard[row][column].type != Type.empty)
                break;
        }

        currBoard[row - 1][column].type = player;


    }

    public Type checkWin()
    {
        Type cell;

        for(int rows = 0; rows < height; rows++)
        {
            for(int columns = 0; columns < width; columns++)
            {

                cell = currBoard[rows][columns].type;

                if (cell == Type.empty)
                    continue;

                if(columns + 3 < width)
                {
                    if(currBoard[rows][columns + 1].type == cell &&
                            currBoard[rows][columns + 2].type == cell &&
                                currBoard[rows][columns + 3].type == cell) {
                        return cell;
                    }

                    if (rows - 3 >= 0)
                    {
                        if(currBoard[rows - 1][columns + 1].type == cell &&
                                currBoard[rows - 2][columns + 2].type == cell &&
                                currBoard[rows - 3][columns + 3].type == cell) {
                                return cell;
                        }
                    }

                    if (rows + 3 < height){
                        if(currBoard[rows + 1][columns + 1].type == cell &&
                                currBoard[rows + 2][columns + 2].type == cell &&
                                currBoard[rows + 3][columns + 3].type == cell) {
                            return cell;
                        }
                    }
                }


                if (columns - 3 >= 0)
                {
                    if(currBoard[rows][columns - 1].type == cell &&
                            currBoard[rows][columns - 2].type == cell &&
                            currBoard[rows][columns - 3].type == cell) {
                        return cell;
                    }

                    if (rows - 3 >= 0)
                    {
                        if(currBoard[rows - 1][columns - 1].type == cell &&
                                currBoard[rows - 2][columns - 2].type == cell &&
                                currBoard[rows - 3][columns - 3].type == cell) {
                            return cell;
                        }
                    }

                    if (rows + 3 < height)
                    {
                        if(currBoard[rows + 1][columns - 1].type == cell &&
                                currBoard[rows + 2][columns - 2].type == cell &&
                                currBoard[rows + 3][columns - 3].type == cell) {
                            return cell;
                        }
                    }
                }

                if (rows - 3 >= 0)
                {
                    if(currBoard[rows - 1][columns].type == cell &&
                            currBoard[rows - 2][columns].type == cell &&
                            currBoard[rows - 3][columns].type == cell) {
                        return cell;
                    }
                }

                if (rows + 3 < height)
                {
                    if(currBoard[rows + 1][columns].type == cell &&
                            currBoard[rows + 2][columns].type == cell &&
                            currBoard[rows + 3][columns].type == cell) {
                        return cell;
                    }
                }
            }
        }

        return Type.empty;
    }


    void drawBoard()
    {
        for(int temp = 0; temp < width * 2 + 1; temp++){
            System.out.print("-");
        }
        System.out.println();

        for(int i = 0; i < height; i++){
            System.out.print("|");
            for(int j = 0; j < width; j++){
                switch (currBoard[i][j].type) {
                    case player1 -> System.out.print(ANSI_RED + "O" + ANSI_RESET + "|");
                    case player2 -> System.out.print(ANSI_BLUE + "O" + ANSI_RESET + "|");
                    case empty -> System.out.print(" |");
                    default -> {
                    }
                }
            }
            System.out.println();
        }

        for(int temp = 0; temp < width * 2 + 1; temp++){
            System.out.print("-");
        }
        System.out.println();
    }
}