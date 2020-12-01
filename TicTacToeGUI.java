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

    private static final int WIDTH = 750;
    private static final int HEIGHT = 750;
    private static final Font BUTTONFONTS = new Font("Comic Sans MS", Font.PLAIN, 100);

    private static boolean player1 = true;
    private static boolean win = false;
    private static int counter = 0;

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

    public static void main(String[] args) {
        TicTacToeGUI tttFrame = new TicTacToeGUI();
        tttFrame.setVisible(true);
    }

    private JButton createButton(JButton aButton) {
        aButton.addActionListener(this);
        // Styling purposes
        aButton.setContentAreaFilled(false);
        aButton.setMargin(new Insets(0, 0, 0, 0));
        aButton.setFont(BUTTONFONTS);
        aButton.setForeground(Color.WHITE);
        return aButton;
    }

    public TicTacToeGUI() {
        super();

        setSize(WIDTH, HEIGHT);
        setTitle("Tic Tac Toe");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menu
        JMenu newGameMenu = new JMenu("File");
        JMenuItem newGame = new JMenuItem("New Game");
        newGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Component comp : boardPanel.getComponents()) {
                    JButton button = (JButton) comp;
                    button.setText("");
                }
                displayLabel.setText("New Game! Player 1 Starts! (X)");
                win = false;
                player1 = true;
                counter = 0;
            }
        });

        JMenuItem exitGame = new JMenuItem("Exit");
        exitGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        newGameMenu.add(newGame);
        newGameMenu.add(exitGame);

        JMenuBar menBar = new JMenuBar();
        menBar.add(newGameMenu);
        setJMenuBar(menBar);
        setLayout(new BorderLayout());

        // Label at the top
        // Shows which player is going and if anyone has won.
        displayLabel = new JLabel("Player 1 Starts! (X)");
        displayLabel.setHorizontalAlignment(JLabel.CENTER);
        add(displayLabel, BorderLayout.NORTH);

        // JPanel to display the board with buttons
        boardPanel = new BlackJPanel();
        boardPanel.setLayout(new GridLayout(3, 3));

        button1 = createButton(new JButton());
        button2 = createButton(new JButton());
        button3 = createButton(new JButton());
        button4 = createButton(new JButton());
        button5 = createButton(new JButton());
        button6 = createButton(new JButton());
        button7 = createButton(new JButton());
        button8 = createButton(new JButton());
        button9 = createButton(new JButton());

        boardPanel.add(button1);
        boardPanel.add(button2);
        boardPanel.add(button3);
        boardPanel.add(button4);
        boardPanel.add(button5);
        boardPanel.add(button6);
        boardPanel.add(button7);
        boardPanel.add(button8);
        boardPanel.add(button9);
        add(boardPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText = e.getActionCommand();
        JButton button = (JButton) e.getSource();

        if (buttonText.equals("") && !win) {
            if (player1) {
                button.setText("X");
            } else {
                button.setText("O");
            }
            player1 = !player1;
            counter++;
            if (player1) {
                displayLabel.setText("Player 1's Turn! (X)");
            } else {
                displayLabel.setText("Player 2's Turn! (O)");
            }
        }
        win = checkWinCon();

        if (win) {
            if (!player1) {
                displayLabel.setText("Player 1 (X) Won! Press New Game to play again!");
            } else {
                displayLabel.setText("Player 2 (O) Won! Press New Game to play again!");
            }
        } else if (!win && counter == 9) {
            displayLabel.setText("The game is a draw! Press New Game to play again!");
        }
    }

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
