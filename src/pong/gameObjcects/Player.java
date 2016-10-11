package pong.gameObjcects;

/**
 * Definition of the player object
 *
 * @author d.peters
 */
public class Player extends GameShape {

    /**
     * Dimensions of the player object
     */
    int width, height;
    
    /**
     * Flags to check for keyboard input
     */
    public boolean UP = false, DOWN = false;
    
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
        this.x = posX;
        this.y = posY;
        this.speed = 10;
        this.width = 5;
        this.height = 30;
        this.playerId = playerId;
    }

    /**
     *
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     *
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     *
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     *
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Check if UP was set
     *
     * @return returns boolean showing if the up action key was pressed
     */
    public boolean isUP() {
        return UP;
    }

    /**
     * Setter for UP
     *
     * @param UP changes UP if the corresponding Key was pressed or released
     */
    public void setUP(boolean UP) {
        this.UP = UP;
    }

    /**
     * Check if DOWN was set
     *
     * @return returns boolean showing if the down action key was pressed
     */
    public boolean isDOWN() {
        return DOWN;
    }

    /**
     * Setter for DOWN
     *
     * @param DOWN changes UP if the corresponding Key was pressed or released
     */
    public void setDOWN(boolean DOWN) {
        this.DOWN = DOWN;
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
        setScore(this.getScore() + 1);
    }

    /**
     * Check for keys pressed and move according to key
     * (Workaround for input lag)
     *
     * @param panelHeight Height of the Panel to see if out of bounds when
     * moving down
     */
    public void move(int panelHeight) {
        if (this.UP) {
            this.moveUp();
        }
        if (this.DOWN) {
            this.moveDown(panelHeight);
        }
    }

    /**
     * Moves the Player up by his speed. checks if the player is out of bounds
     */
    public void moveUp() {
        if (this.y > 0) {
            this.y -= speed;
        }
    }

    /**
     * Moves the Player down by his speed. checks if the Player is out of bounds
     *
     * @param panelHeight current height of the game panel object
     */
    public void moveDown(int panelHeight) {
        if (this.getY() < panelHeight - this.getHeight()) {
            this.y += speed;
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

    /**
     * checks if the player has deflected the ball because each player has a
     * different location, the player id needs to be checked in order to make
     * this method to work
     *
     * @param ballX position X of the ball object
     * @param ballY position Y of the ball object
     * @return boolean that tells the game whether the ball has been deflected
     * by the player
     */
    public boolean deflectedBall(int ballX, int ballY) {
        int playerPos;
        if (this.playerId == 1) {
            playerPos = (int) this.getX() + (int) this.getWidth();
        } else {
            playerPos = (int) this.getX() - (int) this.getWidth();
        }
        boolean deflected = false;
        if (ballX == playerPos && ballY >= this.getY()
                && ballY <= (this.getY() + this.getHeight())) {
            deflected = true;
        }
        return deflected;
    }
}
