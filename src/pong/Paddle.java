package pong;

import java.awt.*;

/**
 * Keyboard configuration of the Game
 *
 * @author d.peters
 */
public class Paddle extends Rectangle {

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
     * Defines how fast the flipper/player can move
     */
    private int speed = 10;

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
     * Setter for the flipper/player score
     *
     * @param score new score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * add +1 to score counter of the paddle/player
     */
    public void incrementScore() {
        setScore(this.getScore() + 1);
    }

    /**
     * Getter for the flipper speed
     *
     * @return The current speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Setter for the flipper speed
     *
     * @param speed New speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Initialize the Paddle with XY position, width and height
     *
     * @param posX X position on gamearea
     * @param posY Y position on gamearea
     * @param width width of the paddle
     * @param height height of the paddle
     * @param playerId
     */
    public Paddle(int posX, int posY, int width, int height, int playerId) {
        this.x = posX;
        this.y = posY;
        this.width = width;
        this.height = height;
        this.playerId = playerId;
    }

    /**
     * Check for keys pressed and move (Workaround for input lag)
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
     * Moves the Paddle up by speed of itself checks if the Paddle is out of
     * bounds
     */
    public void moveUp() {
        if (this.y > 0) {
            this.y -= speed;
        }
    }

    /**
     * Moves the Paddle down by speed of itself checks if the Paddle is out of
     * bounds
     *
     * @param panelHeight
     */
    public void moveDown(int panelHeight) {
        if (this.getY() < panelHeight - this.getHeight()) {
            this.y += speed;
        }
    }

    public boolean hasWon(int victCond) {
        boolean isWinner = false;
        if (this.score == victCond) {
            isWinner = true;
        }
        return isWinner;
    }

    public boolean deflectedBall(int ballX, int ballY) {
        int playerPos;
        if (this.playerId == 1){
            playerPos = (int)this.getX() + (int)this.getWidth();
        } else {
            playerPos = (int)this.getX() - (int)this.getWidth();
        }
        boolean deflected = false;
        if (ballX == playerPos && ballY >= this.getY()
                && ballY <= (this.getY() + this.getHeight())) {
            deflected = true;
        }
        return deflected;
    }
}
