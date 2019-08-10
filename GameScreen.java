package cpsc2150.hw4;

import java.util.Scanner;

public class GameScreen {

    public static void main(String[] args) {
        BoardPosition pos;
        IGameBoard Board = null;
        Scanner input = new Scanner(System.in);

        char player1 = 'X';
        char player2 = 'O';
        char newgame = ' ';
        char whichImpl = ' ';
        int megaLoop = 1;
        int impLoop = 1;
        int MAX_SIZE = 100;

        String rowPrompt = "How many rows should be on the board?\n";
        String colPrompt = "How many columns should be on the board?\n";
        String winPrompt = "How many in a row to win?\n";
        String impPrompt = "Enter F for a (F)ast implementation or M for a (M)emory efficient implementation\n";
        String unaPrompt = "That space is unavailable, please pick again\n";
        String winError = "You can't have that many because thats more than the number of rows or columns\n";
        String playAgain = "Would you like to play again? Y/N\n";

        pos = new BoardPosition(0, 0, player1);
        while (megaLoop == 1) {
            int gameLoop = 1;
            int newGameLoop = 1;
            System.out.print(rowPrompt);
            int rowNum = input.nextInt();
            while (rowNum > MAX_SIZE) {
                System.out.print("Can only have " + MAX_SIZE + " rows or less\n");
                System.out.print(rowPrompt);
                rowNum = input.nextInt();
            }
            System.out.print(colPrompt);
            int colNum = input.nextInt();
            while (colNum > MAX_SIZE) {
                System.out.print("Can only have " + MAX_SIZE + " columns or less\n");
                System.out.print(colPrompt);
                colNum = input.nextInt();
            }
            System.out.print(winPrompt);
            int winNum = input.nextInt();
            while (winNum > rowNum || winNum > colNum) {
                System.out.print(winError);
                System.out.print(winPrompt);
                winNum = input.nextInt();
            }
            while (impLoop == 1) {
                if (whichImpl == 'F' || whichImpl == 'f') {
                    Board = new GameBoardFast(rowNum, colNum, winNum);
                    impLoop = 0;
                } else if (whichImpl == 'M' || whichImpl == 'm') {
                    Board = new GameBoardMem(rowNum, colNum, winNum);
                    impLoop = 0;
                } else {
                    System.out.print(impPrompt);
                    whichImpl = (input.next().trim().charAt(0)); //string to char
                }
            }
            while (gameLoop == 1) {
                System.out.print("Player " + pos.getPlayer() + " Please enter your ROW\n");
                int row = input.nextInt();
                System.out.print("Player " + pos.getPlayer() + " Please enter your COLUMN\n");
                int column = input.nextInt();
                System.out.print("\n");
                pos = new BoardPosition(row, column, pos.getPlayer());
                if (Board.checkSpace(pos)) //Check for user input error.
                {
                    Board.placeMarker(pos);
                    System.out.println(Board.toString());
                    if (Board.checkForWinner(pos)) //Check for winning moves
                    {
                        System.out.print("Player " + pos.getPlayer() + " wins!");
                        while(newGameLoop == 1)
                        {
                            if (newgame == 'Y' || newgame == 'y')
                            {
                                newGameLoop = 0;
                                gameLoop = 0; //back to beginning
                                impLoop = 1;
                                newgame = ' ';
                                whichImpl = ' ';
                            }
                            else if(newgame == 'N' || newgame == 'n')
                            {
                                megaLoop = 0;
                                gameLoop = 0;
                                newGameLoop = 0;
                            }
                            else
                            {
                                System.out.print(playAgain);
                                newgame = (input.next().trim().charAt(0)); //string to char
                            }
                        }

                    } else if (pos.getPlayer() == player1) {

                        pos = new BoardPosition(pos.getRow(), pos.getColumn(), player2);
                    } else {
                        pos = new BoardPosition(pos.getRow(), pos.getColumn(), player1);
                    }
                } else {
                    System.out.print(unaPrompt);
                }
            }
        }
    }
}
