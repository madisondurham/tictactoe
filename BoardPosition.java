package cpsc2150.hw2;


/**
 * Created by Madison on 9/19/2017.
 */
public class BoardPosition {
    private  int Row;
    private  int Column;
    private  char Player;

    public  void BoardPosition(int row, int column, char player)
    {
        Row = row;
        Column = column;
        Player = player;
    }

    /**
     * @requires [Row has a value]
     * @ensures getRow = Row
     */
    public  int getRow()
    {

        return Row;
    }

    /**
     * @requires [Column has a value]
     * @ensures getColumn = Column
     */
    public  int getColumn()
    {
        return Column;
    }

    /**
     * @requires [Player has a value]
     * @ensures getPlayer = Player
     */
    public  char getPlayer()
    {
        return Player;
    }
}
