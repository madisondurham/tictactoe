package cpsc2150.hw2;


/**
 * Created by Madison on 9/19/2017.
 */
public class BoardPosition {
    private static int Row;
    private static int Column;
    private static char Player;
    public static void BoardPosition(int Row, int Column, char Player)
    {
        BoardPosition.Row = Row;
        BoardPosition.Column = Column;
        BoardPosition.Player = Player;
    }

    /**
     * @requires [Row has a value]
     * @ensures getRow = Row
     */
    public static int getRow(){
        return Row;
    }

    /**
     * @requires [Column has a value]
     * @ensures getColumn = Column
     */
    public static int getColumn()
    {
        return Column;
    }

    /**
     * @requires [Player has a value]
     * @ensures getPlayer = Player
     */
    public static char getPlayer()
    {
        return Player;
    }
}
