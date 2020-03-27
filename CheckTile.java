/**
 * Filename: CheckTile.java
 * Author: Jack Yang
 * Date: March 26, 2020
 *
 * This class provides methods to count the total number of bombs which are
 * surrounding the given tile.
 */
public class CheckTile {

    private GameBoard board;

    private int boardWidth;
    private int boardHeight;

    private static final int MARGIN = 20;
    private static final int SIDELENGTH = 20;

    private static final int[] TRAVERSE_AROUND_X = {-1, 0, 1};
    private static final int[] TRAVERSE_AROUND_Y = {-1, 0, 1};

    private static final String BOMB = "/bomb.png";
    private static final String WRONG_FLAG = "/wrong-flag.png";
    private static final String DIRECTORY = "/";
    private static final String SUFFIX = ".png";
    private static final String ZERO_BOMB_TILE = "/0.png";

    /**
     * This is a parametrized constructor of CheckTile.
     *
     * @param board - the GameBoard upon which user clicks on
     */
    public CheckTile(GameBoard board) {
        this.board = board;
        this.boardWidth = (board.getWidth() - MARGIN) / SIDELENGTH;
        this.boardHeight = (board.getHeight() - MARGIN) / SIDELENGTH;
    }

    /**
     * Check the position is out of bound or not
     *
     * @param x - the x coordinate of the given tile
     * @param y - the y coordinate of the given tile
     *
     * @return boolean
     */
    public boolean checkOutOfBound(int x, int y) {
        return x < 0 || x >= this.boardWidth || y < 0 || y >= this.boardHeight;
    }

    /**
     * Check whether the user wins the game or not by finding all the bombs
     *
     * @return boolean
     */
    protected boolean isWin() {
        // Iterate the whole game board
        for (int y = 0; y < this.boardHeight; y = y + 1) {
            for (int x = 0; x < this.boardWidth; x = x + 1) {
                if (!((SmartTile) this.board.getTile(x, y)).getTraverse()) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Reveal all bombs on the board and check the user's guesses
     *
     * @param currentX - the x coordinate of the given tile
     * @param currentY - the y coordinate of the given tile
     */
    protected void showBomb(int currentX, int currentY) {
        // Iterate the whole game board
        for (int y = 0; y < this.boardHeight; y = y + 1) {
            for (int x = 0; x < this.boardWidth; x = x + 1) {
                if (currentX == x && currentY == y) {
                    // do nothing
                }
                else if (
                    ((SmartTile) this.board.getTile(x, y)).getBomb()
                ) {
                    this.board.getTile(x, y).setImage(
                        CheckTile.class.getResource(BOMB)
                    );
                }
                else if (
                    ((SmartTile) this.board.getTile(x, y)).getFlag()
                ) {
                    this.board.getTile(x, y).setImage(
                        CheckTile.class.getResource(WRONG_FLAG)
                    );
                }
            }
        }
    }

    /**
     * Count and set the total number of bombs which surrounds the given tile
     *
     * @param currentX - the x coordinate of the given tile
     * @param currentX - the y coordinate of the given tile
     */
    protected void countBombs(int currentX, int currentY) {
        int count = 0;
        SmartTile currentTile;

        if (this.checkOutOfBound(currentX, currentY)) {
            return;
        }
        else if (
            (
                (SmartTile) (this.board.getTile(currentX, currentY))
            ).getTraverse()
        ) {
            return;
        }
        else {
            SmartTile tile;

            currentTile = (
                (SmartTile) (this.board.getTile(currentX, currentY))
            );
            currentTile.setTraverse(true);

            // Iterate the surrounding 8 tiles
            for (int x : TRAVERSE_AROUND_X) {
                for (int y : TRAVERSE_AROUND_Y) {
                    if (checkOutOfBound(x + currentX, y + currentY)) {
                        // do nothing
                    }
                    else if (x == 0 && y == 0) {
                        // do nothing
                    }
                    else {
                        tile = (SmartTile) (this.board.getTile(
                            x + currentX, y + currentY
                        ));

                        if (tile.getBomb()) {
                            count = count + 1;
                        }
                        else {
                            // do nothing
                        }
                    }
                }
            }
        }

        // Set the new tile
        if (count != 0) {
            currentTile.setImage(
                CheckTile.class.getResource(DIRECTORY + count + SUFFIX)
            );
        }
        else {
            currentTile.setImage(
                CheckTile.class.getResource(ZERO_BOMB_TILE)
            );
            countBombs(currentX - 1, currentY - 1);
            countBombs(currentX, currentY - 1);
            countBombs(currentX + 1, currentY - 1);
            countBombs(currentX - 1, currentY);
            countBombs(currentX + 1, currentY);
            countBombs(currentX - 1, currentY + 1);
            countBombs(currentX, currentY + 1);
            countBombs(currentX + 1, currentY + 1);
        }
    }
}
