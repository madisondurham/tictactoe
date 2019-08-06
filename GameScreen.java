package cpsc2150.hw2;

import java.util.Scanner;

public class GameScreen {

    public static void main(String[] args)
    {

        int exit = 0;
        GameBoard Board = new GameBoard();
        Scanner input = new Scanner(System.in);

        System.out.print("Welcome to Tic-Tac-Toe Extended Edition!\nPlayer X, It's your turn!\n" +
                         "To place your marker, follow the onscreen instructions:\n");
        BoardPosition.BoardPosition(0, 0, 'X'); //Set Player to X
        while (exit == 0)
        {
            System.out.print("Enter a Row number (0-" + GameBoard.BoardRowLengthUser + ")\n");
            int row = input.nextInt() + 1; //Adding one will allow to treat the second row of array Board[][] as Row 0.
            System.out.print("Enter a Column number (0-" + GameBoard.BoardColumnLengthUser +")\n");
            int column = input.nextInt();
            column = column + column + 2; //Adding itself and two allows us to bypass the grid and keep it super simple.
            //We need to first check for user input error and prompt user to correct it before attempting to do anything.
            BoardPosition.BoardPosition(row, column, BoardPosition.getPlayer()); //Store the input in a private location
            if (row > 0 && row < GameBoard.BoardRowLength && column > 0 && column < GameBoard.BoardColumnLength)
            {
                if (GameBoard.checkSpace(null))
                {
                    GameBoard.placeMarker(null); //places current marker.
                    display();
                    if(GameBoard.checkForWinner(null))
                    {
                        System.out.print("Player " + BoardPosition.getPlayer() + " has won!");
                        System.out.print("Play again? (Y/N)?\n");
                        if(input.next().trim().charAt(0) == 'Y')
                        {
                            GameBoard.Board = new char[][]
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
                        else
                        {
                            System.exit(0);
                        }

                    }
                    GameBoard.MarkerUpdater();
                    System.out.print("Player " +BoardPosition.getPlayer() + " it is your turn!\n");
                }
                else
                {
                    System.out.print("Error: Object already exists in specified location.\n");
                }
            }
            else
            {
                System.out.print("Error: Value out of bounds.\n");
            }
        }
    }
    public static void display()
    {
            //This method prints a visual representation of the board. The output should utilize an X to
            //symbolize player 1, an O to symbolize player 2, and spaces to symbolize free locations.
            //Despite not part of the board, the output includes a border of |
            //around the entire maze. See Figure 1 for an example output.

            for (int i=0; i < GameBoard.Board.length; i++)
            {

                for (int j=0; j<GameBoard.Board[0].length; j++)
                    System.out.print(GameBoard.Board[i][j] + " ");
                    System.out.println();
            }
    }

}
