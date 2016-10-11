package pong.uiElements;

import java.awt.*;
import javax.swing.*;
import pong.gameObjcects.Ball;
import pong.gameObjcects.Player;

public class GamePanel extends JPanel implements Runnable {

    private boolean playing;
    private int victoryCond = 6; // Score required for victoryCond
    private int gameSpeed = 50;
    public Player pl1 = new Player(10, 100, 1);
    public Player pl2 = new Player(225, 100, 2);
    public Ball ball = new Ball(100, 100);

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    /**
     * 
     * @return 
     */
    public int getVictoryCond() {
        return victoryCond;
    }

    /**
     * 
     * @param victoryCond 
     */
    public void setVictoryCond(int victoryCond) {
        this.victoryCond = victoryCond;
    }

    /**
     * 
     * @return 
     */
    public int getGameSpeed() {
        return gameSpeed;
    }

    /**
     * 
     * @param gameSpeed 
     */
    public void setGameSpeed(int gameSpeed) {
        this.gameSpeed = gameSpeed;
    }

    /**
     * 
     * @param g 
     */
    public void drawBall(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(ball.getX(), ball.getY(), ball.getSize(), ball.getSize());
    }

    /**
     * 
     * @param g 
     */
    public void drawPlayers(Graphics g) {
        g.fillRect(pl1.getX(), pl1.getY(), pl1.getWidth(), pl1.getHeight());
        g.fillRect(pl2.getX(), pl2.getY(), pl2.getWidth(), pl2.getHeight());
    }

    /**
     * 
     * @param g 
     */
    public void drawTexts(Graphics g) {
        //Draw scores
        g.drawString("Player 1: " + pl1.getScore(), 25, 10);
        g.drawString("Player 2: " + pl2.getScore(), 150, 10);
        if (!playing) {
            g.drawString("Game Over", 100, 125);
        }
    }

    /**
     * Main drawing method
     *
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBall(g);
        drawPlayers(g);
        drawTexts(g);
        repaint();
    }

    /**
     * the game loop which changes the objects according to events
     */
    public void gameLoop() {
        while (playing) {
            /**
             * Delay the game loop (otherwise the game will instantly end) the
             * duration of the delay also determines the speed of the game
             *
             */
            try {
                Thread.sleep(gameSpeed);
            } catch (InterruptedException ex) {

            }

            // Move the ball horizontally
            ball.moveHor(this.getWidth());

            // Move the ball vertically
            ball.moveVert(this.getHeight());

            // Moving players
            pl1.move(this.getHeight());
            pl2.move(this.getHeight());

            // check if the ball hit the right border
            if (ball.getX() >= (this.getWidth() - ball.getSize())) {
                pl1.incrementScore();
            }

            // check if the ball hit the left border
            if (ball.getX() == 0) {
                pl2.incrementScore();
            }

            // if a player reaches the victoryCond condition, the game will end
            if (pl1.hasWon(victoryCond) || pl2.hasWon(victoryCond)) {
                playing = false;
            }

            // check if pl1 deflected the ball
            if (pl1.deflectedBall(ball.getX(), ball.getY())) {
                ball.moveRight(true);
            }

            // check if pl2 deflected the ball
            if (pl2.deflectedBall(ball.getX(), ball.getY())) {
                ball.moveRight(false);
            }
        }
    }

    /**
     * Start the game loop
     */
    @Override
    public void run() {
        gameLoop();
    }
}
