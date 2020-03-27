import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

/**
 * Filename: Menu.java
 * Author: Jack Yang
 * Date: March 27, 2020
 *
 * This class sets up the menu of the game Minesweeper. It provides four
 * options of difficulty: beginner, intermediate, advanced, and customed.
 */
public class Menu extends JFrame implements ActionListener {

    private JButton start;

    private JRadioButton beginner;
    private JRadioButton intermediate;
    private JRadioButton advanced;
    private JRadioButton customed;

    private JTextField width;
    private JTextField height;
    private JTextField mines;

    private static final String DIFFICULTY = "Difficulty";
    private static final String BEGINNER = "Beginner";
    private static final String INTERMEDIATE = "Intermediate";
    private static final String ADVANCED = "Advanced";
    private static final String CUSTOMED = "Customed";

    private static final int DIFFICULTY_X_COORDINATE = 100;
    private static final int DIFFICULTY_Y_COORDINATE = 10;
    private static final int DIFFICULTY_WIDTH = 100;
    private static final int DIFFICULTY_HEIGHT = 20;

    private static final int BEGINNER_X_COORDINATE = 40;
    private static final int BEGINNER_Y_COORDINATE = 40;
    private static final int BEGINNER_WIDTH = 150;
    private static final int BEGINNER_HEIGHT = 20;

    private static final String BEGINNER_MINE = "10 mines";
    private static final String BEGINNER_GRID = "10 x 10 tile grid";

    private static final int BEGINNER_BOMBS = 10;
    private static final int BEGINNER_BOARD_WIDTH = 10;
    private static final int BEGINNER_BOARD_HEIGHT = 10;

    private static final int BEGINNER_MINE_X_COORDINATE = 70;
    private static final int BEGINNER_MINE_Y_COORDINATE = 60;
    private static final int BEGINNER_MINE_WIDTH = 100;
    private static final int BEGINNER_MINE_HEIGHT = 20;

    private static final int BEGINNER_GRID_X_COORDINATE = 70;
    private static final int BEGINNER_GRID_Y_COORDINATE = 80;
    private static final int BEGINNER_GRID_WIDTH = 100;
    private static final int BEGINNER_GRID_HEIGHT = 20;

    private static final int INTERMEDIATE_X_COORDINATE = 40;
    private static final int INTERMEDIATE_Y_COORDINATE = 100;
    private static final int INTERMEDIATE_WIDTH = 150;
    private static final int INTERMEDIATE_HEIGHT = 20;

    private static final String INTERMEDIATE_MINE = "40 mines";
    private static final String INTERMEDIATE_GRID = "16 x 16 tile grid";

    private static final int INTERMEDIATE_BOMBS = 40;
    private static final int INTERMEDIATE_BOARD_WIDTH = 16;
    private static final int INTERMEDIATE_BOARD_HEIGHT = 16;

    private static final int INTERMEDIATE_MINE_X_COORDINATE = 70;
    private static final int INTERMEDIATE_MINE_Y_COORDINATE = 120;
    private static final int INTERMEDIATE_MINE_WIDTH = 100;
    private static final int INTERMEDIATE_MINE_HEIGHT = 20;

    private static final int INTERMEDIATE_GRID_X_COORDINATE = 70;
    private static final int INTERMEDIATE_GRID_Y_COORDINATE = 140;
    private static final int INTERMEDIATE_GRID_WIDTH = 100;
    private static final int INTERMEDIATE_GRID_HEIGHT = 20;

    private static final int ADVANCED_X_COORDINATE = 40;
    private static final int ADVANCED_Y_COORDINATE = 160;
    private static final int ADVANCED_WIDTH = 160;
    private static final int ADVANCED_HEIGHT = 20;

    private static final String ADVANCED_MINE = "100 mines";
    private static final String ADVANCED_GRID = "30 x 25 tile grid";

    private static final int ADVANCED_BOMBS = 100;
    private static final int ADVANCED_BOARD_WIDTH = 30;
    private static final int ADVANCED_BOARD_HEIGHT = 25;

    private static final int ADVANCED_MINE_X_COORDINATE = 70;
    private static final int ADVANCED_MINE_Y_COORDINATE = 180;
    private static final int ADVANCED_MINE_WIDTH = 100;
    private static final int ADVANCED_MINE_HEIGHT = 20;

    private static final int ADVANCED_GRID_X_COORDINATE = 70;
    private static final int ADVANCED_GRID_Y_COORDINATE = 200;
    private static final int ADVANCED_GRID_WIDTH = 100;
    private static final int ADVANCED_GRID_HEIGHT = 20;

