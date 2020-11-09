import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MatchingGame {
    
    //Helper function to generate the board
    public static void displayBoard(String[][] board){
        //Nested for loop unfortunately to create the x and y axis - O(n^2)
        for (int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //int Array -> str Array Conversion 
    public static String[] convertIntArray(int[] intArray){
        String strArray[] = new String[intArray.length];
        for (int i = 0; i < intArray.length; i++){
            strArray[i] = String.valueOf(intArray[i]);
        }
        return strArray;
    }

    //Helper functions that let us work with the board more easily
        //updateBoard will replace the value of our display with that of our real board
    public static void updateBoard(String[][] board1, String[][] board2, int X, int Y){
        board1[X][Y] = board2[X-1][Y-1];
    }

        //flipOver will turn a card facedown
    public static void flipOver(String[][] board, int X, int Y){
        board[X][Y] = "*";
    }

    //Check to see if any asterisks remain and if none remain, return that a win condition has been fulfilled
    public static boolean checkWon(String[][] board){
        for(int i = 1; i <= board.length; i++){
            for(int j = 1; j <= board.length; j++){
                if(board[i][j].equals("*")){
                    return false;
                }
            }
        }
        return true;
    }

    //Also, create a method to check our user's input
    public static boolean isValid(int userInput){
        if (userInput < 1 || userInput > 4 ){
            return false;
        } return true;
    }

    public static int getCoordinateFromUser(){
        int value;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a number 1 through 4.");
        value = scan.nextInt();
        if(value > 4){
            System.out.println("Enter a value greater than 4. Top Cieling is 4.");
            value = 4;
        } else if(value < 1){
            System.out.println("Entered a value less than 1. Bottom Floor is 1.");
            value = 1;
        }
        return value;
    }
    

    public static void main(String args[]){
        //Initialize our Scanner

        //Array of our card values - we'll shuffle this to populate our board
        int cardValues[] = {1,3,2,5,4,7,6,8,2,1,4,3,6,5,7,8};

        Random rand = new Random();

        for (int i = 0; i < cardValues.length; i++){
            int randomIndex = rand.nextInt(cardValues.length);
            int temp = cardValues[randomIndex];
            cardValues[randomIndex] = cardValues[i];
            cardValues[i] = temp;
        }
        //Now, we make 4 rows of cards from the cardValues
        int[] rowOne = Arrays.copyOfRange(cardValues, 0, 4);
        int[] rowTwo = Arrays.copyOfRange(cardValues, 4, 8);
        int[] rowThree = Arrays.copyOfRange(cardValues, 8, 12);
        int[] rowFour = Arrays.copyOfRange(cardValues, 12, 16);
    
        
        
        //We don't need to show the user the coordinates here, so it's really a 4x4
        //This array stores the actual integer values as strings
        String[][] actualBoard = {convertIntArray(rowOne), convertIntArray(rowTwo), convertIntArray(rowThree), convertIntArray(rowFour)};

        //Create a 5x5 Array so that we can have a numbered border as shown in the image
        String[][] currentBoardState = new String[5][5];

        //Unfortunate nested for loop to set the default board state to asterisks - O(n^2)
        for(int i = 1; i <= 4; i++){
            for(int j = 1; j <=4; j++){
                currentBoardState[i][j] = "*";
            }
        }
        //Create the borders to allow the user to use coordinates
        for(int i = 1; i <= 4; i++){
            currentBoardState[0][0] = Integer.toString(0);
            currentBoardState[0][i] = Integer.toString(i);
            currentBoardState[i][0] = Integer.toString(i);
        }

        //Game Logic
        
        //Prompt the User for (X,Y)
        boolean winCon = checkWon(currentBoardState);

        while(!winCon){
            //Get X1
            int x1 = getCoordinateFromUser();
            int y1 = getCoordinateFromUser();

            updateBoard(currentBoardState, actualBoard, y1, x1);
            displayBoard(currentBoardState);
            //Get x2
            int x2 = getCoordinateFromUser();
            //Get y2
            int y2 = getCoordinateFromUser();
            //Update the board again
            updateBoard(currentBoardState, actualBoard, y2, x2);
            displayBoard(currentBoardState);
        
            //First, make sure the user isn't selecting the same spot twice.
            if (x1 == x2 && y1 == y2) {
                System.out.println("Entered the same value - Flipping the cards back over!");
                currentBoardState[y1][x1] = "*";
                currentBoardState[y2][x2] = "*";
            }
            else if ((currentBoardState[y1][x1]).equals(currentBoardState[y2][x2])){
                //If the values match, lock them in place
            currentBoardState[y1][x1] = actualBoard[y1-1][x1-1];
            currentBoardState[y2][x2] = actualBoard[y2-1][x2-1];
            System.out.println("You Matched! - Locking the Cards in Place!");
            } else {
                System.out.println("Not a Match - Flipping the Cards Back Over!");
                currentBoardState[y1][x1] = "*";
                currentBoardState[y2][x2] = "*";
            }
            //If the values match, lock them in place
            
            winCon = checkWon(currentBoardState);
                
        }

    }
}
