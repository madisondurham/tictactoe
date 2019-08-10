package cpsc2150.hw4;

/**
 * IGameBoard represents a 2-dimensional gameboard that has characters
 * on it as markers (X, O). No space on the board can have multiple
 * players, and there can be a clear winner. Board is NUM_ROWS x NUM_COLS in size
 *
 * Initialization ensures: the Board does not have any markers on it
 * Defines: NUM_ROWS: Z
 * Defines: NUM_COLS: Z
 * Constraints: 0< NUM_ROWS <= MAX_SIZE
 * Constraints: 0< NUM_COLS <= MAX_SIZE
 */
public interface IGameBoard {
    int MAX_SIZE = 100;
    /**
     * @param pos to check if position specified is available
     * @return true when pos is free
     * @requires 0 <= pos <= MAX_SIZE
     * @ensures space row pos, column pos, is checked to see if the space is occupied
     */
    boolean checkSpace(BoardPosition pos);
    /**
     * @param lastPos to get marker and place in pos
     * @requires [lastPos has a value]
     * @requires  0 <= lastPos <= number of rows
     * @requires  0 <= lastPos <= number of columns
     * @ensures marker will appear in row lastPos, column lastPos
     */
    void placeMarker(BoardPosition lastPos);
    /**
     * @param lastPos to check if the last move is a winning move
     * @return true when a winning move has been made
     * @requires 0 <= lastPos <= number of rows
     * @requires 0 <= lastPos <= number of columns
     * @ensures the area surrounding row lastPos, column lastPos will be checked for a win
     */
    boolean checkForWinner(BoardPosition lastPos);
}