    private static final int CUSTOMED_X_COORDINATE = 40;
    private static final int CUSTOMED_Y_COORDINATE = 220;
    private static final int CUSTOMED_WIDTH = 100;
    private static final int CUSTOMED_HEIGHT = 20;

    private static final String CUSTOMED_MINE_RANGE = "Mines (10-100):";
    private static final String CUSTOMED_WIDTH_RANGE = "Width (10-30):";
    private static final String CUSTOMED_HEIGHT_RANGE = "height (10-25):";

    private static final int CUSTOMED_MINE_X_COORDINATE = 70;
    private static final int CUSTOMED_MINE_Y_COORDINATE = 280;
    private static final int CUSTOMED_MINE_WIDTH = 90;
    private static final int CUSTOMED_MINE_HEIGHT = 20;

    private static final int CUSTOMED_MINE_TEXT_X_COORDINATE = 170;
    private static final int CUSTOMED_MINE_TEXT_Y_COORDINATE = 280;
    private static final int CUSTOMED_MINE_TEXT_WIDTH = 40;
    private static final int CUSTOMED_MINE_TEXT_HEIGHT = 20;

    private static final int CUSTOMED_WIDTH_X_COORDINATE = 70;
    private static final int CUSTOMED_WIDTH_Y_COORDINATE = 240;
    private static final int CUSTOMED_WIDTH_WIDTH = 80;
    private static final int CUSTOMED_WIDTH_HEIGHT = 20;

    private static final int CUSTOMED_WIDTH_TEXT_X_COORDINATE = 170;
    private static final int CUSTOMED_WIDTH_TEXT_Y_COORDINATE = 240;
    private static final int CUSTOMED_WIDTH_TEXT_WIDTH = 40;
    private static final int CUSTOMED_WIDTH_TEXT_HEIGHT = 20;

    private static final int CUSTOMED_HEIGHT_X_COORDINATE = 70;
    private static final int CUSTOMED_HEIGHT_Y_COORDINATE = 260;
    private static final int CUSTOMED_HEIGHT_WIDTH = 90;
    private static final int CUSTOMED_HEIGHT_HEIGHT = 20;

    private static final int CUSTOMED_HEIGHT_TEXT_X_COORDINATE = 170;
    private static final int CUSTOMED_HEIGHT_TEXT_Y_COORDINATE = 260;
    private static final int CUSTOMED_HEIGHT_TEXT_WIDTH = 40;
    private static final int CUSTOMED_HEIGHT_TEXT_HEIGHT = 20;

    private static final String NEW_GAME = "New Game";

    private static final int NEW_GAME_X_COORDINATE = 80;
    private static final int NEW_GAME_Y_COORDINATE = 320;
    private static final int NEW_GAME_WIDTH = 100;
    private static final int NEW_GAME_HEIGHT = 20;

    private static final int WIDTH = 280;
    private static final int HEIGHT = 400;

    private static final String MINESWEEPER = "Minesweeper";

    private static final String REGEX = "[0-9]*";
    private static final String VALID_NUMBER = "Please enter correct numbers!";

