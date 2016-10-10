package pong;

import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {

    Thread gameLoop;
    boolean playing, gameOver;
    Flipper playerOne = new Flipper(10, 100, 10, 25);
    Flipper playerTwo = new Flipper(230, 100, 10, 25);
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
    public void gameLoop(){
        // TODO Auto-generated method stub
        boolean moveRight = true;
        boolean moveUp = true;

        while (playing) {
            // The ball move from left to right
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

            // Delay
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {

            }

            // The score of the player 1 increase
            if (ball.getxPos() >= (this.getWidth() - ball.getSize())) {
                playerOne.incrementScore();
            }

            // The score of the player 2 increase
            if (ball.getxPos() == 0) {
                playerTwo.incrementScore();
            }

            // Game over. Here you can change 6 to any value
            // When the score reach to the value, the game will end
            if (playerOne.getScore() == 6 || playerTwo.getScore() == 6) {
                playing = false;
                gameOver = true;
            }

            // Player one catches ball
            if (ball.getxPos() == playerOne.getX() + 10 && ball.getyPos() >= playerOne.getY() && ball.getyPos() <= (playerOne.getY() + 25)) {
                moveRight = true;
            }

            // Player two catches ball
            if (ball.getxPos() == (playerTwo.getX() - 5) && ball.getyPos() >= playerTwo.getY() && ball.getyPos() <= (playerTwo.getY() + 25)) {
                moveRight = false;
            }
        }
    }
    @Override
    public void run() {
        gameLoop();
    }
}
