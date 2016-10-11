package pong;

import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {

    Thread gameLoop;
    boolean playing, gameOver;
    private int victory = 6; // Score required for victory
    private int gameSpeed = 50; // 
    Paddle playerOne = new Paddle(10, 100, 10, 25);
    Paddle playerTwo = new Paddle(230, 100, 10, 25);
    Ball ball = new Ball(100, 100);

    public GamePanel() {
        playing = true;
        gameLoop = new Thread(this);
        gameLoop.start();
    }

    // Draw ball and ships
    @Override
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        // Draw ball
        gc.setColor(Color.black);
        gc.fillOval(ball.getxPos(), ball.getyPos(), ball.getSize(), ball.getSize());

        // Draw Flippers
        gc.fillRect(
                (int) playerOne.getX(), (int) playerOne.getY(),
                (int) playerOne.getWidth(), (int) playerOne.getHeight()
        );
        gc.fillRect(
                (int) playerTwo.getX(), (int) playerTwo.getY(),
                (int) playerTwo.getWidth(), (int) playerTwo.getHeight()
        );

        //Draw scores
        gc.drawString("Player 1: " + playerOne.getScore(), 25, 10);
        gc.drawString("Player 2: " + playerTwo.getScore(), 150, 10);
        if (gameOver) {
            gc.drawString("Game Over", 100, 125);
        }
        repaint();
    }

    public void gameLoop() {
        // TODO Auto-generated method stub
        boolean moveRight = true;
        boolean moveUp = true;

        while (playing) {
            
            /**
             * Delay the game loop (otherwise the game will instantly end)
             * the 
             * 
             */
            try {
                Thread.sleep(gameSpeed);
            } catch (InterruptedException ex) {

            }
            
            // The ball moves from left to right
            if (moveRight) {
                // a la moveRight
                ball.moveRight();
                if (ball.getxPos() >= (this.getWidth() - ball.getSize())) {
                    moveRight = false;
                }
            } else {
                ball.moveLeft();
                if (ball.getxPos() <= 0) {
                    moveRight = true;
                }
            }
            playerOne.move(this.getHeight() - 25);
            playerTwo.move(this.getHeight() - 25);

            // The ball moves from up to down
            if (moveUp) {
                ball.moveUp();
                if (ball.getyPos() >= (this.getHeight() - ball.getSize())) {
                    moveUp = false;
                }

            } else {
                ball.moveDown();
                if (ball.getyPos() <= 0) {
                    moveUp = true;
                }
            }   

            // check if player one scored
            if (ball.getxPos() >= (this.getWidth() - ball.getSize())) {
                playerOne.incrementScore();
            }

            // check if player two scored
            if (ball.getxPos() == 0) {
                playerTwo.incrementScore();
            }

            // if a player reaches the victory condition, the game will end
            if (playerOne.hasWon(victory) || playerTwo.hasWon(victory)) {
                playing = false;
                gameOver = true;
            }

            // check if player one deflected the ball
            if (ball.getxPos() == playerOne.getX() + 10 &&
                    ball.getyPos() >= playerOne.getY() &&
                    ball.getyPos() <= (playerOne.getY() + 25)) {
                moveRight = true;
            }

            // check if player two deflected the ball
            if (ball.getxPos() == (playerTwo.getX() - 5)
                    && ball.getyPos() >= playerTwo.getY()
                    && ball.getyPos() <= (playerTwo.getY() + 25)) {
                moveRight = false;
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
