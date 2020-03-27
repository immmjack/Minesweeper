import java.util.Random;

/**
 * Filename: GenerateBombs.java
 * Author: Jack Yang
 * Date: March 26, 2020
 *
 * This class uses recursion to randomly generate bombs on the game board.
 */
public class GenerateBombs extends Bomb {

    /**
     * This is a parametrized constructor for the GenerateBombs, which
     * generates bombs on random position.
     *
     * @param board - the GameBoard upon which user clicks on
     * @param number - the total number of bombs
     */
    public GenerateBombs(GameBoard board, int number) {
        super(board);

        int count = 0;

        do {
            generateBomb();
            count = count + 1;
        }
        while (count < number);
    }

    /**
     * Produce bombs on random tile: If the assigned tile has already
     * contained a bomb, then reassign a tile to receive this bomb by
     * invoking itself.
     */
    public void generateBomb() {
        Random rand = new Random();

        int xLocation = rand.nextInt(super.boardWidth);
        int yLocation = rand.nextInt(super.boardHeight);

        SmartTile tile = (SmartTile) super.board.getTile(xLocation, yLocation);

        if (!tile.getBomb()) {
            // Mark this tile as it has a bomb and been traversed
            tile.setBomb(true);
            tile.setTraverse(true);
        }
        else {
            generateBomb();
        }
    }
}
