/**
 * Tic Tac Toe Game in Java
 * Homework 05
 * @author Aushee, Chad, Calvin, Julia 
 */

import java.util.Scanner;

public class TicTacToe
{
    public static String[][] gameBoard = {{" "," "," "},{" "," "," "}, {" "," "," "}};
    
    // Test board
    //public static String[][] gameBoard = {{"x","o","o"}, {"x","o","x"}, {"o","x","o"}};
    private static boolean playerOne = true;

    /**
     * Displays the board to the user in the console
     * Example looks like this:
       -------------
       | X | O | X |
       -------------
       | X | O | O |
       -------------
       | O | O | X |
       -------------

     */
    public static void printBoard()
    {
        System.out.println("-------------");
        for (int row = 0; row < gameBoard.length; row++)
        {
            System.out.printf("|");
            for(int col = 0; col < gameBoard[row].length; col++)
            {
                System.out.printf(" %S ", gameBoard[row][col]);
                System.out.printf("|");
            }
            System.out.println("\n-------------");
        }
    }

    /**
     * Updates the game board depending on player input
     * 
     * @param input       Integer array of user input specifying the row and column
     * @param playerTurn  Specifies whether it is player1 or player2, x or o
     */
    public static void updateBoard(int[] input)
    {
        if (playerOne)
        {
            gameBoard[input[0]][input[1]] = "x";
           
        }
        else
        {
            gameBoard[input[0]][input[1]] = "o";
        }
        playerOne = !playerOne;
    }

    /**
      * Function to receive user input
      * Calls checkInput function
      *
      * @param keyboard     Scanner class object to parse user input
      * @param playerOne    boolean specifying player's turn (player 1 is true, player2 is false) 
      *
      * @return Returns coordinates for spot on board user wishes to play
     */ 
    public static int[] getUserInput(Scanner keyboard, boolean playerOne) {
        
        // Holds user's desired coordinates, in array form for the purpose of returning 
        int[] userCoordinates = new int[2];

        // For specifying which user's turn it is to input coordinates
        String playerStr = "Player 1 (x)";
        if (!playerOne) {
            playerStr = "Player 2 (o)";
        }

        // Reads in user input for row and column coordinates and prompts user to try again if invalid input is entered
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Enter a row (0, 1, or 2) for " + playerStr + ":" );
            userCoordinates[0] = keyboard.nextInt();

            System.out.println("Enter a column (0, 1, or 2) for " + playerStr + ":");
            userCoordinates[1] = keyboard.nextInt();

            validInput = checkInput(userCoordinates[0], userCoordinates[1]);

            if (!validInput) {
                System.out.println("Invalid input. Please try again.\n");
            }
        }

        // Once valid input is entered, user's desired coordinates are returned
        return userCoordinates;
        
    }

    /**
      * Check's the user's input to see if it is valid
      * 
      * @param x        the x position user entered
      * @param y        the y position user entered
      *
      * @return boolean Returns true if user input is valid with respect to game restrictions
     */
    public static boolean checkInput(int x, int y) {

        // Automatically returns false if user coordinates are out of bounds
        if (x < 0 || x > 2 || y < 0 || y > 2 ) {
            return false;
        }

        // Returns false if position on board is already filled
        if (gameBoard[x][y] == "x" || gameBoard[x][y] == "o") {
            return false;
        }

        return true;
    }
}