    /**
     * This is a parametrized constructor that creates a Menu object by the
     * given title.
     *
     * @param title - the title on the Menu
     */
    public Menu(String title) {
        // Set Menu's title
        setTitle(title);

        // Create the subtitle: difficulty level
        JLabel subtitle = new JLabel(DIFFICULTY);
        subtitle.setBounds(
            DIFFICULTY_X_COORDINATE, DIFFICULTY_Y_COORDINATE,
            DIFFICULTY_WIDTH, DIFFICULTY_HEIGHT
        );
        add(subtitle);

        // Set the button and give description for beginner level
        beginner = new JRadioButton(BEGINNER);
        beginner.setBounds(
            BEGINNER_X_COORDINATE, BEGINNER_Y_COORDINATE,
            BEGINNER_WIDTH, BEGINNER_HEIGHT
        );
        add(beginner);

        JLabel bMine = new JLabel(BEGINNER_MINE);
        bMine.setBounds(
            BEGINNER_MINE_X_COORDINATE, BEGINNER_MINE_Y_COORDINATE,
            BEGINNER_MINE_WIDTH, BEGINNER_MINE_HEIGHT
        );

        JLabel bGrid = new JLabel(BEGINNER_GRID);
        bGrid.setBounds(
            BEGINNER_GRID_X_COORDINATE, BEGINNER_GRID_Y_COORDINATE,
            BEGINNER_GRID_WIDTH, BEGINNER_GRID_HEIGHT
        );

        add(bMine);
        add(bGrid);

        // Set the button and give description for intermediate level
        intermediate = new JRadioButton(INTERMEDIATE);
        intermediate.setBounds(
            INTERMEDIATE_X_COORDINATE, INTERMEDIATE_Y_COORDINATE,
            INTERMEDIATE_WIDTH, INTERMEDIATE_HEIGHT
        );
        add(intermediate);

        JLabel iMine = new JLabel(INTERMEDIATE_MINE);
        iMine.setBounds(
            INTERMEDIATE_MINE_X_COORDINATE, INTERMEDIATE_MINE_Y_COORDINATE,
            INTERMEDIATE_MINE_WIDTH, INTERMEDIATE_MINE_HEIGHT
        );

        JLabel iGrid = new JLabel(INTERMEDIATE_GRID);
        iGrid.setBounds(
            INTERMEDIATE_GRID_X_COORDINATE, INTERMEDIATE_GRID_Y_COORDINATE,
            INTERMEDIATE_GRID_WIDTH, INTERMEDIATE_GRID_HEIGHT
        );

        add(iMine);
        add(iGrid);

        // Set the button and give description for advanced level
        advanced = new JRadioButton(ADVANCED);
        advanced.setBounds(
            ADVANCED_X_COORDINATE, ADVANCED_Y_COORDINATE,
            ADVANCED_WIDTH, ADVANCED_HEIGHT
        );
        add(advanced);

        JLabel aMine = new JLabel(ADVANCED_MINE);
        aMine.setBounds(
            ADVANCED_MINE_X_COORDINATE, ADVANCED_MINE_Y_COORDINATE,
            ADVANCED_MINE_WIDTH, ADVANCED_MINE_HEIGHT
        );

        JLabel aGrid = new JLabel(ADVANCED_GRID);
        aGrid.setBounds(
            ADVANCED_GRID_X_COORDINATE, ADVANCED_GRID_Y_COORDINATE,
            ADVANCED_GRID_WIDTH, ADVANCED_GRID_HEIGHT
        );

        add(aMine);
        add(aGrid);

        // Set the button and give description for customed level
        customed = new JRadioButton(CUSTOMED);
        customed.setBounds(
            CUSTOMED_X_COORDINATE, CUSTOMED_Y_COORDINATE,
            CUSTOMED_WIDTH, CUSTOMED_HEIGHT
        );
        add(customed);

        JLabel cWidth = new JLabel(CUSTOMED_WIDTH_RANGE);
        cWidth.setBounds(
            CUSTOMED_WIDTH_X_COORDINATE, CUSTOMED_WIDTH_Y_COORDINATE,
            CUSTOMED_WIDTH_WIDTH, CUSTOMED_WIDTH_HEIGHT
        );
        add(cWidth);

        width = new JTextField();
        width.setBounds(
            CUSTOMED_WIDTH_TEXT_X_COORDINATE, CUSTOMED_WIDTH_TEXT_Y_COORDINATE,
            CUSTOMED_WIDTH_TEXT_WIDTH, CUSTOMED_WIDTH_TEXT_HEIGHT
        );
        add(width);

        JLabel cHeight = new JLabel(CUSTOMED_HEIGHT_RANGE);
        cHeight.setBounds(
            CUSTOMED_HEIGHT_X_COORDINATE, CUSTOMED_HEIGHT_Y_COORDINATE,
            CUSTOMED_HEIGHT_WIDTH, CUSTOMED_HEIGHT_HEIGHT
        );
        add(cHeight);

        height = new JTextField();
        height.setBounds(
            CUSTOMED_HEIGHT_TEXT_X_COORDINATE,
            CUSTOMED_HEIGHT_TEXT_Y_COORDINATE,
            CUSTOMED_HEIGHT_TEXT_WIDTH, CUSTOMED_HEIGHT_TEXT_HEIGHT
        );
        add(height);

        JLabel cMines = new JLabel(CUSTOMED_MINE_RANGE);
        cMines.setBounds(
            CUSTOMED_MINE_X_COORDINATE, CUSTOMED_MINE_Y_COORDINATE,
            CUSTOMED_MINE_WIDTH, CUSTOMED_MINE_HEIGHT
        );
        add(cMines);

        mines = new JTextField();
        mines.setBounds(
            CUSTOMED_MINE_TEXT_X_COORDINATE, CUSTOMED_MINE_TEXT_Y_COORDINATE,
            CUSTOMED_MINE_TEXT_WIDTH, CUSTOMED_MINE_TEXT_HEIGHT
        );
        add(mines);

        // Create a button for a new game
        start = new JButton(NEW_GAME);
        start.setBounds(
            NEW_GAME_X_COORDINATE, NEW_GAME_Y_COORDINATE,
            NEW_GAME_WIDTH, NEW_GAME_HEIGHT
        );
        add(start);

        // Initialize the text editing for width, height, and mines in
        // customed level
        width.setEditable(false);
        height.setEditable(false);
        mines.setEditable(false);

        // Add action listener on each button
        customed.addActionListener(this);
        beginner.addActionListener(this);
        intermediate.addActionListener(this);
        advanced.addActionListener(this);
        start.addActionListener(this);

        // Set up a button group
        ButtonGroup group = new ButtonGroup();
        group.add(beginner);
        group.add(intermediate);
        group.add(advanced);
        group.add(customed);

        // Initialize the Menu object
        beginner.setSelected(true);
        setSize(WIDTH, HEIGHT);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * This is a helper method to check the customed width, height, and bomb
     * are appropriate or not.
     *
     * @param cWidth - the width of the board
     * @param cHeight - the height of the board
     * @param cBomb - the number of bombs
     *
     * @return boolean
     */
    public boolean checkValid(String cWidth, String cHeight, String cBomb) {
        // Initialize a Pattern object to check the input only contains digit
        Pattern pattern = Pattern.compile(REGEX);

        if (cWidth == null || cHeight == null || cBomb == null) {
            return false;
        }
        else if (cWidth.length() == 0 || cHeight.length() == 0 ||
                                                        cBomb.length() == 0) {
            return false;
        }
        else if (
            (!pattern.matcher(cWidth).matches()) ||
                (!pattern.matcher(cHeight).matches()) ||
                    (!pattern.matcher(cBomb).matches())
        ) {
            return false;
        }
        else if (
            (Integer.parseInt(cWidth) < 10) ||
                (Integer.parseInt(cWidth) > 30) ||
                    (Integer.parseInt(cHeight) < 10) ||
                        (Integer.parseInt(cHeight) > 25) ||
                            (Integer.parseInt(cBomb) < 10) ||
                                (Integer.parseInt(cBomb) > 100)
        ) {
            return false;
        }
        else {
            return (
                Integer.parseInt(cWidth) * Integer.parseInt(cHeight)
                                                    >= Integer.parseInt(cBomb)
            );
        }
    }

    /**
     * This is an implementation of action listener interface.
     *
     * @param e - the click event
     */
    public void actionPerformed(ActionEvent e) {
        // Set the text to be editable if the user chooses customed level
        if (e.getSource() == customed) {
            width.setEditable(true);
            height.setEditable(true);
            mines.setEditable(true);
        }
        else if (e.getSource() == start) {
            // Initialize the gameboard for starting a new game
            int boardWidth = 0;
            int boardHeight = 0;
            int bombs = 0;
            boolean errorFlag = false;

            if (beginner.isSelected()) {
                boardWidth = BEGINNER_BOARD_WIDTH;
                boardHeight = BEGINNER_BOARD_HEIGHT;
                bombs = BEGINNER_BOMBS;
            }
            else if (intermediate.isSelected()) {
                boardWidth = INTERMEDIATE_BOARD_WIDTH;
                boardHeight = INTERMEDIATE_BOARD_HEIGHT;
                bombs = INTERMEDIATE_BOMBS;
            }
            else if (advanced.isSelected()) {
                boardWidth = ADVANCED_BOARD_WIDTH;
                boardHeight = ADVANCED_BOARD_HEIGHT;
                bombs = ADVANCED_BOMBS;
            }
            else {
                if (!this.checkValid(
                    width.getText(), height.getText(), mines.getText()
                )) {
                    errorFlag = true;
                    JOptionPane.showMessageDialog(null, VALID_NUMBER);
                }
                else {
                    boardWidth = Integer.parseInt(width.getText());
                    boardHeight = Integer.parseInt(height.getText());
                    bombs = Integer.parseInt(mines.getText());
                }
            }

            if (!errorFlag) {
                this.dispose();
                GameBoard b = new GameBoard(
                    MINESWEEPER, boardWidth, boardHeight
                );
                new GenerateBombs(b, bombs);
                ((SmartTile) b.getTile(0, 0)).setTime(
                    System.currentTimeMillis()
                );
            }
        }
        else {
            width.setEditable(false);
            height.setEditable(false);
            mines.setEditable(false);
        }
    }
}
