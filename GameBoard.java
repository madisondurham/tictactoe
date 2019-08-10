package cpsc2150.hw2;

/**
 * Created by Madison on 9/19/2017.
 */


public class GameBoard {
    private  char[][] Board;
    private  final int BoardSize = 8; //Max column/row  size user can place values through.
    private  final int lengthToWin = 5;

    public GameBoard()
    {
        Board = new char[BoardSize][BoardSize];
        for (int i=0; i<(Board.length); i++ )
        {
            for (int j=0;j<Board[i].length;j++)
                Board[i][j] = ' ';
        }
    }
    public void clearBoard()
    {
        for (int i=0; i<(Board.length); i++ )
        {
            for (int j=0;j< Board[i].length;j++)
                Board[i][j] = ' ';
        }
    }
    /**
     * @param pos to check if position specified is available
     * @return true when pos == ' ', else false
     * @requires 0 <= pos
     * @ensures return !BoardPosition if != ' '
     */
    public  boolean checkSpace(BoardPosition pos)
    {
        if(checkSize(pos))
        {
            if (Board[pos.getRow()][pos.getColumn()] == ' ')
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    /**
     * @param pos to check if value is within board size
     * @return true when 0 <= pos <= Board.length, else false
     * @requires [pos has a value]
     * @ensures return !checkSize if pos > 0 && return !checkSize if pos >= Board.length
     */
    public boolean checkSize(BoardPosition pos)
    {
        if (pos.getRow() >= 0 && pos.getRow() < Board.length && pos.getColumn() >= 0 && pos.getColumn() < Board.length)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    /**
     * @param marker to place in value of pos
     * @requires [marker has a value], 0 <= pos <= Board.length, [pos = ' '] Must call checkSpace prior to use.
     * @ensures pos = marker
     */
    public  void placeMarker(BoardPosition marker)
    {
        Board[marker.getRow()][marker.getColumn()] = marker.getPlayer();
    }
    /**
     * @param lastPos to check if the last move is a winning move
     * @return true when checkHorizontalWin || checkVerticalWin || checkDiagonalWin
     * @requires 0 <= lastPos < Board.length
     * @ensures checkForWinner if a winning move has been made, else !checkForWinner
     */
    public  boolean checkForWinner(BoardPosition lastPos)
    {
        ////this function will check to see if the lastPos placed resulted in a winner. It so it will return true,
        // otherwise false.
        //Passing in the last position will help limit the possible places to check for a win condition,
        // since you can assume that any win condition that did not include the most recent play made would have
        // been caught earlier.
        if(checkHorizontalWin(lastPos) || checkVerticalWin(lastPos) || checkDiagonalWin(lastPos))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    /**
     * @param lastPos to check for a vertical win
     * @return true when lengthToWin = count, where count is the number of connecting player markers in a column, else false
     * @requires 0 <= lastPos < Board.length
     * @ensures checkVerticalWin if count = lengthToWin else !checkVerticalWin
     */
    private  boolean checkVerticalWin(BoardPosition lastPos)
    {
        int count=0;

        for(int r = 0; r < Board.length; r++)
        {
            if(Board[r][lastPos.getColumn()]==(lastPos.getPlayer())) //check column by checking rows
            {
                count++;
            }
            if(Board[r][lastPos.getColumn()]!=(lastPos.getPlayer()) && Board[r][lastPos.getColumn()]!=(' '))
            {
                count = 0;
            }
        }
        if(count==lengthToWin)
        {
            return  true;
        }

        else
        {
            return false;
        }
    }
    /**
     * @param lastPos to check for a horizontal win
     * @return true when lengthToWin = count, where count is the number of connecting player markers in a column, else false
     * @requires 0 <= lastPos < Board.length
     * @ensures checkHorizontalWin if count = lengthToWin else !checkHorizontalWin
     */
    private  boolean checkHorizontalWin(BoardPosition lastPos)
    {
        int count=0;

        for(int c = 0; c < Board.length; c++)
        {
            if(Board[lastPos.getRow()][c]==(lastPos.getPlayer())) //check row by checking columns
            {
                count++;
            }
            if(Board[lastPos.getRow()][c]!=(lastPos.getPlayer()) && Board[lastPos.getRow()][c]!=(' '))
            {
                count = 0;
            }
        }
        if(count==lengthToWin)
        {
            return  true;
        }

        else
        {
            return false;
        }
    }
    /**
     * @param lastPos to check for diagonal win
     * @return true when lengthToWin = count, where count is the number of connecting player markers in a column, else false
     * @requires 0 <= lastPos < Board.length
     * @ensures checkDiagonalWin if count = lengthToWin || count2 = lengthToWin else !checkDiagonalWin
     */
    private  boolean checkDiagonalWin(BoardPosition lastPos)
    {
        //checks to see if the last marker placed resulted in 5 in a row diagonally. Returns true if it does, otherwise false
        //Note: there are two diagonals to check

        int count = 0; int count2 = 0;
        for(int n = 0; n < Board.length; n++)
        {
            int r = Board.length - 1 - n;
            if(Board[n][n] == (lastPos.getPlayer()))
            {
                count++; //regular diag
            }
            if(Board[n][n]!=(lastPos.getPlayer()) && Board[n][n]!=(' '))
            {
                count = 0;
            }
            if(Board[r][n] == (lastPos.getPlayer()))
            {
                count2++; //backwards diag
            }
            if(Board[r][n]!=(lastPos.getPlayer()) && Board[r][n]!=(' '))
            {
                count2 = 0;
            }
        }
        if(count == lengthToWin || count2 == lengthToWin)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    @Override
    public String toString()
    {
        String str = "";
        str +=(" ");
        for (int i=0; i < Board.length; i++)
        {
            str +=(" " + i); //print the board numbers
        }
        str+= "\n";

        for (int i=0; i < Board.length; i++)
        {
            str +=(i + "|"); //print the board grid
            for (int j=0; j<Board[0].length; j++)
                str +=(Board[i][j] + "|");
            str+= "\n";
        }
        return str;
    }
    public boolean isBoardFull(int counter)
    {
        int movestofull = (Board.length * Board.length) +1;
        if (counter == movestofull)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean whoseTurn(char player)
    {
        if(player == 'X')
        {
            return true; //return true if X
        }
        else
        {
            return false; //return true if O
        }
    }
}
