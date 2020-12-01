import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.Insets;
import java.awt.Font;

public class TicTacToeGUI extends JFrame implements ActionListener {

    // Width and height of the GUI
    private static final int WIDTH = 750;
    private static final int HEIGHT = 750;

    // Style purposes for the font size and type
    private static final Font BUTTONFONTS = new Font("Comic Sans MS", Font.PLAIN, 100);

    //Instance variables for the game
    private static boolean player1 = true;
    private static boolean win = false;
    private static int counter = 0;

    // JButton instance variables so they can be accessed by actionPerformed()
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JLabel displayLabel;
    private JPanel boardPanel;

    // Main method to show GUI
    public static void main(String[] args) {
        TicTacToeGUI tttFrame = new TicTacToeGUI();
        tttFrame.setVisible(true);
    }

    // Method to create the buttons with action listener
    private JButton createButton(JButton aButton) {
        aButton.addActionListener(this);
        // Styling purposes
        aButton.setContentAreaFilled(false);
        aButton.setMargin(new Insets(0, 0, 0, 0));
        aButton.setFont(BUTTONFONTS);
        aButton.setForeground(Color.WHITE);
        return aButton;
    }

    // Constructor
    public TicTacToeGUI() {
        super();

        // Set width and height + title
        setSize(WIDTH, HEIGHT);
        setTitle("Tic Tac Toe");

        // The default action when the X is pressed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menu to start a new game or exit
        JMenu newGameMenu = new JMenu("File");

        // Menu item
        JMenuItem newGame = new JMenuItem("New Game");

        // Action to perform when pressed
        newGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Iterate through JPanel components (the buttons)
                for (Component comp : boardPanel.getComponents()) {
                    JButton button = (JButton) comp;

                    // Reset all button texts to empty string
                    button.setText("");
                }
                // Set the display label to new game and reset game variables
                displayLabel.setText("New Game! Player 1 Starts! (X)");
                win = false;
                player1 = true;
                counter = 0;
            }
        });

        // Another menu item to exit the game
        JMenuItem exitGame = new JMenuItem("Exit");
        exitGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Add JMenu items to JMenu
        newGameMenu.add(newGame);
        newGameMenu.add(exitGame);

        // Add JMenu to the JMenuBar
        JMenuBar menBar = new JMenuBar();
        menBar.add(newGameMenu);

        // Set the window's menu bar to the created menu bar
        setJMenuBar(menBar);

        // Making a border layout for the window
        setLayout(new BorderLayout());

        // Label at the top - NORTH
        // Shows which player is going and if anyone has won.
        displayLabel = new JLabel("Player 1 Starts! (X)");

        // Styling purposes - center justify the text
        displayLabel.setHorizontalAlignment(JLabel.CENTER);

        // Add the display label to the NORTH side of the border layout
        add(displayLabel, BorderLayout.NORTH);

        // JPanel to display the board with buttons
        boardPanel = new BlackJPanel();

        // Want a grid layout for the JPanel
        boardPanel.setLayout(new GridLayout(3, 3));

        // Create the buttons with specific styles
        button1 = createButton(new JButton());
        button2 = createButton(new JButton());
        button3 = createButton(new JButton());
        button4 = createButton(new JButton());
        button5 = createButton(new JButton());
        button6 = createButton(new JButton());
        button7 = createButton(new JButton());
        button8 = createButton(new JButton());
        button9 = createButton(new JButton());

        // Add the buttons to the JPanel
        boardPanel.add(button1);
        boardPanel.add(button2);
        boardPanel.add(button3);
        boardPanel.add(button4);
        boardPanel.add(button5);
        boardPanel.add(button6);
        boardPanel.add(button7);
        boardPanel.add(button8);
        boardPanel.add(button9);

        // Add the JPanel to the center of the border layout
        add(boardPanel, BorderLayout.CENTER);
    }

    // Action that will execute when button is pressed
    @Override
    public void actionPerformed(ActionEvent e) {

        // Get the button's text
        String buttonText = e.getActionCommand();

        // Get the actual JButton object that called this method
        JButton button = (JButton) e.getSource();

        // If the button is empty and no one has won yet
        // set the text to X or O depending on whose turn it is.
        if (buttonText.equals("") && !win) {
            if (player1) {
                button.setText("X");
            } else {
                button.setText("O");
            }
            // Switch player
            player1 = !player1;

            // Counter to check for a draw
            counter++;

            // Set display label based on whose turn it is.
            if (player1) {
                displayLabel.setText("Player 1's Turn! (X)");
            } else {
                displayLabel.setText("Player 2's Turn! (O)");
            }
        }

        // After each turn, check for a win
        win = checkWinCon();

        // Display who wins if win == true
        if (win) {
            if (!player1) {
                displayLabel.setText("Player 1 (X) Won! Press New Game to play again!");
            } else {
                displayLabel.setText("Player 2 (O) Won! Press New Game to play again!");
            }

        // Checks for a draw if no one won
        } else if (!win && counter == 9) {
            displayLabel.setText("The game is a draw! Press New Game to play again!");
        }
    }

    // Brute force win checking with buttons
    public boolean checkWinCon() {
        // Check Rows
        if ((button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText())
                && (!button1.getText().equals(""))
                || (button4.getText().equals(button5.getText()) && button4.getText().equals(button6.getText())
                        && (!button4.getText().equals("")))
                || (button7.getText().equals(button8.getText()) && button7.getText().equals(button9.getText())
                        && (!button7.getText().equals(""))))) {
            return true;
        }
        // Check Columns
        else if ((button1.getText().equals(button4.getText()) && button1.getText().equals(button7.getText())
                && (!button1.getText().equals("")))
                || (button2.getText().equals(button5.getText()) && button2.getText().equals(button8.getText())
                        && (!button2.getText().equals("")))
                || (button3.getText().equals(button6.getText()) && button4.getText().equals(button9.getText())
                        && (!button3.getText().equals("")))) {
            return true;
        }
        // Check Diagonals
        else if ((button1.getText().equals(button5.getText()) && button1.getText().equals(button9.getText())
                && (!button1.getText().equals("")))
                || (button3.getText().equals(button5.getText()) && button3.getText().equals(button7.getText()))
                        && (!button3.getText().equals(""))) {
            return true;
        } else {
            return false;
        }
    }
}
