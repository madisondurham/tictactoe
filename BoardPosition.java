package cpsc2150.hw4;


/**
 * @Author Madison Durham
 * @Since 9/19/2017
 */
public class BoardPosition {
    private int Row;
    private int Column;
    private char Player;


    public BoardPosition(int row, int column, char player) {
        Row = row;
        Column = column;
        Player = player;
    }

    /**
     * @requires [Row has a value]
     * @ensures getRow = Row
     */
    public int getRow() {

        return Row;
    }

    /**
     * @requires [Column has a value]
     * @ensures getColumn = Column
     */
    public int getColumn() {
        return Column;
    }

    /**
     * @requires [Player has a value]
     * @ensures getPlayer = Player
     */
    public char getPlayer() {
        return Player;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == this)
        {

            return true;
        }
        else if (! (obj instanceof BoardPosition))
        {

            return false;
        }

        BoardPosition pos = (BoardPosition) obj;

        return Double.compare(Row,pos.Row) == 0 && Double.compare(Column,pos.Column) == 0 && Double.compare(Player,pos.Player) == 0;
    }
}