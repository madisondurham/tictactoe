package cpsc2150.hw2;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * Created by Madison on 10/19/2017.
 */
public class TestGameBoard extends TestCase{
    private GameBoard Board;
    private BoardPosition pos;
    private int BoardLength = 8; //change this for different board size
    private int length2win = 5; //change this for different win size

    @Before  // runs before each test marked with an @Test annotation
    public void setUp() { Board = new GameBoard(); pos = new BoardPosition();}

    @After //runs after each method marked with an @Test annotation
    public void tearDown() { Board = null; pos = null;}

    @Test
    public void test_1_BoardLength_checkSpace()
    {
        pos.BoardPosition(1, BoardLength, 'X');
        assertFalse("testing column > BoardLength", Board.checkSpace(pos));
    }
    @Test
    public void test_1_7_checkSpace()
    {
        pos.BoardPosition(1, 7, 'X');
        assertTrue("testing column < BoardLength", Board.checkSpace(pos));
    }
    @Test
    public void test_7_1_checkSpace()
    {
        pos.BoardPosition(7, 1, 'X');
        assertTrue("testing row < BoardLength", Board.checkSpace(pos));
    }
    @Test
    public void test_BoardLength_1_checkSpace()
    {
        pos.BoardPosition(BoardLength, 1, 'X');
        assertFalse("testing row > BoardLength", Board.checkSpace(pos));
    }
    @Test
    public void test_4_4_X_checkSpace()
    {
        pos.BoardPosition(4, 4, 'X');
        assertTrue("testing 4, 4 ", Board.checkSpace(pos));
    }
    @Test
    public void test_5_5_X_checkSpace()
    {
        pos.BoardPosition(5,5,'X'); Board.placeMarker(pos); //place marker to test against an occupied space
        assertFalse("testing occupied space with 'X'", Board.checkSpace(pos));
    }
    @Test
    public void test_0_2_X_checkSpace()
    {
        pos.BoardPosition(0, 2, 'X');
        assertTrue("testing row >= 0", Board.checkSpace(pos));
    }
    @Test
    public void test_1_2_X_checkSpace()
    {
        pos.BoardPosition(1, 2, 'X');
        assertTrue("testing row > 0", Board.checkSpace(pos));
    }
    @Test
    public void test_2_0_X_checkSpace()
    {
        pos.BoardPosition(2, 0, 'X');
        assertTrue("testing column >= 0", Board.checkSpace(pos));
    }
    @Test
    public void test_2_1_X_checkSpace()
    {
        pos.BoardPosition(2, 1, 'X');
        assertTrue("testing column > 0", Board.checkSpace(pos));
    }
    @Test
    public void test__1_0_X_checkSpace()
    {
        pos.BoardPosition(-1, 0, 'X');
        assertFalse("testing row < 0", Board.checkSpace(pos));
    }
    @Test
    public void test_0__1_X_checkSpace()
    {
        pos.BoardPosition(0, -1, 'X');
        assertFalse("testing column < 0", Board.checkSpace(pos));
    }
    @Test
    public void test_0_0_X_placeMarker()
    {
        char [][] board2str;
        board2str = new char[BoardLength][BoardLength];
        for (int i=0; i<(board2str.length); i++ )
        {
            for (int j=0;j<board2str[i].length;j++)
                board2str[i][j] = ' ';
        }
        board2str[0][0] = 'X';
        String str = "";
        str +=(" ");
        for (int i=0; i < board2str.length; i++)
        {
            str +=(" " + i); //print the board numbers
        }
        str+= "\n";
        for (int i=0; i < board2str.length; i++)
        {
            str +=(i + "|"); //print the board grid
            for (int j=0; j<board2str[0].length; j++)
                str +=(board2str[i][j] + "|");
            str+= "\n";
        }
        pos.BoardPosition(0,0,'X');
        Board.placeMarker(pos);
        assertEquals(Board.toString(),str);
    }
    @Test
    public void test_7_7_X_placeMarker()
    {
        char [][] board2str;
        board2str = new char[BoardLength][BoardLength];
        for (int i=0; i<(board2str.length); i++ )
        {
            for (int j=0;j<board2str[i].length;j++)
                board2str[i][j] = ' ';
        }
        board2str[7][7] = 'X';

        String str = "";
        str +=(" ");
        for (int i=0; i < board2str.length; i++)
        {
            str +=(" " + i); //print the board numbers
        }
        str+= "\n";
        for (int i=0; i < board2str.length; i++)
        {
            str +=(i + "|"); //print the board grid
            for (int j=0; j<board2str[0].length; j++)
                str +=(board2str[i][j] + "|");
            str+= "\n";
        }
        pos.BoardPosition(7,7,'X');
        Board.placeMarker(pos);
        assertEquals(str,Board.toString());
    }
    @Test
    public void test_0_7_X_placeMarker()
    {
        char [][] board2str;
        board2str = new char[BoardLength][BoardLength];
        for (int i=0; i<(board2str.length); i++ )
        {
            for (int j=0;j<board2str[i].length;j++)
                board2str[i][j] = ' ';
        }
        board2str[0][7] = 'X';

        String str = "";
        str +=(" ");
        for (int i=0; i < board2str.length; i++)
        {
            str +=(" " + i); //print the board numbers
        }
        str+= "\n";
        for (int i=0; i < board2str.length; i++)
        {
            str +=(i + "|"); //print the board grid
            for (int j=0; j<board2str[0].length; j++)
                str +=(board2str[i][j] + "|");
            str+= "\n";
        }
        pos.BoardPosition(0,7,'X');
        Board.placeMarker(pos);
        assertEquals(str,Board.toString());
    }
    @Test
    public void test_7_0_X_placeMarker()
    {
        char [][] board2str;
        board2str = new char[BoardLength][BoardLength];
        for (int i=0; i<(board2str.length); i++ )
        {
            for (int j=0;j<board2str[i].length;j++)
                board2str[i][j] = ' ';
        }
        board2str[7][0] = 'X';

        String str = "";
        str +=(" ");
        for (int i=0; i < board2str.length; i++)
        {
            str +=(" " + i); //print the board numbers
        }
        str+= "\n";
        for (int i=0; i < board2str.length; i++)
        {
            str +=(i + "|"); //print the board grid
            for (int j=0; j<board2str[0].length; j++)
                str +=(board2str[i][j] + "|");
            str+= "\n";
        }

        pos.BoardPosition(7,0,'X');
        Board.placeMarker(pos);
        assertEquals(str,Board.toString());
    }
    @Test
    public void test_3_4_X_placeMarker()
    {
        char [][] board2str;
        board2str = new char[BoardLength][BoardLength];
        for (int i=0; i<(board2str.length); i++ )
        {
            for (int j=0;j<board2str[i].length;j++)
                board2str[i][j] = ' ';
        }
        board2str[3][4] = 'X';

        String str = "";
        str +=(" ");
        for (int i=0; i < board2str.length; i++)
        {
            str +=(" " + i); //print the board numbers
        }
        str+= "\n";
        for (int i=0; i < board2str.length; i++)
        {
            str +=(i + "|"); //print the board grid
            for (int j=0; j<board2str[0].length; j++)
                str +=(board2str[i][j] + "|");
            str+= "\n";
        }
        pos.BoardPosition(3,4,'X');
        Board.placeMarker(pos);
        assertEquals(str,Board.toString());
    }
    @Test
    public void test_4_3_X_placeMarker()
    {
        char [][] board2str;
        board2str = new char[BoardLength][BoardLength];
        for (int i=0; i<(board2str.length); i++ )
        {
            for (int j=0;j<board2str[i].length;j++)
                board2str[i][j] = ' ';
        }
        board2str[4][3] = 'X';
        String str = "";
        str +=(" ");
        for (int i=0; i < board2str.length; i++)
        {
            str +=(" " + i); //print the board numbers
        }
        str+= "\n";
        for (int i=0; i < board2str.length; i++)
        {
            str +=(i + "|"); //print the board grid
            for (int j=0; j<board2str[0].length; j++)
                str +=(board2str[i][j] + "|");
            str+= "\n";
        }
        pos.BoardPosition(4,3,'X');
        Board.placeMarker(pos);
        assertEquals(str,Board.toString());
    }
    @Test
    public void test_fillboard_X_placeMarker()
    {
        char [][] board2str;
        board2str = new char[BoardLength][BoardLength];
        for (int i=0; i<(board2str.length); i++ )
        {
            for (int j=0;j<board2str[i].length;j++)
                board2str[i][j] = 'X';
        }
        String str = "";
        str +=(" ");
        for (int i=0; i < board2str.length; i++)
        {
            str +=(" " + i); //print the board numbers
        }
        str+= "\n";
        for (int i=0; i < board2str.length; i++)
        {
            str +=(i + "|"); //print the board grid
            for (int j=0; j<board2str[0].length; j++)
                str +=(board2str[i][j] + "|");
            str+= "\n";
        }
        for (int i=0; i<(board2str.length); i++ )
        {
            for (int j=0;j<board2str[i].length;j++)
            {
                pos.BoardPosition(i,j,'X');
                Board.placeMarker(pos);
            }

        }
        assertEquals(Board.toString(),str);
    }
    @Test
    public void test_fillboard_O_placeMarker()
    {
        char [][] board2str;
        board2str = new char[BoardLength][BoardLength];
        for (int i=0; i<(board2str.length); i++ )
        {
            for (int j=0;j<board2str[i].length;j++)
                board2str[i][j] = 'X';
        }
        String str = "";
        str +=(" ");
        for (int i=0; i < board2str.length; i++)
        {
            str +=(" " + i); //print the board numbers
        }
        str+= "\n";
        for (int i=0; i < board2str.length; i++)
        {
            str +=(i + "|"); //print the board grid
            for (int j=0; j<board2str[0].length; j++)
                str +=(board2str[i][j] + "|");
            str+= "\n";
        }
        for (int i=0; i<(board2str.length); i++ )
        {
            for (int j=0;j<board2str[i].length;j++)
            {
                pos.BoardPosition(i,j,'O');
                Board.placeMarker(pos);
            }

        }
        assertNotSame(Board.toString(),str);
    }
    @Test
    public void test_r_0_X_checkForWinner()
    {
        for(int r = 0; r < length2win; r++)
        {
            pos.BoardPosition(r,0,'X');
            if(Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        assertTrue(Board.checkForWinner(pos));
    }
    @Test
    public void test_r_1_X_checkForWinner()
    {
        for(int r = 0; r < length2win; r++)
        {
            pos.BoardPosition(r,1,'X');
            if(Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        assertTrue(Board.checkForWinner(pos));
    }
    @Test
    public void test_r_2_X_checkForWinner()
    {
        for(int r = 0; r < length2win; r++)
        {
            pos.BoardPosition(r,2,'X');
            if(Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        assertTrue(Board.checkForWinner(pos));
    }
    @Test
    public void test_r_3_X_checkForWinner()
    {
        for(int r = 0; r < length2win; r++)
        {
            pos.BoardPosition(r,3,'X');
            if(Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        assertTrue(Board.checkForWinner(pos));
    }
    @Test
    public void test_r_4_X_checkForWinner()
    {
        for(int r = 0; r < length2win; r++)
        {
            pos.BoardPosition(r,4,'X');
            if(Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        assertTrue(Board.checkForWinner(pos));
    }
    @Test
    public void test_r_5_X_checkForWinner()
    {
        for(int r = 0; r < length2win; r++)
        {
            pos.BoardPosition(r,5,'X');
            if(Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        assertTrue(Board.checkForWinner(pos));
    }
    @Test
    public void test_r_6_X_checkForWinner()
    {
        for(int r = 0; r < length2win; r++)
        {
            pos.BoardPosition(r,6,'X');
            if(Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        assertTrue(Board.checkForWinner(pos));
    }
    @Test
    public void test_r_7_X_checkForWinner()
    {
        for(int r = 0; r < length2win; r++)
        {
            pos.BoardPosition(r,7,'X');
            if(Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        assertTrue(Board.checkForWinner(pos));
    }
    @Test
    public void test_0_c_X_checkForWinner()
    {
        for(int c = 0; c < length2win; c++)
        {
            pos.BoardPosition(0,c,'X');
            if(Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        assertTrue(Board.checkForWinner(pos));
    }
    @Test
    public void test_1_c_X_checkForWinner()
    {
        for(int c = 0; c < length2win; c++)
        {
            pos.BoardPosition(1,c,'X');
            if(Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        assertTrue(Board.checkForWinner(pos));
    }
    @Test
    public void test_2_c_X_checkForWinner()
    {
        for(int c = 0; c < length2win; c++)
        {
            pos.BoardPosition(2,c,'X');
            if(Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        assertTrue(Board.checkForWinner(pos));
    }
    @Test
    public void test_3_c_X_checkForWinner()
    {
        for(int c = 0; c < length2win; c++)
        {
            pos.BoardPosition(3,c,'X');
            if(Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        assertTrue(Board.checkForWinner(pos));
    }
    @Test
    public void test_4_c_X_checkForWinner()
    {
        for(int c = 0; c < length2win; c++)
        {
            pos.BoardPosition(4,c,'X');
            if(Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        assertTrue(Board.checkForWinner(pos));
    }
    @Test
    public void test_5_c_X_checkForWinner()
    {
        for(int c = 0; c < length2win; c++)
        {
            pos.BoardPosition(5,c,'X');
            if(Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        assertTrue(Board.checkForWinner(pos));
    }
    @Test
    public void test_6_c_X_checkForWinner()
    {
        for(int c = 0; c < length2win; c++)
        {
            pos.BoardPosition(6,c,'X');
            if(Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        assertTrue(Board.checkForWinner(pos));
    }
    @Test
    public void test_7_c_X_checkForWinner()
    {
        for(int c = 0; c < length2win; c++)
        {
            pos.BoardPosition(7,c,'X');
            if(Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        assertTrue(Board.checkForWinner(pos));
    }
    @Test
    public void test_c_r_X_checkForWinner()
    {
        for(int c = 0; c < length2win; c++)
        {
            for(int r = 0; r < length2win; r++)
            {
                pos.BoardPosition(r,c,'X');
                if(Board.checkSpace(pos))
                {
                    Board.placeMarker(pos);
                }
                else
                {
                    break;
                }
            }
        }
        assertTrue(Board.checkForWinner(pos));
    }
    @Test
    public void test_0_c2_X_checkForWinner()
    {
        for(int c = 0; c < length2win-1; c++)
        {
            pos.BoardPosition(0,c,'X');
            if(Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        assertFalse(Board.checkForWinner(pos));
    }
    @Test
    public void test_n_n_X_checkForWinner()
    {
        for(int n = 0; n < length2win; n++)
        {
            pos.BoardPosition(n, n, 'X');
            if (Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        assertTrue(Board.checkForWinner(pos));
    }
    @Test
    public void test_n_n_X_O_checkForWinner()
    {
        for(int n = 0; n < length2win-1; n++)
        {
            pos.BoardPosition(n, n, 'X');
            if (Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        pos.BoardPosition(length2win,length2win,'O');
        Board.placeMarker(pos);
        pos.BoardPosition(length2win+1,length2win+1,'X');
        Board.placeMarker(pos);
        assertFalse(Board.checkForWinner(pos));
    }
    @Test
    public void test_n1_n1_X_checkForWinner()
    {
        for(int n = 1; n < length2win+1; n++)
        {
            pos.BoardPosition(n, n, 'X');
            if (Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        assertTrue(Board.checkForWinner(pos));
    }
    @Test
    public void test_n1_n1_X_O_checkForWinner()
    {
        for(int n = 1; n < length2win; n++)
        {
            pos.BoardPosition(n, n, 'X');
            if (Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        pos.BoardPosition(length2win+1,length2win+1,'O');
        Board.placeMarker(pos);
        pos.BoardPosition(length2win+2,length2win+2,'X');
        Board.placeMarker(pos);
        assertFalse(Board.checkForWinner(pos));
    }
    @Test
    public void test_n2_n2_X_checkForWinner()
    {
        for(int n = 2; n < length2win+2; n++)
        {
            pos.BoardPosition(n, n, 'X');
            if (Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        assertTrue(Board.checkForWinner(pos));
    }
    @Test
    public void test_n2_n2_X_O_checkForWinner()
    {
        for(int n = 2; n < length2win+1; n++)
        {
            pos.BoardPosition(n, n, 'X');
            if (Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        pos.BoardPosition(length2win+2,length2win+2,'O');
        Board.placeMarker(pos);
        pos.BoardPosition(length2win,length2win,'X');
        Board.placeMarker(pos);
        assertFalse(Board.checkForWinner(pos));
    }
    @Test
    public void test_n3_n3_X_checkForWinner()
    {
        for(int n = 3; n < length2win+3; n++)
        {
            pos.BoardPosition(n, n, 'X');
            if (Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        assertTrue(Board.checkForWinner(pos));
    }
    @Test
    public void test_r_n_X_checkForWinner()
    {
        for(int n = 0; n < length2win; n++)
        {
            int r = BoardLength - 1 - n;
            pos.BoardPosition(r, n, 'X');
            if (Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        assertTrue(Board.checkForWinner(pos));
    }
    @Test
    public void test_r_n_X_O_checkForWinner()
    {
        for(int n = 0; n < length2win-1; n++)
        {
            int r = BoardLength - 1 - n;
            pos.BoardPosition(r, n, 'X');
            if (Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        pos.BoardPosition(3,2,'O');
        Board.placeMarker(pos);
        pos.BoardPosition(2,1,'X');
        Board.placeMarker(pos);
        assertFalse(Board.checkForWinner(pos));
    }
    @Test
    public void test_r_n1_X_checkForWinner()
    {
        for(int n = 1; n < length2win+1; n++)
        {
            int r = BoardLength - 1 - n;
            pos.BoardPosition(r, n, 'X');
            if (Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        assertTrue(Board.checkForWinner(pos));
    }
    @Test
    public void test_r_n2_X_checkForWinner()
    {
        for(int n = 2; n < length2win+2; n++)
        {
            int r = BoardLength - 1 - n;
            pos.BoardPosition(r, n, 'X');
            if (Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        assertTrue(Board.checkForWinner(pos));
    }
    public void test_r_n2_X_O_checkForWinner()
    {
        for(int n = 2; n < length2win+1; n++)
        {
            int r = BoardLength - 1 - n;
            pos.BoardPosition(r, n, 'X');
            if (Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        pos.BoardPosition(6,1,'O');
        Board.placeMarker(pos);
        pos.BoardPosition(7,0,'X');
        Board.placeMarker(pos);
        assertFalse(Board.checkForWinner(pos));
    }
    @Test
    public void test_r_n3_X_checkForWinner()
    {
        for(int n = 3; n < length2win+3; n++)
        {
            int r = BoardLength - 1 - n;
            pos.BoardPosition(r, n, 'X');
            if (Board.checkSpace(pos))
            {
                Board.placeMarker(pos);
            }
            else
            {
                break;
            }
        }
        assertTrue(Board.checkForWinner(pos));
    }
}
