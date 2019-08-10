package cpsc2150.hw4;
/**
 @invariant 0 < rowSize <= MAX_SIZE
 @invariant 0 < colSize <= MAX_SIZE
 @invariant 0 < winSize <= NUM_ROWS
 @invariant 0 < winSize <= NUM_COLS
 Correspondence NUM_ROWS = rowSize
 Correspondence NUM_COLS = colSize
 */
public class GameBoardFast implements IGameBoard {
    private  char[][] Board;
    private  int colSize;
    private  int rowSize;
    private  int winSize;

    public GameBoardFast(int num_rows, int num_cols, int num_win)
    {
        colSize = num_cols;
        rowSize = num_rows;
        winSize = num_win;
        Board = new char[rowSize][colSize];
        for (int i=0; i<(Board.length); i++ )
        {
            for (int j=0;j<Board[i].length;j++)
                Board[i][j] = ' ';
        }
    }
    @Override
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
     * @ensures row pos, column pos is compared against boundary limitations.
     */
    public boolean checkSize(BoardPosition pos)
    {
        if (pos.getRow() >= 0 && pos.getRow() < rowSize && pos.getColumn() >= 0 && pos.getColumn() < colSize)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    @Override
    public  void placeMarker(BoardPosition marker)
    {
        Board[marker.getRow()][marker.getColumn()] = marker.getPlayer();
    }
    @Override
    public  boolean checkForWinner(BoardPosition lastPos)
    {
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
     * @return true when char p exists winSize times vertically
     * @requires Board is not full
     * @ensures Row lastPos+- Column lastPos is checked winSize times for lastPos marker.
     */
    private  boolean checkVerticalWin(BoardPosition lastPos)
    {
        int count = 1;
        char p = lastPos.getPlayer();
        int c = lastPos.getColumn();
        int r = lastPos.getRow()+1; //check under
        while(r < rowSize)
        {
            if(Board[r][c] == p)
            {
                count++;
            }
            else
            {
                r = rowSize+1;
            }
            r++;
        }
        r = lastPos.getRow()-1; //check above
        while(r >= 0)
        {
            if(Board[r][c] == p)
            {
                count++;
            }
            else
            {
                r = -1;
            }
            r--;
        }
        if(count == winSize)
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
     * @return true when winSize = count, where count is the number of connecting player markers in a column, else false
     * @requires 0 <= lastPos < Board.length
     * @ensures checkHorizontalWin if count = winSize else !checkHorizontalWin
     */
    private  boolean checkHorizontalWin(BoardPosition lastPos)
    {
        char p = lastPos.getPlayer();
        int r = lastPos.getRow();
        int count = 1;
        int c = lastPos.getColumn()+1; //right check
        while(c < colSize)
        {
            if(Board[r][c] == p) //check row by checking columns
            {
                count++;
            }
            else
            {
                c = colSize+1;
            }
            c++;
        }
        c = lastPos.getColumn()-1; //left check
        while(c >= 0)
        {
            if(Board[r][c] == p) //check row by checking columns
            {
                count++;
            }
            else
            {
                c = -1;
            }
            c--;
        }
        if(count >= winSize)
        {
            return  true;
        }

        else
        {
            return false;
        }
    }
    /**
     *  Checks to see if the last marker placed resulted in 5 in a row diagonally. Returns true if it does, otherwise false
     *  Note: there are two diagonals to check
     * @param lastPos to check for diagonal win
     * @return true when winSize = count, where count is the number of connecting player markers in a column, else false
     * @requires 0 <= lastPos < Board.length
     * @ensures checkDiagonalWin if countd or countrd = winSize else !checkDiagonalWin
     */
    private  boolean checkDiagonalWin(BoardPosition lastPos)
    {
        int countd = 1; int countrd = 1; int n = 1; //start at 1 to avoid checking last placed
        char p = lastPos.getPlayer();
        int r = lastPos.getRow(); int c = lastPos.getColumn();
        while( r + n < Board.length && c + n < Board.length) //check +,+
        {

            if (Board[r+n][c+n] == p)
            {
                countd++;
            }
            else
            {
                n = Board.length+1;
            }
            n++;
        }
        n = 1;
        while( r - n >= 0 && c - n >= 0)  //check -,-
        {

            if (Board[r-n][c-n] == p)
            {
                countd++;
            }
            else
            {
                n = Board.length+1;
            }
            n++;
        }
        n = 1;
        while(r-n >= 0 && c+n < Board.length) //check -,+
        {
            if(Board[r-n][c+n] == p)
            {
                countrd++;
            }
            else
            {
                n = Board.length+1;
            }
            n++;
        }
        n = 1;
        while(r+n < Board.length && c-n >= 0) //check +,-
        {
            if(Board[r+n][c-n] == p)
            {
                countrd++;
            }
            else
            {
                n = Board.length+1;
            }
            n++;
        }
        if(countd == winSize || countrd == winSize)
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
        str +=("   ");
        if(colSize > 10)
        {
            for (int i=0; i < 10; i++)
            {
                str +=(" " + i + "|"); //print the board numbers
            }

            for (int i = 10; i < colSize; i++)
            {
                str +=(i + "|"); //print the board numbers
            }
            str+= "\n";
        }
        else
        {
            for (int i=0; i < colSize; i++)
            {
                str +=(i + "| "); //print the board numbers
            }
            str+= "\n";
        }

        if(rowSize > 10)
        {
            for (int i=0; i < 10; i++)
            {
                str +=(" " + i + "|"); //print the board grid
                for (int j=0; j<Board[0].length; j++)
                    str +=(Board[i][j] + " |");
                str+= "\n";
            }
            for (int i = 10; i < rowSize; i++)
            {
                str +=(i + "|"); //print the board grid
                for (int j=0; j<Board[0].length; j++)
                    str +=(Board[i][j] + " |");
                str+= "\n";
            }
        }
        else
        {
            for (int i=0; i < rowSize; i++)
            {
                str +=(i + "|"); //print the board grid
                for (int j=0; j<Board[0].length; j++)
                    str +=(Board[i][j] + " |");
                str+= "\n";
            }
        }
        return str;
    }
}
