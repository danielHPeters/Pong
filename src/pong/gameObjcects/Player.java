package pong.gameObjcects;

/**
 * Definition of the player object
 *
 * @author d.peters
 */
public class Player extends MovableObject {

    /**
     * ID of the Player (set with constructor)
     */
    private final int playerId;

    /**
     * Counter for player score
     */
    private int score = 0;

    /**
     * Initialize the Paddle with XY position, width and height
     *
     * @param posX X position on gamearea
     * @param posY Y position on gamearea
     * @param playerId
     */
    public Player(int posX, int posY, int playerId) {
        this.UP = false;
        this.DOWN = false;
        this.x = posX;
        this.y = posY;
        this.speed = 10;
        this.width = 5;
        this.height = 40;
        this.playerId = playerId;
    }

    /**
     * Getter for the flipper/player score
     *
     * @return the current score
     */
    public int getScore() {
        return score;
    }

    /**
     * Setter for the player score
     *
     * @param score new score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * add +1 to score counter of the player
     */
    public void incrementScore() {
        this.score += 1;
    }

    /**
     * Check for keys pressed and moveVert according to key (Workaround for
     * input lag)
     *
     * @param panelHeight Height of the Panel to see if out of bounds when
     * moving down
     */
    public void moveVert(int panelHeight) {
        if (this.UP && this.y > 0) {
            this.moveUp();
        }
        if (this.DOWN && this.y < panelHeight - this.height) {
            this.moveDown();
        }
    }

    /**
     * check if the player has won the game
     *
     * @param victCond the amount of scores required to win
     * @return boolean which tells the game whether the player has won
     */
    public boolean hasWon(int victCond) {
        boolean isWinner = false;
        if (this.score == victCond) {
            isWinner = true;
        }
        return isWinner;
    }
}
