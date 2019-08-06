package cpsc2150.hw2;

/**
 * Created by Madison on 9/19/2017.
 */


public class GameBoard {
    public static char[][] Board;
    public static int BoardColumnLengthUser = 7; //Max column size user can place values through.
    public static int BoardRowLengthUser = 7; //Max row size user can place values through.
    public static int BoardRowLength = 9; //With provisioning to the input of user, this represents maximum valid row #.
    public static int BoardColumnLength = 17; //Read above comment, represents maximum valid column #.
    public static int lengthToWin =5;


    public GameBoard()
    {
        Board = new char[][]
                {
                        {' ', ' ', '0', ' ', '1', ' ', '2', ' ', '3', ' ', '4', ' ', '5', ' ', '6', ' ', '7', ' '},
                        {'0', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|'},
                        {'1', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|'},
                        {'2', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|'},
                        {'3', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|'},
                        {'4', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|'},
                        {'5', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|'},
                        {'6', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|'},
                        {'7', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|'},

                };
    }

    public static boolean checkSpace(BoardPosition pos)
    {
        if (Board[BoardPosition.getRow()][BoardPosition.getColumn()] == ' ')
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void placeMarker(BoardPosition marker)
    {
        Board[BoardPosition.getRow()][BoardPosition.getColumn()] = BoardPosition.getPlayer();
    }

    public static boolean checkForWinner(BoardPosition lastPos)
    {
        ////this function will check to see if the lastPos placed resulted in a winner. It so it will return true,
        // otherwise false.
        //Passing in the last position will help limit the possible places to check for a win condition,
        // since you can assume that any win condition that did not include the most recent play made would have
        // been caught earlier.
        if(checkHorizontalWin(null) || checkVerticalWin(null) || checkDiagonalWin(null) )
        {
            return true;
        }
        return false;

    }
    private static boolean checkHorizontalWin(BoardPosition lastPos)
    {
        //checks to see if the last marker placed resulted in 5 in a row horizontally. Returns true if it does,
        // otherwise false
        // Check each lengthToWin x lengthToWin board for a winner.
        // Takes the row and column coordinates of the last move made
        // and checks to see if that move causes the player to win
           return false;


    }

    private static boolean checkVerticalWin(BoardPosition lastPos)
    {
        return false;
    }
    private static boolean checkDiagonalWin(BoardPosition lastPos)
    {
        //checks to see if the last marker placed resulted in 5 in a row diagonally. Returns true if it does, otherwise false
        //Note: there are two diagonals to check
        return false;
    }
    static void MarkerUpdater()
    {
        //This function should be called last in the main loop to avoid input mismatch.
        if(BoardPosition.getPlayer() == 'X')
        {
            BoardPosition.BoardPosition(BoardPosition.getRow(),BoardPosition.getColumn(),'O');
        }
        else
        {
            BoardPosition.BoardPosition(BoardPosition.getRow(),BoardPosition.getColumn(),'X');
        }
    }
}
