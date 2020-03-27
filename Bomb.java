/**
 * Filename: Bomb.java
 * Author: Jack Yang
 * Date: March 26, 2020
 *
 * This class is abstract, which provides general properties of the Bomb.
 */
public abstract class Bomb {

    protected GameBoard board;
    protected int boardWidth;
    protected int boardHeight;

    private static final int MARGIN = 20;

    /**
     * This is a parametrized constructor for Bomb.
     *
     * @param board - the game board upon which user clicks on
     */
    public Bomb(GameBoard board) {
        this.board = board;

        boardWidth = (board.getWidth() - MARGIN) / MARGIN;
        boardHeight = (board.getHeight() - MARGIN) / MARGIN;
    }

    /**
     * Invoke when producing bombs on the game board
     */
    protected abstract void generateBomb();
}
