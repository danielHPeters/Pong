package pong.gameObjcects;

/**
 * Definition of the player object
 *
 * @author d.peters
 */
public class Player extends MovableObject {

    /**
     * counter for player score
     */
    private int score = 0;

    /**
     * default constructor.
     * initializes the players x and y position as well ad the  width and height
     * @param posX X position on gamearea
     * @param posY Y position on gamearea
     */
    public Player(int posX, int posY) {
        this.up = false;
        this.down = false;
        this.x = posX;
        this.y = posY;
        this.speed = 10;
        this.width = 5;
        this.height = 40;
    }

    /**
     * getter for the player score
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
     * input lag)d
     * @param panelHeight Height of the Panel to see if out of bounds when
     * moving down
     */
    public void moveVert(int panelHeight) {
        if (this.up && this.y > 0) {
            this.moveUp();
        }
        if (this.down && this.y < panelHeight - this.height) {
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
