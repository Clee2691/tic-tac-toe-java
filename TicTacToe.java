import java.util.Scanner;

/**
 * Class Invariant: Tic Tac Toe class creates a game for homework 5. All objects have a game board
 * string array and player one with boolean value true.
 *
 * @author Aushee, Chad, Calvin, Julia
 * @version 1.0
 */
public class TicTacToe {
    public static String[][] gameBoard = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    private static boolean playerOne = true;

    /**
     * Displays the board to the user in the console.
     * Example of what is looks like:
     * -------------
     * | X | O | X |
     * -------------
     * | X | O | O |
     * -------------
     * | O | O | X |
     * -------------
     */
    public static void printBoard() {
        System.out.println("-------------");
        for (int row = 0; row < gameBoard.length; row++) {
            System.out.printf("|");
            for (int col = 0; col < gameBoard[row].length; col++) {
                System.out.printf(" %S ", gameBoard[row][col]);
                System.out.printf("|");
            }
            System.out.println("\n-------------");
        }
    }

    /**
     * Updates the game board depending on player input.
     *
     * @param input Integer array of user input specifying the row and column
     */
    public static void updateBoard(int[] input) {
        if (playerOne) {
            gameBoard[input[0]][input[1]] = "x";
        } else {
            gameBoard[input[0]][input[1]] = "o";
        }
        playerOne = !playerOne;
    }

    /**
     * Function to obtain user input for row and column value. Calls checkInput function.
     *
     * @param keyboard Scanner class object to parse user input
     * @return int[] Returns coordinates for spot on board user wishes to play
     */
    public static int[] getUserInput(Scanner keyboard) {

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
            System.out.print("Enter a row (0, 1, or 2) for " + playerStr + ": ");
            userCoordinates[0] = keyboard.nextInt();

            System.out.print("Enter a column (0, 1, or 2) for " + playerStr + ": ");
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
     * Tests for validity of user's input.
     *
     * @param x the x position user entered
     * @param y the y position user entered
     * @return boolean returns true if user input is valid with respect to game restrictions
     */
    public static boolean checkInput(int x, int y) {
        // Automatically returns false if user coordinates are out of bounds
        if (x < 0 || x > 2 || y < 0 || y > 2) {
            return false;
        }
        // Returns false if position on board is already filled
        if (gameBoard[x][y].equals("x") || gameBoard[x][y].equals("o")) {
            return false;
        }
        return true;
    }

    /**
     * Tests for win conditions - a row, a column, or a diagonal.
     *
     * @param gameBoard the String array that represents game board
     * @return boolean returns true if a winning condition is found
     */
    //Check the win condition line by line
    public static boolean checkWinCondition(String[][] gameBoard) {
        //Check Rows
        if ((gameBoard[0][0].equals(gameBoard[0][1]) && gameBoard[0][0].equals(gameBoard[0][2]) && (!gameBoard[0][0].equals(" ")) ||
                (gameBoard[1][0].equals(gameBoard[1][1]) && gameBoard[1][0].equals(gameBoard[1][2]) && (!gameBoard[1][0].equals(" "))) ||
                (gameBoard[2][0].equals(gameBoard[2][1]) && gameBoard[2][0].equals(gameBoard[2][2]) && (!gameBoard[2][0].equals(" "))))) {
            return true;
        }
        //Check Columns
        else if ((gameBoard[0][0].equals(gameBoard[1][0]) && gameBoard[0][0].equals(gameBoard[2][0]) && (!gameBoard[0][0].equals(" "))) ||
                (gameBoard[0][1].equals(gameBoard[1][1]) && gameBoard[0][1].equals(gameBoard[2][1]) && (!gameBoard[0][1].equals(" "))) ||
                (gameBoard[0][2].equals(gameBoard[1][2]) && gameBoard[0][2].equals(gameBoard[2][2]) && (!gameBoard[0][2].equals(" ")))) {
            return true;
        }
        //Check Diagonals
        else if ((gameBoard[0][0].equals(gameBoard[1][1]) && gameBoard[0][0].equals(gameBoard[2][2]) && (!gameBoard[0][0].equals(" "))) ||
                (gameBoard[0][2].equals(gameBoard[1][1]) && gameBoard[0][2].equals(gameBoard[2][0])) && (!gameBoard[0][2].equals(" "))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Creates and displays tic tac toe game for person 1 and person 2 to play.
     *
     * @param args
     */
    public static void main(String[] args) {
        printBoard();
        Scanner keyboard = new Scanner(System.in);
        int[] userInput = new int[2];

        do {
            userInput = getUserInput(keyboard);
            updateBoard(userInput);
            printBoard();
        } while (!checkWinCondition(gameBoard));

        if (!playerOne) {
            System.out.println("Player 1 won!");
        } else {
            System.out.println("Player 2 won!");
        }
    }
}