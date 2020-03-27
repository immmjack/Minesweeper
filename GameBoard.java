import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Filename: GameBoard.java
 * Author: Jack Yang
 * Date: March 25, 2020
 *
 * This class sets up the menu of the game Minesweeper. It provides four
 * options of difficulty: beginner, intermediate, advanced, and customed.
 */
public class GameBoard extends JFrame implements ActionListener {

    private JPanel boardPanel = new JPanel();

    private int boardWidth;
    private int boardHeight;
    private Tile[][] board;

    private static final int MARGIN = 20;
    private static final int SIDELENGTH = 20;

    /**
     * This is a parametrized constructor for GameBoard class.
     *
     * @param title - the name printed in the window bar
     * @param width - the width of the game area, in tiles
     * @param height - the height of the game area, in tiles
     */
    public GameBoard(String title, int width, int height) {
        super();

        // Create the GameBoard object by the given parameter
        this.boardWidth = width;
        this.boardHeight = height;
        this.board = new Tile[width][height];

        // Create a new window
        setTitle(title);
        setSize(MARGIN + width * SIDELENGTH, MARGIN + height * SIDELENGTH);
        setContentPane(boardPanel);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        boardPanel.setLayout(new GridLayout(height,width));

        for (int j = 0; j < height; j = j + 1) {
            for (int i = 0; i < width; i = i + 1) {
                this.board[i][j] = new SmartTile(i, j, this);
                this.board[i][j].addActionListener(this);

                boardPanel.add(this.board[i][j]);
            }
        }

        setVisible(true);
    }

    /**
     * Get the tile at a given position
     *
     * @param x - the x coordinate of the tile requested
     * @param y - the y coordinate of the tile requested
     *
     * @return Tile
     */
    public Tile getTile(int x, int y) {
        if (x < 0 || x >= this.boardWidth || y < 0 || y >= this.boardHeight) {
            return null;
        }

        return this.board[x][y];
    }

    /**
     * Invoke when an event happens
     *
     * @param e - event
     */
    public void actionPerformed(ActionEvent e) {
		// The button that has been pressed.
		Tile b = (Tile) e.getSource();
		b.clicked();
	}
}
