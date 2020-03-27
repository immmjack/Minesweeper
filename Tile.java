import javax.swing.*;
import java.net.URL;

/**
 * Filename: Tile.java
 * Author: Jack Yang
 * Date: March 25, 2020
 *
 * This class sets up the tiles of the game Minesweeper. It provides the
 * general properties and methods of the tile.
 */
public abstract class Tile extends JButton {

    protected int xLocation;
    protected int yLocation;

    protected GameBoard board;

    /**
     * This is a parametrized constructor for the tile class.
     *
     * @param x - the coordinate of x
     * @param y - the coordinate of y
     * @param filename - location of the file
     * @param board - game's window
     */
    public Tile(int x, int y, URL filename, GameBoard board) {
        super(new ImageIcon(filename));

        this.board = board;
        this.xLocation = x;
        this.yLocation = y;
    }

    /**
     * Set the icon to the given tile
     *
     * @param filename - location of the file
     */
    public void setImage(URL filename) {
        this.setIcon(new ImageIcon(filename));
    }

    /**
     * Invoke when a user clicks on this tile
     */
    public abstract void clicked();
}
