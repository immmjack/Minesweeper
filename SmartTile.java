import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Filename: SmartTile.java
 * Author: Jack Yang
 * Date: March 26, 2020
 *
 * This class sets up functions and properties of each tile on the game board.
 */
public class SmartTile extends Tile implements MouseListener, TimeChecker {

    private boolean isBomb;
    private boolean isFlag;
    private boolean isTraversed;

    private int xLocation;
    private int yLocation;

    private long time;

    private static final String BLOCK = "/block.png";
    private static final String BOMB_OUT = "/bomb-out.png";
    private static final String LOSE_FACE = "/lose-face.png";
    private static final String WIN = "/win.png";
    private static final String RED_FLAG = "/red-flag.png";
    private static final String QUESTION_MARK = "/question-mark.png";

    private static final String GAME_END_TIME =
                                    "You used %s. Do you want to try again?";
    private static final String GAME_OVER = "Game Over";
    private static final String WIN_TIME =
                        "You win this game in %s! Do you want to try again?";
    private static final String CONGRAT = "Congratulations";

    private static final String MINESWEEPER = "Minesweeper";

    private static final int ONE = 1;
    private static final int TWO = 2;

    /**
     * This is a parametrized constructor for the SmartTile, which can be
     * placed on a game board.
     *
     * @param x - the x coordinate of this tile on the game board
     * @param y - the y coordinate of this tile on the game board
     * @param board - the GameBoard upon which this tile resides
     */
    public SmartTile(int x, int y, GameBoard board) {
        super(x, y, SmartTile.class.getResource(BLOCK), board);

        this.xLocation = x;
        this.yLocation = y;

        this.isBomb = false;
        this.isFlag = false;
        this.isTraversed = false;

        this.time = 0;

        addMouseListener(this);
    }

    /**
     * Set bomb existence of the tile
     *
     * @param result - bomb existence
     */
    protected void setBomb(boolean result) {
        this.isBomb = result;
    }

    /**
     * Return bomb existence of the tile
     *
     * @return boolean - bomb existence
     */
    protected boolean getBomb() {
        return this.isBomb;
    }

    /**
     * Set traversal state of the tile
     *
     * @param result - traversal state
     */
    protected void setTraverse(boolean result) {
        this.isTraversed = result;
    }

    /**
     * Return traversal state of the tile
     *
     * @return boolean - traversal state
     */
    protected boolean getTraverse() {
        return this.isTraversed;
    }

    /**
     * Return a boolean value whether user sets a red flag in the tile or not
     *
     * @return boolean - the state whether the tile has been marked as a
     *                   bomb or not
     */
    protected boolean getFlag() {
        return this.isFlag;
    }

    /**
	 * Set the start time of the game
     *
	 * @param time - the time presented as milliseconds
	 */
    protected void setTime(long time) {
        this.time = time;
    }

    /**
	 * Return the game start time
     *
	 * @return long - the time presented as milliseconds
	 */
    protected long getTime() {
        return this.time;
    }

    /**
     * Set up the pop-up window
     *
     * @param message - the message to display on the window
     * @param title - the title string for the window
     * @param image - the icon
     */
    public void window(String message, String title, Icon image) {
        int choose = JOptionPane.showConfirmDialog(
            this.board, message, title, JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE, image
        );

        if (choose == JOptionPane.YES_OPTION) {
            new Menu(MINESWEEPER);
        }

        this.board.dispose();
    }

    /**
     * Once get click event, detect bombs and expand into empty space
     */
    public void clicked() {
        CheckTile tile = new CheckTile(this.board);
        this.isFlag = false;

        // Check the tile contains a bomb or not
        if (this.isBomb) {
            // Reveal bomb if there is a bomb
            this.setImage(SmartTile.class.getResource(BOMB_OUT));
            long time = System.currentTimeMillis() - (
                ((SmartTile) board.getTile(0, 0)).getTime()
            );
            tile.showBomb(this.xLocation, this.yLocation);
            window(
                String.format(GAME_END_TIME, TimeChecker.calculateTime(time)),
                GAME_OVER,
                new ImageIcon(SmartTile.class.getResource(LOSE_FACE))
            );
        }
        else {
            this.isTraversed = false;

            // Count the surrounding bombs if there is not a bomb
            tile.countBombs(this.xLocation, this.yLocation);

            if (tile.isWin()) {
                long time = System.currentTimeMillis() - (
                    ((SmartTile) board.getTile(0, 0)).getTime()
                );
                tile.showBomb(this.xLocation, this.yLocation);
                window(
                    String.format(WIN_TIME, TimeChecker.calculateTime(time)),
                    CONGRAT,
                    new ImageIcon(SmartTile.class.getResource(WIN))
                );
            }
        }
    }

    /**
     * Respond right-click events
     *
     * @param e - the event when user clicks on the tile
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        // Check the right click by user
        if (e.getButton() == MouseEvent.BUTTON3) {
            int clickCount = e.getClickCount();

            // Show the red flag
            if (clickCount == ONE) {
                setImage(SmartTile.class.getResource(RED_FLAG));
                this.isFlag = true;
            }

            // Show the question mark
            if (clickCount == TWO) {
                setImage(SmartTile.class.getResource(QUESTION_MARK));
                this.isFlag = false;
            }
        }
    }

    /**
     * This press event is not going to be handled in this class.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        // do nothing
    }

    /**
     * This release event is not going to be handled in this class.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        // do nothing
    }

    /**
     * This enter event is not going to be handled in this class.
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        // do nothing
    }

    /**
     * This exit event is not going to be handled in this class.
     */
    @Override
    public void mouseExited(MouseEvent e) {
        // do nothing
    }
}
